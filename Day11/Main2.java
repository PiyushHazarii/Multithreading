import java.util.concurrent.*;

public class Main2 {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        // Repeated task every 5 seconds with initial delay of 5 seconds
        scheduler.scheduleAtFixedRate(
            () -> System.out.println("Task executed after every 2 seconds !"),
            2, // initial delay of 2 seconds
            5, // repeat every
            TimeUnit.SECONDS
        );
        // agar direct scheduleAtFixedRate use karte hai to wo kuch print hi nhi karega 
        // kyuki wo fixed rate pr chalega to har baar fixed rate pr chalega 
        // wo queue me hi rahega aur kabhi bhi execute nhi hoga direct shutdown ho jayega. 

        // Schedule shutdown after 10 seconds
        scheduler.schedule(() -> {
            System.out.println("Initiating shutdown...");
            scheduler.shutdown();
            }, 
            20, // delay before shutdown matlab 20 seconds ke baad shutdown karega
            TimeUnit.SECONDS
        );
    }
}
