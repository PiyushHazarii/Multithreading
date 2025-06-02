import java.util.concurrent.locks.ReentrantLock;

public class ReentrantExample {
    private final ReentrantLock lock = new ReentrantLock();

    public void outerMethod() {
        lock.lock();
        try {
            System.out.println("Outer method");
            innerMethod(); // Call inner method while holding the lock
        } finally {
            lock.unlock();
        }
    }

    public void innerMethod() {
        // yaha to pehele se hi lock kiya hua hai then ye phir se lock karne ki koshish karega
        // since ReentrantLock allows the same thread to acquire the lock multiple times so error nahi aayega
        lock.lock();
        try {
            System.out.println("Inner method");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantExample example = new ReentrantExample();

        Thread t1 = new Thread(example::outerMethod, "Thread-1");
        t1.start();
    }
}
  