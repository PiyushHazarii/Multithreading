// agar thread class ko extend nhi krte hai to
// Runnable interface ko implement krna padega
// jisme humko run method ko override karna padega nhi to error aayega
// then humko thread class ka object banana padega
// and then us object ke through hum run method ko call kar sakte hain
public class Tes03 implements Runnable{

  @Override
    public void run() {
        for(int i = 0; i < 100000; i++) {
            System.out.println("Hello Amit");
        }
    }  
    
}
