public class Test {
    public static void main(String[] args) {
        Counter counter = new Counter();
        MyThread thread1 = new MyThread(counter);
        MyThread thread2 = new MyThread(counter);
        thread1.start();
        thread2.start();
        try {
            thread1.join(); // Wait for thread1 to finish
            thread2.join(); // Wait for thread2 to finish   
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());
        }
        System.out.println("Final counter value: " + counter.getCount()); // kyu iska answer 2000 nhi aa raha hai
        // kyuki hum ek object ko share kr rahe hain dono threads mein essi liye dono threads ke operations interleave ho rahe hain
        // isliye 2000 nhi aa raha hai 
        // matlab agar 101 instance mein dono thread ka increment operation sath mein chal gaya means
        // wo bhada hi nhi ek sath wo increment opeeration run kr diya to essi liye kam aa raha hai 2000 se 

        // Note isse bachne ke liye hum synchronized keyword ka use karte hain method mein ki wo ek sath na chale 2 thread ke liye 
        // then ab hamesha aayega 2000 hi answer  
    }
}
