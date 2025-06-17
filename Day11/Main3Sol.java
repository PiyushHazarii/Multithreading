import java.util.concurrent.*;

public class Main3Sol {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int numberOfServices = 3;

        // Create a thread pool with fixed number of threads
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfServices);

        // Create a CountDownLatch with count equal to number of services
        // iske constructor me hum number of services pass karte hai
        // aur ye count karega kitna serive hum diye hai krke 
        // agar hum 3 services diye hai to ye pehele 3 phir 2 phir 1 karega and 
        // then jab 0 ho jayega to main thread ko proceed karne dega.
        CountDownLatch latch = new CountDownLatch(numberOfServices);

        // Submit 3 tasks
        executorService.submit(new DependentService(latch));
        executorService.submit(new DependentService(latch));
        executorService.submit(new DependentService(latch));

        // Main thread waits until all services call countDown() 
        // ye sara number of services ke complete hobe ke baad hi main thread ko proceed karega
        latch.await();

        System.out.println("Main thread proceeding...");

        executorService.shutdown();
    }
}

// Callable task that simulates a service
class DependentService implements Callable<String> {
    private final CountDownLatch latch;

    public DependentService(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public String call() throws Exception {
        try {
            System.out.println(Thread.currentThread().getName() + " service started.");
            Thread.sleep(2000); // simulate some work
        } finally {
            latch.countDown(); // decrement latch
        }
        return "ok";
    }
}
