package se.robertahlin.webshop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {
    private long productId;
    private int quantity;
    private double priceAtPurchase;
}
