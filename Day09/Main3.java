import java.util.concurrent.*;

public class Main3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Create an ExecutorService with a single thread
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // Submit a Callable task that returns 42
        // yaha pr future mein hum kuch bhi daal skte hai ? mark bhi daal skte hai usse
        // hum kuch bhi return kare farak nahi padega sab accept karega 
        Future<Double> future = executorService.submit(() -> 42.2);

        // Retrieve and print the result
        System.out.println(future.get());

        // ye true or false return karega means agar task complete ho gaya hai to true return karega
        if(future.isDone()) {
            System.out.println("Task is done");
        } else {
            System.out.println("Task is not done yet");
        }

        // Shutdown the executor
        executorService.shutdown();
    }
}
