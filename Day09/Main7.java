import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

// NOTE IT WILL NEVER TERMINATE, IT WILL RUN INFINITELY
// WE HAVE TO FORCEFULLY TERMINATE IT OR SHUTDOWN IT.
public class Main7 {

    public static void main(String[] args) {

        // Create a thread pool with 9 threads
        Executor executor = Executors.newFixedThreadPool(9);

        // Submit 9 tasks to calculate factorial of numbers 1 to 9
        for (int i = 1; i < 10; i++) {
            int finalI = i; // effectively final for lambda use

            // it also doesnot have shutdown method,
            // it doesnot have submit method, so we are using execute method
            executor.execute(() -> {
                long result = factorial(finalI);
                System.out.println("Factorial of " + finalI + " = " + result);
            });
        }
    }

    // Function to calculate factorial
    public static long factorial(int n) {
        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}
