package se.robertahlin.webshop.dto;

import lombok.Data;

@Data
public class UpdateProductDTO {
    private String name;
    private String description;
    private Double price;
    private String category;
    private Integer stockQuantity;
    private String imageUrl;
}
