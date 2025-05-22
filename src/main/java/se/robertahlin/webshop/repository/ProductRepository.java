package se.robertahlin.webshop.repository;

import org.springframework.stereotype.Repository;
import se.robertahlin.webshop.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {

    private final List<Product> products = new ArrayList<>();

    public ProductRepository() {
        products.add(new Product(1, "Coffee Mug", "A stylish ceramic mug.", 99.0, "https://example.com/mug.jpg", 20));
        products.add(new Product(2, "T-shirt", "Black cotton t-shirt.", 199.0, "https://example.com/shirt.jpg", 15));
        products.add(new Product(3, "Laptop Stand", "Ergonomic stand for laptops.", 349.0, "https://example.com/stand.jpg", 10));
        products.add(new Product(4, "Headphones", "Wireless over-ear headphones.", 899.0, "https://example.com/headphones.jpg", 5));
        products.add(new Product(5, "Notebook", "A5 lined notebook.", 49.0, "https://example.com/notebook.jpg", 30));
    }

    public List<Product> findAll() {
        return products;
    }

    public Optional<Product> findById(long id) {
        return products.stream()
                .filter(p -> p.getId() == id)
                .findFirst();
    }
}
