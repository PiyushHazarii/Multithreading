import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<Integer> future = executorService.submit(() -> 42);
        Integer i = null;

        try {
            i = future.get();  // waits for the result matlab yaha pr hum wait kr rahe hai 
            // task ka complete hone ka means task complete hone ke baad hi wo aage jayega to 
            System.out.println(future.isDone()); // prints true dega hamesha yaha pr  
            // agar hum future.get() se pehle hi isDone() call karte to false return karta
            System.out.println(i);
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Exception occurred: " + e);
        }

        executorService.shutdown();
    }
}
