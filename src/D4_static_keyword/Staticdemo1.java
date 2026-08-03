package D4_static_keyword;
class Student {
    // Instance variables (each object gets its own copy)
    int id;
    String name;
    // Static variable (shared by all objects)
    static String college = "ABC Engineering College";
    // Static method
    static void collegeInfo() {
        System.out.println("College : " + college);
        // Static method cannot access instance variables directly
        // System.out.println(id); // Compile-time Error
        // Access instance variable using an object
        Student s = new Student();
        s.id = 999;
        System.out.println("Accessing instance using object : " + s.id);
    }
    // Instance method
    void display() {
        // Can access instance variables
        System.out.println("ID : " + id);
        System.out.println("Name : " + name);
        // Can also access static variables
        System.out.println("College : " + college);
        // Calling static method
        collegeInfo();
    }
}
public class Staticdemo1 {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.id = 101;
        s1.name = "Rahul";
        Student s2 = new Student();
        s2.id = 102;
        s2.name = "Priya";
        // Shared static variable
        Student.college = "XYZ University";
        s1.display();
        System.out.println();
        s2.display();
        System.out.println();
        Student.collegeInfo();
    }
}


//Concepts covered
//
//Static variable
//Instance variable
//Static method
//Instance method
//Static accessing static
//Instance accessing static
//Static accessing instance (using object)