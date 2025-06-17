import java.util.concurrent.*;

public class Main4 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Create a thread pool with 2 threads
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // Submit a task that returns the sum of 1 + 2
        Future<Integer> submit = executorService.submit(() -> 1 + 2);

        // Get the result of the computation
        Integer i = submit.get();
        System.out.println("sum is " + i);

        // Shutdown the executor service
        executorService.shutdown();

        // agar shutdown ke baad hum isTerminated() call karte hai to wo false return karega kyuki 
        // turant kr de rahe hai isTerminated() to band hone ka time nhi mil raha hai usko ache se 
        // agar hum Thread.sleep(1) karte hai to wo true return karega

        Thread.sleep(1);
        System.out.println(executorService.isTerminated());
    }
}

