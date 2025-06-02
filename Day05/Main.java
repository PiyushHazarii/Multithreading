public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                account.withdraw(50); 
            }
        };
        Thread thread1 = new Thread(runnable, "Thread 1");
        Thread thread2 = new Thread(runnable, "Thread 2");
        thread1.start();
        thread2.start();
        try {
            thread1.join(); // Wait for thread1 to finish
            thread2.join(); // Wait for thread2 to finish   
        } catch (InterruptedException e) {
        }
    }
}
