public class Thread3 extends Thread{

        @Override
        public void run() {
        try{
            Thread.sleep(10000); // this will make the thread sleep for 1 second
            System.out.println("Thread is sleeping for 1 second");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
       
    public static void main(String[] args) {
        Thread3 thread3 = new Thread3();
        thread3.start(); // this will call the run method of the Thread3 class
        thread3.interrupt(); // this will interrupt the thread and stop it from sleeping
    }
}
