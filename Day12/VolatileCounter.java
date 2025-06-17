// Importing the AtomicInteger class from the java.util.concurrent.atomic package
// This class provides thread-safe operations on integers
import java.util.concurrent.atomic.AtomicInteger;

public class VolatileCounter {

    // Declaring an AtomicInteger counter, initialized to 0
    // AtomicInteger ensures atomic (thread-safe) operations like increment
    private AtomicInteger counter = new AtomicInteger(0);

    // Method to increment the counter atomically
    public void increment() {
        // incrementAndGet() increments the value by 1 and returns the new value
        counter.incrementAndGet();
    }

    // Method to get the current value of the counter
    public int getCounter() {
        // get() returns the current value of the AtomicInteger
        return counter.get();
    }

    public static void main(String[] args) throws InterruptedException {
        // Creating an instance of VolatileCounter to be shared between threads
        VolatileCounter vc = new VolatileCounter();

        // Creating the first thread (t1) to increment the counter 1000 times
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                vc.increment(); // Safe increment using AtomicInteger
            }
        });

        // Creating the second thread (t2) to also increment the counter 1000 times
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                vc.increment(); // Safe increment using AtomicInteger
            }
        });

        // Start both threads so they run concurrently
        t1.start();
        t2.start();

        // Wait for both threads to finish their execution before proceeding
        t1.join(); // Wait for t1 to complete
        t2.join(); // Wait for t2 to complete

        // Print the final counter value
        // Expected output: 2000 (1000 increments from each thread)
        System.out.println("Final Counter Value: " + vc.getCounter());
    }
}
