package se.robertahlin.webshop.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import se.robertahlin.webshop.model.CustomerInfo;
import se.robertahlin.webshop.model.OrderItem;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequestDTO {

    @NotNull(message = "Customer info is required")
    private CustomerInfo customerInfo;

    @NotEmpty(message = "Order must contain at least one item")
    private List<OrderItem> items;
}
