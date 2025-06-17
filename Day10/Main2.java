import java.util.concurrent.*;

public class Main2 {
    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<Integer> future = executorService.submit(() -> {
            try {
                Thread.sleep(2000); // Sleep for 2 seconds
            } catch (InterruptedException e) {
                System.out.println("Exception occurred: " + e);
            }
            return 42;
        });
        // System.out.println(future.get());
        
        // future.cancel(true); // agar ye true hai to chahe chal raha ho task ya nahi chal raha ho to bhi wo 
                             // task ko cancel karega.
        future.cancel(false); // agar ye false hai to jo task chal raha hai usko interrupt nahi karega.

        System.out.println(future.isCancelled()); // true if task was cancelled
        System.out.println(future.isDone());      // true if task is done (completed or cancelled)

        executorService.shutdown();
    }
}

