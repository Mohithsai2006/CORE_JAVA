//Demo 2 – super() Constructor Chaining
//Topics Covered
//✔ Constructor Chaining
//✔ Default Constructor
//✔ Parameterized Constructor
//✔ Automatic super()
//✔ Explicit super()

package D5_super_keyword;
class Person {

    Person() {
        System.out.println("Person Default Constructor");
    }

    Person(String name) {
        System.out.println("Person Name : " + name);
    }
}

class Student extends Person {

    Student() {

        // Compiler inserts super()

        System.out.println("Student Default Constructor");
    }

    Student(int id) {

        super("Rahul"); // Calls parameterized constructor

        System.out.println("Student ID : " + id);
    }
}

public class Demo2 {

    public static void main(String[] args) {

        System.out.println("Object 1");
        new Student();

        System.out.println();

        System.out.println("Object 2");
        new Student(101);
    }
}
