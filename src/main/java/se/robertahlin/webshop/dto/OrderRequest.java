package se.robertahlin.webshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import se.robertahlin.webshop.model.CustomerInfo;
import se.robertahlin.webshop.model.OrderItem;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {
    private CustomerInfo customerInfo;
    private List<OrderItem> items;
}
