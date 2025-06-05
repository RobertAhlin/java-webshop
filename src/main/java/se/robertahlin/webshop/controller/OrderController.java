package se.robertahlin.webshop.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.robertahlin.webshop.dto.OrderRequestDTO;
import se.robertahlin.webshop.model.Order;
import se.robertahlin.webshop.service.OrderService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Order> placeOrder(@Valid @RequestBody OrderRequestDTO orderRequestDTO) {
        Order order = orderService.placeOrder(orderRequestDTO.getItems(), orderRequestDTO.getCustomerInfo());
        return ResponseEntity.ok(order);
    }
}
