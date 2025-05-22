package se.robertahlin.webshop.service;

import org.springframework.stereotype.Service;
import se.robertahlin.webshop.model.*;
import se.robertahlin.webshop.repository.OrderRepository;
import se.robertahlin.webshop.repository.ProductRepository;

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
                    .orElseThrow(() -> new IllegalArgumentException("Product with ID " + item.getProductId() + " not found"));

            double itemTotal = product.getPrice() * item.getQuantity();
            totalAmount += itemTotal;

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
