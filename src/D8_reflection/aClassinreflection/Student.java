package D8_reflection.aClassinreflection;

/*
 * This class is used only to understand Reflection.
 */
public class Student {
    // Instance variables
    int id = 101;
    String name = "Mohith";
    /*
     * Static block
     *
     * Executes ONLY ONCE when the class is initialized by JVM.
     *
     * We added this block so that we can observe
     * exactly when the Student class gets initialized.
     */
    static {
        System.out.println("Student class is initialized (Static Block Executed)");
    }
    // Constructor
    public Student() {
        System.out.println("Student Constructor Executed");
    }
    // Normal Method
    public void display() {
        System.out.println(id + " " + name);
    }
}