class ThreadStateDemo extends Thread {
    public void run() {
        System.out.println("RUNNING");
        try {
            Thread.sleep(2000); // Thread will sleep for 2 seconds and wo state bhi timed waiting dega
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}


public class  MyThread {
    public static void main(String[] args) throws InterruptedException {
        ThreadStateDemo t1 = new ThreadStateDemo();

        // State before starting the thread
        System.out.println(t1.getState()); // NEW

        t1.start();

        // State just after starting the thread
        System.out.println(t1.getState()); // RUNNABLE

        Thread.sleep(100); // Main thread sleeps for 100 ms

        // State after a brief sleep
        System.out.println(t1.getState()); // TIMED_WAITING (due to sleep in run())

        // jab t1 thread mein ho kaam hai wo kaam finish nhi ho jaye tab tak main thread wait karega
        // Main thread waits for t1 to finish
        t1.join(); // Main thread waits for t1 to finish
        System.out.println(t1.getState()); // TERMINATED
    }
}
