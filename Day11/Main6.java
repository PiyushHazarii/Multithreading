import java.util.concurrent.*;

public class Main6 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int numberOfServices = 3; // Total number of threads that will wait at the barrier

        // Create a fixed thread pool with 3 threads
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfServices);

        // Create a CyclicBarrier that waits until 3 threads reach it
        CyclicBarrier barrier = new CyclicBarrier(numberOfServices);

        // Submit 3 tasks (DependentService) to the executor, each using the same barrier
        executorService.submit(new DependentService(barrier));
        executorService.submit(new DependentService(barrier));
        executorService.submit(new DependentService(barrier));

        // This will print immediately after submitting the tasks
        System.out.println("Main");

        // Shutdown the executor after task submission
        executorService.shutdown();
    }
}

// This class represents a service that must wait for other services before proceeding
class DependentService implements Runnable {

    private final CyclicBarrier barrier;

    // Constructor takes the shared barrier
    public DependentService(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            // Simulate initial work before reaching the barrier
            System.out.println(Thread.currentThread().getName() + " is doing some work before barrier");
            Thread.sleep((long) (Math.random() * 3000));  // Random delay to simulate varying work time

            // This message is printed just before waiting at the barrier
            System.out.println(Thread.currentThread().getName() + " waiting at the barrier");

            // Wait at the barrier until all other threads reach this point
            barrier.await();  // All 3 threads must call this to proceed

            // Once all threads have reached the barrier, they all continue
            System.out.println(Thread.currentThread().getName() + " passed the barrier and continues");
        } catch (InterruptedException | BrokenBarrierException e) {
            // Handle exceptions related to thread interruption or barrier failure
            e.printStackTrace();
        }
    }
}
