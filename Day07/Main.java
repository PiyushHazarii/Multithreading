// THIS IS THREAD COMMUNICATION THREAD EXAMPLE.


class SharedResource {
    private int data;
    private boolean hasData;

    // agar hasdata hai to wait karega wo 
    public synchronized void produce(int value) {
        while (hasData) {
            try {
                wait(); // wait if data is already present
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        data = value; 
        hasData = true; // mark that data is available
        System.out.println("Produced: " + value);
        notify(); // notify the waiting consumer means notify other thread that data is available
    }

    public synchronized int consume() {
        while (!hasData) {
            try {
                wait(); // wait if no data is present
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        hasData = false; // mark that data has been consumed
        System.out.println("Consumed: " + data)  ;
        notify(); // notify the waiting producer
        return data;
    }
}

public class Main {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                resource.produce(i);
                try {
                    Thread.sleep(500); // simulate delay
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                resource.consume();
                try {
                    Thread.sleep(1000); // simulate delay
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        producer.start();
        consumer.start();
    }
}
