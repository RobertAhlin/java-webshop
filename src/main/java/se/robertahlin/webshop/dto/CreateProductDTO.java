package se.robertahlin.webshop.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CreateProductDTO {

    @NotBlank(message = "Name is required")
    private String name;

    private String description;

    @Positive(message = "Price must be positive")
    private double price;

    @Min(value = 0, message = "Stock quantity must be 0 or greater")
    private int stockQuantity;

    private String category;

    private String imageUrl;
}
