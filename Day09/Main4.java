import java.util.concurrent.*;

public class Main4 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // collable mein return type hota hai means isme andar hai return kr skte hai hum kuch
        // but runnable mein return kuch hota hi nhi hai essi liye agar hum runnable use kare to
        // to wo error dikha raha hai but collable mein sab sahi se chal raha hai 
        Callable<String> callable = () -> "Hello";

        Future<String> future = executorService.submit(callable);

        System.out.println(future.get());

        executorService.shutdown();
    }
}
