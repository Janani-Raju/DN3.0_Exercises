public class AdapterPatternExample {

    // 1. Define Target Interface
    interface PaymentProcessor {
        void processPayment(double amount);
    }

    // 2. Implement Adaptee Classes
    static class PayPalPaymentGateway {
        public void makePayment(double amount) {
            System.out.println("Processing payment of $" + amount + " through PayPal.");
        }
    }

    static class StripePaymentGateway {
        public void charge(double amount) {
            System.out.println("Charging $" + amount + " through Stripe.");
        }
    }

    // 3. Implement the Adapter Class
    static class PayPalAdapter implements PaymentProcessor {
        private PayPalPaymentGateway payPalPaymentGateway;

        public PayPalAdapter(PayPalPaymentGateway payPalPaymentGateway) {
            this.payPalPaymentGateway = payPalPaymentGateway;
        }

        @Override
        public void processPayment(double amount) {
            payPalPaymentGateway.makePayment(amount);
        }
    }

    static class StripeAdapter implements PaymentProcessor {
        private StripePaymentGateway stripePaymentGateway;

        public StripeAdapter(StripePaymentGateway stripePaymentGateway) {
            this.stripePaymentGateway = stripePaymentGateway;
        }

        @Override
        public void processPayment(double amount) {
            stripePaymentGateway.charge(amount);
        }
    }

    // 4. Test the Adapter Implementation
    public static void main(String[] args) {
        // Create instances of payment gateways
        PayPalPaymentGateway payPalGateway = new PayPalPaymentGateway();
        StripePaymentGateway stripeGateway = new StripePaymentGateway();

        // Create adapters for the payment gateways
        PaymentProcessor payPalAdapter = new PayPalAdapter(payPalGateway);
        PaymentProcessor stripeAdapter = new StripeAdapter(stripeGateway);

        // Process payments using adapters
        payPalAdapter.processPayment(150.00);
        stripeAdapter.processPayment(200.00);
    }
}
