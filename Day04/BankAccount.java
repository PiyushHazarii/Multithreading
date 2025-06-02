public class BankAccount {
    private int balance = 100;

    // yaha pr hum auto-synchronization ka use kar rahe hain
    // jo ki synchronized keyword ke through hota hai
    // isse kya hota hai ki agar ek thread withdraw kar raha hai to dusra 
    // thread wait karega jab tak pehla thread withdraw complete nhi kar leta
    public synchronized void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " attempting to withdraw " + amount);

        if (balance >= amount) {
            System.out.println(Thread.currentThread().getName() + " proceeding with withdrawal");
            try {
                Thread.sleep(3000); // simulate delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " completed withdrawal. Remaining balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " insufficient balance");
        }
    }
}
