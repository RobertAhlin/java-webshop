package se.robertahlin.webshop.mapper;

import org.springframework.stereotype.Component;
import se.robertahlin.webshop.dto.*;
import se.robertahlin.webshop.model.Product;

@Component
public class ProductMapper {

    public ProductDTO toDto(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        dto.setStockQuantity(product.getStockQuantity());
        dto.setCategory(product.getCategory());
        return dto;
    }

    public Product toEntity(CreateProductRequest req) {
        Product product = new Product();
        product.setName(req.getName());
        product.setDescription(req.getDescription());
        product.setPrice(req.getPrice());
        product.setStockQuantity(req.getStockQuantity());
        product.setCategory(req.getCategory());
        return product;
    }

    public void updateEntityFromRequest(UpdateProductRequest req, Product product) {
        if (req.getName() != null) product.setName(req.getName());
        if (req.getDescription() != null) product.setDescription(req.getDescription());
        if (req.getPrice() != null) product.setPrice(req.getPrice());
        if (req.getStockQuantity() != null) product.setStockQuantity(req.getStockQuantity());
        if (req.getCategory() != null) product.setCategory(req.getCategory());
    }
}
