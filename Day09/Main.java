public class Main {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        // here we are creating 9 threads to calculate factorial of numbers from 1 to 9
        // and printing the result
        Thread[] threads = new Thread[9];

        for (int i = 1; i < 10; i++) {
            int finalI = i;
            // yaha pr thread ka concept use kr raha hai taaki har 
            // thread ek alag number ka factorial calculate kare aur jaldi se jaldi result de.
            threads[i - 1] = new Thread(() -> {
                long result = factorial(finalI);
                System.out.println(result);
            });
            threads[i - 1].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("Total time: " + (System.currentTimeMillis() - startTime));
    }

    private static long factorial(int n) {
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }
}
