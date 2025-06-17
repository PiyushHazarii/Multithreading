import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Main8 {
    public static void main(String[] args) {
        // Create a fixed thread pool
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // Define 3 callables
        Callable<Integer> callable1 = () -> {
            TimeUnit.SECONDS.sleep(1);
            return 1;
        };

        Callable<Integer> callable2 = () -> {
            TimeUnit.SECONDS.sleep(1);
            return 2;
        };

        Callable<Integer> callable3 = () -> {
            TimeUnit.SECONDS.sleep(1);
            return 3;
        };

        // Add them to a list
        List<Callable<Integer>> list = Arrays.asList(callable1, callable2, callable3);

        try {
            // Returns the result of the fastest successful task
            // means ye direct integer dega matlab jo pehele 
            // execute hoga uska result dega ye bus 
            Integer i = executorService.invokeAny(list);
            System.out.println("First completed result: " + i);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } finally {
            executorService.shutdown();
        }
    }
}
