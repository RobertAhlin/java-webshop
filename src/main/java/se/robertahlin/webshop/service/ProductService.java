package se.robertahlin.webshop.service;

import org.springframework.stereotype.Service;
import se.robertahlin.webshop.model.Product;
import se.robertahlin.webshop.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(long id) {
        return productRepository.findById(id);
    }
}
