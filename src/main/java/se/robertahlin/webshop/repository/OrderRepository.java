package se.robertahlin.webshop.repository;

import org.springframework.stereotype.Repository;
import se.robertahlin.webshop.model.Order;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository {

    private final List<Order> orders = new ArrayList<>();

    public void save(Order order) {
        orders.add(order);
    }

    public List<Order> findAll() {
        return orders;
    }
}
