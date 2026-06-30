public class Main {
    public static void main(String[] args) {
        double presentValue = 1000.0;
        double growthRate = 0.05; // 5% growth rate
        int periods = 10; // Forecast for 10 periods

        System.out.println("--- Financial Forecasting Tool ---");
        System.out.println("Initial Value: $" + presentValue);
        System.out.println("Growth Rate: " + (growthRate * 100) + "%");
        System.out.println("Periods: " + periods + " years\n");

        // Using standard recursion
        double standardResult = FinancialForecaster.predictFutureValue(presentValue, growthRate, periods);
        System.out.printf("Standard Recursive Future Value: $%.2f%n", standardResult);

        // Using optimized recursion (memoization)
        double optimizedResult = FinancialForecaster.predictFutureValueOptimized(presentValue, growthRate, periods);
        System.out.printf("Optimized (Memoized) Future Value: $%.2f%n", optimizedResult);
    }
}
