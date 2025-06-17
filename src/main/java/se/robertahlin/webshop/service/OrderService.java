package se.robertahlin.webshop.service;

import org.springframework.stereotype.Service;
import se.robertahlin.webshop.model.*;
import se.robertahlin.webshop.repository.OrderRepository;
import se.robertahlin.webshop.repository.ProductRepository;
import se.robertahlin.webshop.exception.ProductNotFoundException;
import se.robertahlin.webshop.exception.InsufficientStockException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    public Order placeOrder(List<OrderItem> orderItems, CustomerInfo customerInfo) {
        List<OrderItem> validatedItems = new ArrayList<>();
        double totalAmount = 0.0;

        for (OrderItem item : orderItems) {
            Product product = productRepository.findById(item.getProductId())
                    .orElseThrow(() -> new ProductNotFoundException(item.getProductId()));

            if (item.getQuantity() > product.getStock()) {
                throw new InsufficientStockException(
                        product.getName(),
                        item.getQuantity(),
                        product.getStock()
                );
            }

            double itemTotal = product.getPrice() * item.getQuantity();
            totalAmount += itemTotal;

            product.setStock(product.getStock() - item.getQuantity());
            productRepository.save(product);

            validatedItems.add(new OrderItem(
                    item.getProductId(),
                    item.getQuantity(),
                    product.getPrice()
            ));
        }

        Order order = new Order(
                UUID.randomUUID().toString(),
                customerInfo,
                validatedItems,
                totalAmount,
                LocalDateTime.now()
        );

        orderRepository.save(order);
        return order;
    }
}
