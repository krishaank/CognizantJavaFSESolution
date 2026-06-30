import java.util.HashMap;
import java.util.Map;

public class FinancialForecaster {

    // 1. Standard recursive approach
    // Time Complexity: O(n) where n is the number of periods
    public static double predictFutureValue(double presentValue, double growthRate, int periods) {
        // Base case: 0 periods remaining
        if (periods == 0) {
            return presentValue;
        }
        // Recursive case
        return predictFutureValue(presentValue, growthRate, periods - 1) * (1 + growthRate);
    }

    // 2. Optimized recursive approach using Memoization
    // Caches the results of subproblems to avoid redundant calculations
    private static Map<Integer, Double> memoMap = new HashMap<>();

    public static double predictFutureValueOptimized(double presentValue, double growthRate, int periods) {
        // Base case
        if (periods == 0) {
            return presentValue;
        }
        
        // If we've already computed the value for this specific number of periods, return it
        if (memoMap.containsKey(periods)) {
            return memoMap.get(periods);
        }
        
        // Otherwise, compute it recursively
        double value = predictFutureValueOptimized(presentValue, growthRate, periods - 1) * (1 + growthRate);
        
        // Cache the result before returning
        memoMap.put(periods, value);
        
        return value;
    }
}
