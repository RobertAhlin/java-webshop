package se.robertahlin.webshop.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.robertahlin.webshop.exception.ProductNotFoundException;
import se.robertahlin.webshop.mapper.ProductMapper;
import se.robertahlin.webshop.model.Product;
import se.robertahlin.webshop.repository.ProductRepository;
import se.robertahlin.webshop.dto.ProductDTO;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceTest {

    private ProductService productService;
    private ProductRepository productRepository;
    private ProductMapper productMapper;

    @BeforeEach
    void setUp() {
        productRepository = mock(ProductRepository.class);
        productMapper = mock(ProductMapper.class);
        productService = new ProductService(productRepository, productMapper);
    }

    @Test
    void shouldReturnProductWhenIdExists() {
        // Arrange
        Product product = new Product(1, "Test", "Desc", 99.0, "", 10);
        ProductDTO productDTO = new ProductDTO();

        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        when(productMapper.toDto(product)).thenReturn(productDTO);

        // Act
        ProductDTO result = productService.getProductById(1L);

        // Assert
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Test", result.getName());
    }

    @Test
    void shouldThrowExceptionWhenProductNotFound() {
        // Arrange
        when(productRepository.findById(99L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(ProductNotFoundException.class, () -> {
            productService.getProductById(99L);
        });
    }
}
