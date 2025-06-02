public class MyThread2 extends Thread {

    public MyThread2(String name) {
        super(name); // Sets the thread name using the parent constructor
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(
                Thread.currentThread().getName() +
                " - Priority: " + Thread.currentThread().getPriority() +
                " - count: " + i
            );
        }
    }
}
