public class DaemonThread extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("Hello world !");
        }
    }
    

    public static void main(String[] args) {
        DaemonThread myThread = new DaemonThread();
        myThread.setDaemon(true);   // Set the thread as daemon
        myThread.start();           // Start the thread
        System.out.println("Main done");
    }
}
// ye upar wala kuch der chalne ke baad khatam ho jayega kyuki ye daemon thread hai.
// jab tak main thread khatam nahi hota tab tak ye daemon thread bhi chalta rahega.
// jab main thread khatam ho jayega tab ye daemon thread bhi khatam ho jayega.
// daemon thread ka matlab hota hai ki ye thread background me chalta hai aur jab main thread khatam ho jata hai to ye bhi khatam ho jata hai.