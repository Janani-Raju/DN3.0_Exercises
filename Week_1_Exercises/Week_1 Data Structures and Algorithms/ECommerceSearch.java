import java.util.Arrays;
import java.util.Comparator;

public class ECommerceSearch {

    public static class Product {
        private int productId;
        private String productName;
        private String category;

        // Constructor
        public Product(int productId, String productName, String category) {
            this.productId = productId;
            this.productName = productName;
            this.category = category;
        }

        // Getters
        public int getProductId() {
            return productId;
        }

        public String getProductName() {
            return productName;
        }

        public String getCategory() {
            return category;
        }

        // toString method for printing the product details
        @Override
        public String toString() {
            return "Product{" +
                    "productId=" + productId +
                    ", productName='" + productName + '\'' +
                    ", category='" + category + '\'' +
                    '}';
        }
    }

    // Linear search method
    public static Product linearSearch(Product[] products, String productName) {
        for (Product product : products) {
            if (product.getProductName().equals(productName)) {
                return product;
            }
        }
        return null;
    }

    // Binary search method
    public static Product binarySearch(Product[] products, String productName) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = products[mid].getProductName().compareTo(productName);

            if (comparison == 0) {
                return products[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // Sample products
        Product[] products = {
            new Product(1, "Apple", "Fruit"),
            new Product(2, "Banana", "Fruit"),
            new Product(3, "Carrot", "Vegetable"),
            new Product(4, "Dragonfruit", "Fruit"),
            new Product(5, "Eggplant", "Vegetable")
        };

        // Linear Search
        Product result1 = linearSearch(products, "Carrot");
        if (result1 != null) {
            System.out.println("Linear Search - Product found: " + result1);
        } else {
            System.out.println("Linear Search - Product not found");
        }

        // Sort products by productName for Binary Search
        Arrays.sort(products, Comparator.comparing(Product::getProductName));

        // Binary Search
        Product result2 = binarySearch(products, "Banana");
        if (result2 != null) {
            System.out.println("Binary Search - Product found: " + result2);
        } else {
            System.out.println("Binary Search - Product not found");
        }
    }
}
