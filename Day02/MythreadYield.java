public class MythreadYield extends Thread {
    @Override
    public void run() {
        for(int i=0; i<100; i++){
            System.out.println(Thread.currentThread().getName()+" is running");
            Thread.yield(); // means ye kya karega pata hai har baar naya thread ko run karega means ek baar 
            // thread 1 run karega aur dusri baar thread 2 run karega aise kr kr ke ek ke baad ek ko run karega.
            // ye dusra ko chance dega run hone ke baad turant means 1 ke baad ho ya 2 3 ke baad
            // ho lekin chance to dega hi dega. turant 
        }
    }
    public static void main(String[] args) throws InterruptedException {
        MythreadYield t1 = new MythreadYield();
        MythreadYield t2 = new MythreadYield();
        t1.start();
        t2.start(); 
    }
    
}
