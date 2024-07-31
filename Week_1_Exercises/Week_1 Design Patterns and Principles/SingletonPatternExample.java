public class SingletonPatternExample {

    // Singleton Logger class
    static class Logger {

        // Private static instance of the class (eager initialization)
        private static final Logger instance = new Logger();

        // Private constructor to prevent instantiation
        private Logger() {
            // Initialization code here (if any)
        }

        // Public static method to get the single instance of the class
        public static Logger getInstance() {
            return instance;
        }

        // Example method to log messages
        public void log(String message) {
            System.out.println("Log: " + message);
        }
    }

    public static void main(String[] args) {
        // Obtain two instances of Logger
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        
        // Log some messages
        logger1.log("This is the first log message.");
        logger2.log("This is the second log message.");

        // Check if both instances are the same
        if (logger1 == logger2) {
            System.out.println("Logger is a singleton. Both instances are the same.");
        } else {
            System.out.println("Logger is not a singleton. Different instances.");
        }
    }
}
