package D5_final_keyword;
//Demo 1 – Final Variables (Local, Instance, Blank Final, Static Final, Parameters)
//Topics Covered
//✔ final local variable
//✔ final instance variable
//✔ blank final variable
//✔ constructor initialization
//✔ static final variable
//✔ final parameter
//✔ final in main()
class Student {
    // Instance final variable
    final String college = "JNTUH";
    // Blank final variable
    final int id;
    // Static final variable
    static final String UNIVERSITY = "Hyderabad";
    // Constructor initializes blank final variable
    Student(int id) {
        this.id = id;
    }
    // Final parameter
    void display(final int marks) {
        // marks = 90; // Compile-time Error
        System.out.println("College    : " + college);
        System.out.println("ID         : " + id);
        System.out.println("University : " + UNIVERSITY);
        System.out.println("Marks      : " + marks);
    }
}
public class Demo1 {
    public static void main(final String[] args) {
        Student s = new Student(101);
        s.display(85);
        // args = null; // Compile-time Error
    }
}