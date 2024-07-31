class Order {
    int orderId;
    String customerName;
    double totalPrice;

    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerName='" + customerName + '\'' +
                ", totalPrice=" + totalPrice +
                '}';
    }
}

public class OrderSorting {

    // Bubble Sort implementation
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    // Swap orders[j] and orders[j + 1]
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    // Quick Sort implementation
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        Order pivot = orders[high];
        int i = (low - 1); // Index of smaller element
        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice < pivot.totalPrice) {
                i++;
                // Swap orders[i] and orders[j]
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        // Swap orders[i + 1] and orders[high] (or pivot)
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        // Test case: array of orders
        Order[] orders = {
            new Order(1, "Alice", 250.75),
            new Order(2, "Bob", 120.50),
            new Order(3, "Charlie", 500.00),
            new Order(4, "David", 300.20),
            new Order(5, "Eve", 150.30)
        };

        // Display original orders
        System.out.println("Original orders:");
        for (Order order : orders) {
            System.out.println(order);
        }

        // Sort orders using Bubble Sort
        bubbleSort(orders);
        System.out.println("\nOrders sorted by Bubble Sort:");
        for (Order order : orders) {
            System.out.println(order);
        }

        // Reset orders for Quick Sort test
        orders = new Order[]{
            new Order(1, "Alice", 250.75),
            new Order(2, "Bob", 120.50),
            new Order(3, "Charlie", 500.00),
            new Order(4, "David", 300.20),
            new Order(5, "Eve", 150.30)
        };

        // Sort orders using Quick Sort
        quickSort(orders, 0, orders.length - 1);
        System.out.println("\nOrders sorted by Quick Sort:");
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}
