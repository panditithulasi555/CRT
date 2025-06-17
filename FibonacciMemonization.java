import java.util.HashMap;

public class FibonacciMemoization {

    private static HashMap<Integer, Integer> memo = new HashMap<>();

    public static int fibonacci(int n) {
        // Base case
        if (n <= 1) return n;

        // If already computed, return the value
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        // Recursive call with memoization
        int result = fibonacci(n - 1) + fibonacci(n - 2);
        memo.put(n, result);

        return result;
    }

    public static void main(String[] args) {
        int n = 10; // Example input
        System.out.println("Fibonacci of " + n + " is: " + fibonacci(n));
    }
}