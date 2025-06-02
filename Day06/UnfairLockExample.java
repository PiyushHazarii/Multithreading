import java.util.concurrent.locks.ReentrantLock;

public class UnfairLockExample {

    // By default, ReentrantLock is unfair (i.e., new threads can barge in)
    private final ReentrantLock lock = new ReentrantLock(); // or new ReentrantLock(true) for fairness 
    // agar ye daal denge true then wo fair lock ban jayega
    // which means threads will acquire the lock in the order they requested it
    // but by default it is unfair

    public void accessResource() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " acquired the lock.");
            try {
                Thread.sleep(1000); // Simulate work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            System.out.println(Thread.currentThread().getName() + " released the lock.");
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        UnfairLockExample example = new UnfairLockExample();

        Runnable task = new Runnable() {
            @Override
            public void run() {
                example.accessResource();
            }
        };

        Thread thread1 = new Thread(task, "Thread 1");
        Thread thread2 = new Thread(task, "Thread 2");
        Thread thread3 = new Thread(task, "Thread 3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

