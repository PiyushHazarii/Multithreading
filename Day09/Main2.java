import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main2 {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        // Create a thread pool with 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Submit tasks to calculate factorials from 1 to 9
        for (int i = 1; i < 10; i++) {
            int finalI = i;
            executor.submit(() -> {
                long result = factorial(finalI);
                System.out.println("Factorial of " + finalI + " is: " + result);
            });
        }

        // Shutdown the executor (no new tasks will be accepted)
        executor.shutdown();

        // This line should not be here after shutdown, kept to show mistake from image
        // executor.submit(() -> System.out.println("wsw")); // ❌ This will throw RejectedExecutionException if executed after shutdown

        // To calculate total time after all tasks complete, you'd ideally use awaitTermination or a CountDownLatch
        System.out.println("Total time: " + (System.currentTimeMillis() - startTime) + " ms");
        try {
            // ye awaitTermination method boolean value return karega ya to true ya false
            executor.awaitTermination(100, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Print total execution time
        System.out.println("Total time: " + (System.currentTimeMillis() - startTime) + " ms");
    }

    // Factorial method
    public static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
