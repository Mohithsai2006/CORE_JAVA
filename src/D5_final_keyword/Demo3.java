package D5_final_keyword;
//Demo 3 – Final Class, Final Object, Final Array, Interface Constants
//Topics Covered
//✔ final class
//✔ final object reference
//✔ final array
//✔ Interface variables are public static final
//✔ Reference vs Object
// Final class
final class Employee {
    String name = "Rahul";
}
interface College {
    int CODE = 1001; // public static final
}
public class Demo3 {
    public static void main(String[] args) {
        // Final object reference
        final Employee emp = new Employee();
        emp.name = "Mohith";   // Allowed
        // emp = new Employee(); // Compile-time Error
        System.out.println(emp.name);
        // Final array reference
        final int arr[] = {10,20,30};
        arr[0] = 100;      // Allowed
        // arr = new int[5]; // Compile-time Error
        System.out.println(arr[0]);
        System.out.println(College.CODE);
        // College.CODE = 500; // Compile-time Error
    }
}