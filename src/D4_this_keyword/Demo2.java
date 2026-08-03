//package D4_this_keyword;
//
//
///*
//===================================================
//DEMO 2
//
//Topics Covered
//
//✔ Constructor Chaining
//✔ this()
//✔ Passing this as argument
//✔ Constructor Rules
//✔ Memory Internals
//
//===================================================
//*/
//
//class Printer {
//
//    void print(Student student) {
//
//        /*
//        student reference
//
//        Stack
//
//        student -----> Heap Student Object
//
//        Same object received.
//
//        Object is NOT copied.
//        */
//
//        System.out.println("Printer received object");
//        student.display();
//    }
//}
//
//class Student {
//
//    int id;
//    String name;
//
//    Student() {
//
//        /*
//        Default Constructor
//
//        Heap Object already created.
//
//        "this"
//
//        points to it.
//        */
//
//        this.id = 0;
//        this.name = "Unknown";
//
//        System.out.println("Default Constructor");
//    }
//
//    Student(int id, String name) {
//
//        /*
//        MUST be first statement.
//
//        Calls default constructor.
//
//        Same object.
//
//        No new object created.
//        */
//
//        this();
//
//        this.id = id;
//        this.name = name;
//
//        System.out.println("Parameterized Constructor");
//    }
//
//    void sendToPrinter(Printer printer) {
//
//        /*
//        Passing current object.
//
//        printer.print(this);
//
//        Stack
//
//        this -----> Heap Student
//
//        print(student)
//
//        student -----> SAME Heap Student
//
//        */
//
//        printer.print(this);
//    }
//
//    void display() {
//
//        System.out.println(id + " " + name);
//    }
//}
//
//public class Demo2 {
//
//    public static void main(String[] args) {
//
//        Student student =
//                new Student(101, "Rahul");
//
//        Printer printer = new Printer();
//
//        student.sendToPrinter(printer);
//
//        /*
//        Output
//
//        Default Constructor
//        Parameterized Constructor
//        Printer received object
//        101 Rahul
//
//        Observe
//
//        this()
//
//        constructor chaining
//
//        AND
//
//        this passed as method argument.
//        */
//    }
//}