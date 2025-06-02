package se.robertahlin.webshop.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDTO {
    private long id;
    private String name;
    private String description;
    private double price;
    private String imageUrl;
    private int stock;
}