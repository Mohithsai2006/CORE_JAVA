package D4_this_keyword;

/*
===========================================================
DEMO 1
Understanding "this" Keyword

Topics Covered
--------------
1. Variable Shadowing
2. Current Object Reference
3. Stack Memory
4. Heap Memory
5. Multiple Objects
6. Why this keyword exists

JVM Memory

Method Area
------------------
Student.class metadata

Heap
------------------
Student Object A
id = 101
name = Rahul

Student Object B
id = 102
name = Sai

Stack

main()
---------
s1 -----> Object A
s2 -----> Object B

Constructor Frame
-----------------
this -----> Object A
id(parameter)=101
name(parameter)=Rahul

===========================================================
*/

class Student {

    // Instance variables
    // Stored INSIDE every object in Heap.

    int id;
    String name;

    Student(int id, String name) {

        /*
        Parameter names and instance variable names
        are SAME.

        id -> parameter
        this.id -> object's variable

        Without "this"

        id = id;

        Parameter would assign to itself.

        Object variable remains default value.

        */

        this.id = id;
        this.name = name;

        /*
        JVM Internals

        Stack

        Constructor Frame

        this ----> 0x100

        id(parameter)=101
        name(parameter)=Rahul

        Heap

        Object @0x100

        id = 101
        name = Rahul
        */
    }

    void display() {

        /*
        display() is called using

        s1.display();

        JVM automatically passes

        this = s1

        */

        System.out.println("Current Object = " + this);
        System.out.println("Id   = " + this.id);
        System.out.println("Name = " + this.name);
    }
}

public class Demo1 {

    public static void main(String[] args) {

        /*
        Stack

        main()

        s1
        s2

        */

        Student s1 = new Student(101, "Rahul");

        Student s2 = new Student(102, "Sai");

        /*
        s1 ----> Heap Object A

        s2 ----> Heap Object B

        */

        s1.display();

        System.out.println();

        s2.display();

        /*
        Output

        Current Object = Student@xxxx
        Id =101

        Current Object = Student@yyyy
        Id =102

        Observe

        SAME display() method

        But

        "this"

        changes depending on caller.
        */
    }
}