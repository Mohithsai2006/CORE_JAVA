package D7_methodreferences.instancemethodref;
interface Greeting {
    void greet();
}
class Student {
    // Instance method
    void welcome() {
        System.out.println("Welcome Mohith!");
    }
}
public class Demo {
    public static void main(String[] args) {
        //lambda implementation

        Student s1=new Student();
        Greeting g1=()->{
            s1.welcome();
        };
        g1.greet();

        // Particular object
        Student student = new Student();
        // Reference to instance method of THIS object
        Greeting g = student::welcome;
        // Calls student.welcome()
        g.greet();
    }
}
