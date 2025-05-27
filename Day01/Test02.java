// Jab bhi koi kaam karana hai in a new thread then you have to extends the Thread class
public class Test02 extends Thread{

    @Override
    public void run() {
        for(int i=0; i<100000; i++){
            System.out.println("Hello Piyush");
        }
    }
}
