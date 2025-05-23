package se.robertahlin.webshop.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.robertahlin.webshop.dto.OrderRequest;
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
    public ResponseEntity<Order> placeOrder(@Valid @RequestBody OrderRequest orderRequest) {
        Order order = orderService.placeOrder(orderRequest.getItems(), orderRequest.getCustomerInfo());
        return ResponseEntity.ok(order);
    }
}
