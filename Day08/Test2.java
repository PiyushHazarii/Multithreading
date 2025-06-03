import java.lang.*;
public class Test2 {
    public static void main(String[] args) {
        // // Anonymous inner class implementation of Student
        // Student engineeringStudent = new Student() {
        //     @Override
        //     public String getName(String name) {
        //         return name + " is Engineering student";
        //     }
        // };

        // Call the overridden method
        // String bio = engineeringStudent.getName("Ram");
        // System.out.println(bio);


        // this is the lamda expression.
        // agar multiple input argument hai to bracket use karna padega
        // agar single input argument hai to bracket use karna optional hai 
        // agar return type hai to return keyword use karna padega
        Student lamdaStudent =(name)->{
            return name+" is lamda student";
        };
        System.out.println(lamdaStudent.getName("Ram"));
    }
}
