public class Logger {
    // 1. Private static instance of itself
    private static Logger instance;

    // 2. Private constructor to prevent instantiation from outside
    private Logger() {
    }

    // 3. Public static method to get the instance
    public static Logger getInstance() {
        // Double-checked locking for thread safety
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    // A sample method to demonstrate logging
    public void log(String message) {
        System.out.println("[LOG]: " + message);
    }
}
