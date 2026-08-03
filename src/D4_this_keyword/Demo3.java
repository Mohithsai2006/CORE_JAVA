//package D4_this_keyword;
//
///*
//==================================================
//DEMO 3
//
//Topics Covered
//
//✔ Returning this
//✔ Method Chaining
//✔ this.display()
//✔ Static vs Instance
//✔ Why main() cannot use this
//✔ JVM Explanation
//
//==================================================
//*/
//
//class Student {
//
//    int id;
//    String name;
//
//    Student setId(int id) {
//
//        /*
//        this
//
//        points to current object.
//
//        Returns SAME object.
//
//        */
//
//        this.id = id;
//
//        return this;
//    }
//
//    Student setName(String name) {
//
//        this.name = name;
//
//        return this;
//    }
//
//    Student show() {
//
//        /*
//        Calling another instance method.
//
//        Compiler actually does
//
//        this.display();
//
//        */
//
//        this.display();
//
//        return this;
//    }
//
//    void display() {
//
//        System.out.println(id + " " + name);
//    }
//
//    static void staticMethod() {
//
//        /*
//        ERROR
//
//        this.display();
//
//        Why?
//
//        Static methods belong to CLASS.
//
//        No object exists.
//
//        Therefore
//
//        JVM has NO current object.
//
//        Hence
//
//        no "this"
//
//        */
//    }
//}
//
//public class Demo3 {
//
//    public static void main(String[] args) {
//
//        Student student =
//                new Student();
//
//        /*
//        Method Chaining
//
//        setId()
//
//        returns current object
//
//        ↓
//
//        setName()
//
//        returns current object
//
//        ↓
//
//        show()
//
//        */
//
//        student
//                .setId(101)
//                .setName("Rahul")
//                .show();
//
//        /*
//        Output
//
//        101 Rahul
//
//        JVM
//
//        student.setId()
//
//        returns
//
//        same reference
//
//        therefore
//
//        next method
//
//        executes on SAME object.
//
//        */
//
//        /*
//        Illegal
//
//        this.display();
//
//        Why?
//
//        main()
//
//        is static.
//
//        No current object.
//
//        */
//    }
//}