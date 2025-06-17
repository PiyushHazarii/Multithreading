import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Main7 {
    public static void main(String[] args) {
        int numberOfSubsystems = 4;

        // Define a CyclicBarrier with a barrier action that executes once all threads reach the barrier
        CyclicBarrier barrier = new CyclicBarrier(numberOfSubsystems, new Runnable() {
            @Override
            public void run() {
                // This action will be run once all threads reach the barrier
                System.out.println("All subsystems are up and running. System startup complete.");
            }
        });

        // Create threads for each subsystem
        Thread webServerThread = new Thread(new Subsystem("Web Server", 2000, barrier));
        Thread databaseThread = new Thread(new Subsystem("Database", 4000, barrier));
        Thread cacheThread = new Thread(new Subsystem("Cache", 3000, barrier));
        Thread messagingServiceThread = new Thread(new Subsystem("Messaging Service", 3500, barrier));

        // Start each thread
        webServerThread.start();
        databaseThread.start();
        cacheThread.start();
        messagingServiceThread.start();
    }
}

class Subsystem implements Runnable {
    private final String name;
    private final int initializationTime; // in milliseconds
    private final CyclicBarrier barrier;

    public Subsystem(String name, int initializationTime, CyclicBarrier barrier) {
        this.name = name;
        this.initializationTime = initializationTime;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " initialization started...");
            Thread.sleep(initializationTime); // Simulate initialization work
            System.out.println(name + " initialization complete. Waiting at barrier...");

            barrier.await(); // Wait for other subsystems

            // All subsystems passed the barrier
            System.out.println(name + " proceeding with normal operation.");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
