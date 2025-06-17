import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
        // Create a CompletableFuture that runs asynchronously and returns a string
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000); // Simulate time-consuming task
                System.out.println("Worker"); // Print when work is done
            } catch (Exception e) {
                // Handle exceptions from the async task
            }
            return "ok"; // Return result of the async task
        });

        String s = null;
        try {
            // Wait for the result of the CompletableFuture
            // .get nhi daalte hai to main thread immediately continues without waiting
            // matlab worker and ok print nhi hoga kyuki main thread wait nhi karega direct execute ho 
            // ho jayega agar wait krwana hai to .get() lagana padega.
            s = completableFuture.get();
        } catch (InterruptedException e) {
            // If the current thread is interrupted while waiting
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            // If the computation threw an exception
            throw new RuntimeException(e);
        }

        System.out.println(s);     // Print the result from the async task
        System.out.println("Main"); // Indicate that main thread execution continues
    }
}
