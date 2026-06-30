public class Main {
    public static void main(String[] args) {
        System.out.println("Testing Singleton Pattern implementation:\n");

        // Attempting to get multiple instances
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Testing the log method
        logger1.log("This is the first log message.");
        logger2.log("This is the second log message.");

        System.out.println();

        // Verifying if both instances are exactly the same object in memory
        if (logger1 == logger2) {
            System.out.println("Success: Both logger1 and logger2 refer to the same instance!");
            System.out.println("logger1 hashcode: " + logger1.hashCode());
            System.out.println("logger2 hashcode: " + logger2.hashCode());
        } else {
            System.out.println("Failure: Different instances exist.");
        }
    }
}
