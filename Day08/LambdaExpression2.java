public class LambdaExpression2 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Hello world");
            }
        });

        int a = 1;

        Runnable task = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Hello world");
            }
        };

        t1.start();
    }
}

