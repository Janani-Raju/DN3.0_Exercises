public class FinancialForecasting {

    // Recursive method to calculate future value
    public static double calculateFutureValueRecursive(double currentValue, double growthRate, int years) {
        // Base case: if years is 0, return the current value
        if (years == 0) {
            return currentValue;
        }
        // Recursive case: calculate future value for one less year
        return (1 + growthRate) * calculateFutureValueRecursive(currentValue, growthRate, years - 1);
    }

    public static void main(String[] args) {
        double currentValue = 1000.0; // Initial investment
        double growthRate = 0.05; // 5% annual growth rate
        int years = 10; // Number of years

        double futureValueRecursive = calculateFutureValueRecursive(currentValue, growthRate, years);
        System.out.println("Future Value after " + years + " years (Recursive): " + futureValueRecursive);
    }
}
