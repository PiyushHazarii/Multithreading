class SharedObj {
    // agar hum volatile nahi lagate hai to reader thread ko kabhi bhi flag ki value true nahi milegi
    // kyuki thread ka cache mein flag ka value false hi rahega wo update nhi ho raha hai 
    // har thread ke pass ek local copy hoti hai variable ki aur wo tabhi tak update nahi hota 
    // jab tak hum volatile nahi lagate hai
    private volatile boolean flag = false;

    public void setFlagTrue() {
        System.out.println("Flag set to true by writer");
        this.flag = true;
    }

    public void printIfFlagTrue() {
        while (!flag) {
            // Busy-wait loop until flag becomes true
        }
        System.out.println("Flag is true - read by reader");
    }
}

public class VolatileExample {
    public static void main(String[] args) {
        SharedObj sharedObj = new SharedObj();

        // Writer thread sets the flag to true after 1 second
        Thread writerThread = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            sharedObj.setFlagTrue();
        });

        // Reader thread continuously checks the flag and prints when it's true
        Thread readerThread = new Thread(() -> sharedObj.printIfFlagTrue());

        writerThread.start();
        readerThread.start();
    }
}

