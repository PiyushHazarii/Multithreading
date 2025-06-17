import java.util.concurrent.*;

public class Main5 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int numberOfServices = 3;

        ExecutorService executorService = Executors.newFixedThreadPool(numberOfServices);
        CountDownLatch latch = new CountDownLatch(numberOfServices);

        executorService.submit(new DependentService(latch));
        executorService.submit(new DependentService(latch));
        executorService.submit(new DependentService(latch));

        // Wait for maximum 5 seconds for all services to complete
        boolean completed = latch.await(5, TimeUnit.SECONDS);

        if (completed) {
            System.out.println("All services completed in time.");
        } else {
            System.out.println("Timeout! Not all services finished.");
        }

        System.out.println("Main thread proceeding...");
        executorService.shutdownNow(); // Force shutdown if still running
    }
}

// Task simulating some work
class DependentService implements Callable<String> {
    private final CountDownLatch latch;

    public DependentService(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public String call() throws Exception {
        try {
            System.out.println(Thread.currentThread().getName() + " service started.");
            Thread.sleep(6000); // Simulate work
        } finally {
            latch.countDown();
        }
        return "ok";
    }
}
