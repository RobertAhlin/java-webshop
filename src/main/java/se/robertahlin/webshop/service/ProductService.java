package se.robertahlin.webshop.service;

import org.springframework.stereotype.Service;
import se.robertahlin.webshop.dto.*;
import se.robertahlin.webshop.exception.ProductNotFoundException;
import se.robertahlin.webshop.mapper.ProductMapper;
import se.robertahlin.webshop.model.Product;
import se.robertahlin.webshop.repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper mapper;

    public ProductService(ProductRepository productRepository, ProductMapper mapper) {
        this.productRepository = productRepository;
        this.mapper = mapper;
    }

    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public ProductDTO getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
        return mapper.toDto(product);
    }

    public ProductDTO createProduct(CreateProductRequest request) {
        Product product = mapper.toEntity(request);
        Product saved = productRepository.save(product);
        return mapper.toDto(saved);
    }

    public ProductDTO updateProduct(Long id, UpdateProductRequest request) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        mapper.updateEntityFromRequest(request, product);
        return mapper.toDto(productRepository.save(product));
    }

    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException(id);
        }
        productRepository.deleteById(id);
    }
}
