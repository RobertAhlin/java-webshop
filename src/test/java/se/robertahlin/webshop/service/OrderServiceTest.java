package se.robertahlin.webshop.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.robertahlin.webshop.exception.ProductNotFoundException;
import se.robertahlin.webshop.model.*;
import se.robertahlin.webshop.repository.OrderRepository;
import se.robertahlin.webshop.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OrderServiceTest {

    private OrderService orderService;
    private OrderRepository orderRepository;
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        orderRepository = mock(OrderRepository.class);
        productRepository = mock(ProductRepository.class);
        orderService = new OrderService(orderRepository, productRepository);
    }

    @Test
    void shouldPlaceOrderSuccessfully() {
        // Skapar en produkt med pris 349 och 5 i lager
        long productId = 1L;
        Product product = new Product(productId, "Laptop Stand", "Ergonomic stand", 349.0, "", 5);
        when(productRepository.findById(productId)).thenReturn(Optional.of(product));

        CustomerInfo customer = new CustomerInfo("Alice", "123 Java Street", "alice@example.com");
        OrderItem item = new OrderItem(productId, 2, 0.0); // price is set later
        List<OrderItem> items = List.of(item);

        // Kör själva testet
        Order order = orderService.placeOrder(items, customer);

        // Verifiera resultat
        assertNotNull(order.getId());
        assertEquals(2, order.getItems().getFirst().getQuantity());
        assertEquals(349.0, order.getItems().getFirst().getPriceAtPurchase());
        assertEquals(698.0, order.getTotalAmount());
        assertNotNull(order.getOrderDate());

        verify(orderRepository).save(order);
    }

    @Test
    void shouldThrowExceptionIfProductNotFound() {
        // Skapa test med produkt 999
        long productId = 999L;
        when(productRepository.findById(productId)).thenReturn(Optional.empty());

        CustomerInfo customer = new CustomerInfo("Bob", "456 Spring Ave", "bob@example.com");
        OrderItem item = new OrderItem(productId, 1, 0.0);
        List<OrderItem> items = List.of(item);

        // Testa och verifiera
        assertThrows(ProductNotFoundException.class, () -> {
            orderService.placeOrder(items, customer);
        });

        verify(orderRepository, never()).save(any());
    }
}
