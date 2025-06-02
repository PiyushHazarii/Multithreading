public class Test {
    public static void main(String[] args) {
        System.out.println("Hello World");

        // this will give the name of the current thread that is running
        System.out.println(Thread.currentThread().getName());

        // Jab bhi koi kaam karana hai in a new thread then you have to extends the Thread class
        Test02 t1 = new Test02();
        t1.start(); // this will call the run method of the Test02 class

        for(int i = 0; i < 100000; i++) {
            System.out.println("Hello Sanju");
        }
        
        // yaha pr jo bhi execution hoga wo random order mein hoga koi 
        // thread pehle execute ho jayega aur koi baad mein
        

        // this is test03 class
        Tes03 t2 = new Tes03(); // this is the new state of thread
        Thread t3 = new Thread(t2); // this is the runnable state of thread
        t3.start(); // this will call the run method of the Tes03 class


        MyThread2 t4 = new MyThread2("Piyush");
        t4.start(); // this will call the run method of the MyThread2 class
    }
}
