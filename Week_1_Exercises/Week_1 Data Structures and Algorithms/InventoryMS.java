

import java.util.HashMap;
import java.util.Map;

class Product {
    private int productId;
    private String productName;
    private int quantity;
    private double price;

    // Constructor
    public Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters and Setters
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

public class InventoryMS {
    private Map<Integer, Product> inventory = new HashMap<>();

    // Add a product
    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
    }

    // Update a product
    public void updateProduct(int productId, String name, int quantity, double price) {
        Product product = inventory.get(productId);
        if (product != null) {
            product.setProductName(name);
            product.setQuantity(quantity);
            product.setPrice(price);
        }
    }

    // Delete a product
    public void deleteProduct(int productId) {
        inventory.remove(productId);
    }

    // Get a product
    public Product getProduct(int productId) {
        return inventory.get(productId);
    }

    // Main method for testing
    public static void main(String[] args) {
        InventoryMS ims = new InventoryMS();

        // Adding products
        Product product1 = new Product(1, "Product A", 100, 10.5);
        Product product2 = new Product(2, "Product B", 50, 20.0);

        ims.addProduct(product1);
        ims.addProduct(product2);

        // Updating a product
        ims.updateProduct(1, "Product A Updated", 150, 15.0);

        // Deleting a product
        ims.deleteProduct(2);

        // Retrieving a product
        Product retrievedProduct = ims.getProduct(1);
        System.out.println("Retrieved Product: " + retrievedProduct.getProductName() + ", Quantity: " + retrievedProduct.getQuantity() + ", Price: " + retrievedProduct.getPrice());
    }
}
