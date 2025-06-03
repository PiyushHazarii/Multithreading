public class LambdaExpression {
    public static void main(String[] args) {
        // this is the lamda expression
        Runnable runnable = () -> System.out.println("Hello");

        Thread t1 = new Thread(runnable);
        t1.start();


        // both upperr and lower part are same but upper are lamda expression and 
        // lower part is anonymous class 
        Runnable runnable2 = new Runnable() {
            @Override
            public void run(){
                System.out.println("Hello from Runnable");
            }
        };

        Thread t2 = new Thread(runnable2);
        t2.start();
    }
}
