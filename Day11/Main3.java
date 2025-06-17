import java.util.concurrent.*;

public class Main3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Future<String> future1 = executorService.submit(new DependentService());
        Future<String> future2 = executorService.submit(new DependentService());
        Future<String> future3 = executorService.submit(new DependentService());

        // here in this we have to call get method every time if there are 100 futures then
        // we have to call get method 100 times here to solve this we have solutions 
        future1.get();  // waits for first task to complete
        future2.get();  // waits for second task
        future3.get();  // waits for third task

        System.out.println("All dependent services finished. Starting main service...");
        executorService.shutdown();
    }
}


class DependentService implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " service started.");
        Thread.sleep(2000); // simulate some delay
        return "ok";
    }
}

