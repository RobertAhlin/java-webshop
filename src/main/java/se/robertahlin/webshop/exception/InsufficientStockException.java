package se.robertahlin.webshop.exception;

public class InsufficientStockException extends RuntimeException {
    public InsufficientStockException(String productName, int requested, int available) {
        super("Product '" + productName + "' has only " + available +
                " item(s) in stock, but requested: " + requested + ".");
    }
}