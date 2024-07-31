public class DecoratorPatternExample {

    // 2. Define Component Interface
    interface Notifier {
        void send(String message);
    }

    // 3. Implement Concrete Component
    static class EmailNotifier implements Notifier {
        @Override
        public void send(String message) {
            System.out.println("Sending Email: " + message);
        }
    }

    // 4. Implement Decorator Classes
    // Abstract Decorator Class
    abstract static class NotifierDecorator implements Notifier {
        protected Notifier decoratedNotifier;

        public NotifierDecorator(Notifier decoratedNotifier) {
            this.decoratedNotifier = decoratedNotifier;
        }

        @Override
        public void send(String message) {
            decoratedNotifier.send(message);
        }
    }

    // Concrete Decorator Classes
    static class SMSNotifierDecorator extends NotifierDecorator {
        public SMSNotifierDecorator(Notifier decoratedNotifier) {
            super(decoratedNotifier);
        }

        @Override
        public void send(String message) {
            super.send(message); // Call the original notifier
            System.out.println("Sending SMS: " + message);
        }
    }

    static class SlackNotifierDecorator extends NotifierDecorator {
        public SlackNotifierDecorator(Notifier decoratedNotifier) {
            super(decoratedNotifier);
        }

        @Override
        public void send(String message) {
            super.send(message); // Call the original notifier
            System.out.println("Sending Slack message: " + message);
        }
    }

    // 5. Test the Decorator Implementation
    public static void main(String[] args) {
        // Create an EmailNotifier
        Notifier emailNotifier = new EmailNotifier();

        // Decorate with SMSNotifierDecorator
        Notifier smsEmailNotifier = new SMSNotifierDecorator(emailNotifier);

        // Further decorate with SlackNotifierDecorator
        Notifier slackSmsEmailNotifier = new SlackNotifierDecorator(smsEmailNotifier);

        // Send notifications
        slackSmsEmailNotifier.send("Hello World!");
    }
}
