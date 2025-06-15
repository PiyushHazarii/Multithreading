// Scheduled Executor Service Example.


import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        // yaha pr jo schedular hai wo ek thread pool create karega jisme 1 thread hogi
        // aur wo thread ko schedule karega ki wo task ko 5 seconds ke baad execute kare.
        scheduler.schedule(
            () -> System.out.println("Task executed after every 5 seconds !"),
            5,
            TimeUnit.SECONDS
        );

        scheduler.shutdown();
    }
}
