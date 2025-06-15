import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;

public class Main5 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<Integer> submit = executorService.submit(() -> 1 + 2);

        Integer i = submit.get();
        System.out.println("sum is " + i);

        executorService.shutdown();

        Thread.sleep(1000); // Wait for the executor to shut down matlab ki isterminated mein
        // true aayega agar sleep nhi karenge to false aayega.
        System.out.println(executorService.isTerminated());
    }
}