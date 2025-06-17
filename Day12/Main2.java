import java.util.concurrent.CompletableFuture;

public class Main2 {
    public static void main(String[] args) {
        // First asynchronous task
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);  // Simulate delay
                System.out.println("Worker 1");
            } catch (Exception e) {
                // Handle exception
            }
            return "ok";
        });

        // Second asynchronous task
        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);  // Simulate different delay
                System.out.println("Worker 2");
            } catch (Exception e) {
                // Handle exception
            }
            return "ok";
        });

        // Wait for both tasks (f1 and f2) to complete
        CompletableFuture<Void> f = CompletableFuture.allOf(f1, f2);
        f.join();  // Block until both futures are done

        System.out.println("Main");  // This prints after both tasks are done
    }
}
