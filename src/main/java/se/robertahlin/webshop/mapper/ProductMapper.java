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
        dto.setImageUrl(product.getImageUrl());
        dto.setStock(product.getStock());
        return dto;
    }

    public Product toEntity(CreateProductDTO req) {
        Product product = new Product();
        product.setName(req.getName());
        product.setDescription(req.getDescription());
        product.setPrice(req.getPrice());
        product.setImageUrl(req.getImageUrl());
        product.setStock(req.getStockQuantity());
        return product;
    }

    public void updateEntityFromRequest(UpdateProductDTO req, Product product) {
        if (req.getName() != null) product.setName(req.getName());
        if (req.getDescription() != null) product.setDescription(req.getDescription());
        if (req.getPrice() != null) product.setPrice(req.getPrice());
        if (req.getImageUrl() != null) product.setImageUrl(req.getImageUrl());
        if (req.getStockQuantity() != null) product.setStock(req.getStockQuantity());
    }
}
