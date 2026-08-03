package D1_javamemory_basics.jvm;
/*
======================================================
JVM EXECUTION ORDER

1. Class Loading
2. Static Variable
3. Static Block
4. main()
5. Heap Allocation
6. Default Values
7. Instance Variables
8. Instance Block
9. Constructor
10. Normal Method
11. Garbage Collection
======================================================
*/

public class JvmExecutionDemo {

    //----------------------------------------------------
    // STATIC VARIABLE
    // Stored in Metaspace
    //----------------------------------------------------

    static String company = initializeCompany();

    static String initializeCompany() {

        System.out.println("1. Static Variable Initialized");

        return "OpenAI";

    }

    //----------------------------------------------------
    // STATIC BLOCK
    //----------------------------------------------------

    static {

        System.out.println("2. Static Block Executed");

    }

    //----------------------------------------------------
    // INSTANCE VARIABLES
    // Stored inside Heap Object
    //----------------------------------------------------

    int id = initializeId();

    String name = initializeName();

    int initializeId() {

        System.out.println("5. Instance Variable id Initialized");

        return 101;

    }

    String initializeName() {

        System.out.println("6. Instance Variable name Initialized");

        return "Mohith";

    }

    //----------------------------------------------------
    // INSTANCE BLOCK
    //----------------------------------------------------

    {

        System.out.println("7. Instance Block Executed");

    }

    //----------------------------------------------------
    // CONSTRUCTOR
    //----------------------------------------------------

    JvmExecutionDemo() {

        System.out.println("8. Constructor Executed");

    }

    //----------------------------------------------------
    // NORMAL METHOD
    //----------------------------------------------------

    void display() {

        int marks = 95; // Stored in Stack

        System.out.println();

        System.out.println("9. Display Method");

        System.out.println("ID      : " + id);

        System.out.println("Name    : " + name);

        System.out.println("Marks   : " + marks);

        System.out.println("Company : " + company);

    }

    //----------------------------------------------------
    // MAIN METHOD
    //----------------------------------------------------

    public static void main(String[] args) {

        System.out.println("3. Main Method Started");

        System.out.println();

        System.out.println("4. Creating Object");

        JvmExecutionDemo obj = new JvmExecutionDemo();

        System.out.println();

        obj.display();

        //------------------------------------------------
        // Object Eligible for Garbage Collection
        //------------------------------------------------

        obj = null;

        System.out.println();

        System.out.println("10. Object Eligible for Garbage Collection");

        System.gc();

        System.out.println();

        System.out.println("11. Program Completed");

    }
}
