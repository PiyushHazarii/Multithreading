import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Main6 {
    public static void main(String[] args) {

        // Callable instances
        Callable<Integer> callable1 = () -> {
            System.out.println("Task 1");
            return 1;
        };

        Callable<Integer> callable2 = () -> {
            System.out.println("Task 2");
            return 2;
        };

        Callable<Integer> callable3 = () -> {
            System.out.println("Task 3");
            return 3;
        };

        // Create a list of Callables
        List<Callable<Integer>> list = Arrays.asList(callable1, callable2, callable3);

        // Create an ExecutorService
        ExecutorService executorService = Executors.newFixedThreadPool(3); // You can adjust the pool size

        try {
            // Invoke all Callables and get a list of Futures
            // collection of task le raha hai and usko execute kr raha hai
            // and return a list of Future objects
            List<Future<Integer>> futures = executorService.invokeAll(list);

            // Iterate through the Futures and get the results
            for (Future<Integer> f : futures) {
                System.out.println(f.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            // Shutdown the ExecutorService
            executorService.shutdown();
            System.out.println("Hello world");
        }
    }
}