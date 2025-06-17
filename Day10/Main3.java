import java.util.concurrent.*;

public class Main3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Create a single-threaded executor
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // yaha pr hum result de rahe hai sout ke baad jo ki success hai and usko future ke 
        // help se print kr de rahe hai 
        Future<String> result = executorService.submit(() -> System.out.println("Hello"), "success");
        System.out.println(result.get()); // prints "success"


        // Shutdown the executor
        executorService.shutdown();
    }
}
