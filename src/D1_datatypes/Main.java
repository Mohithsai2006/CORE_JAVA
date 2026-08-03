package D1_datatypes;


public class Main {

    // ============================================================
    // Static Variables
    // Stored in Method Area (Metaspace)
    // Created when DataTypesDemo class is loaded.
    // Destroyed when JVM terminates (or class is unloaded).
    // ============================================================

    static int staticCounter = 100;

    public static void main(String[] args) {

        // ============================================================
        // PRIMITIVE DATA TYPES
        // ============================================================

        // All primitive variables below are LOCAL VARIABLES.
        // They are stored inside the main() stack frame.
        // Stack Memory -> Thread Stack.
        // Created when main() begins execution.
        // Destroyed automatically when main() returns.

        byte byteValue = 100;

        short shortValue = 25000;

        int intValue = 100000;

        long longValue = 9876543210L;

        float floatValue = 98.75f;

        double doubleValue = 12345.6789;

        char character = 'A';

        boolean isJavaFun = true;

        System.out.println("Primitive Data Types");
        System.out.println(byteValue);
        System.out.println(shortValue);
        System.out.println(intValue);
        System.out.println(longValue);
        System.out.println(floatValue);
        System.out.println(doubleValue);
        System.out.println(character);
        System.out.println(isJavaFun);

        // ============================================================
        // NON-PRIMITIVE DATA TYPES
        // ============================================================

        // -----------------------------
        // String
        // -----------------------------

        // studentName is a LOCAL REFERENCE VARIABLE.
        // The reference itself is stored in Stack Memory.
        // The String literal "Rahul" is stored in the String Pool
        // (which is inside Heap Memory).
        // String Pool object usually lives until JVM exits.
        // The local reference is destroyed when main() ends.

        String studentName = "Rahul";

        // -----------------------------
        // String created using new
        // -----------------------------

        // studentCity is a LOCAL REFERENCE VARIABLE in Stack.
        // The actual String object is created in Heap Memory.
        // It is NOT placed in String Pool.
        // Object is eligible for Garbage Collection when unreachable.

        String studentCity = new String("Hyderabad");

        // -----------------------------
        // Array
        // -----------------------------

        // marks is a LOCAL REFERENCE VARIABLE stored in Stack.
        // Actual array object is stored in Heap Memory.
        // Array remains alive until unreachable.

        int[] marks = {90, 85, 95, 80};

        // -----------------------------
        // Custom Object
        // -----------------------------

        // student is a LOCAL REFERENCE VARIABLE stored in Stack.
        // Student object is stored in Heap Memory.
        // Instance variables exist inside the Heap object.
        // Object is destroyed only by Garbage Collector.

        Student student = new Student();

        student.id = 101;
        student.name = "Rahul";

        // ============================================================
        // WRAPPER CLASSES
        // ============================================================

        // Wrapper reference variables are stored in Stack.
        // Actual Wrapper objects are stored in Heap Memory.
        // Wrapper objects are immutable.

        Byte wrapperByte = Byte.valueOf((byte)10);

        Short wrapperShort = Short.valueOf((short)20);

        Integer wrapperInteger = Integer.valueOf(100);

        Long wrapperLong = Long.valueOf(5000L);

        Float wrapperFloat = Float.valueOf(55.6f);

        Double wrapperDouble = Double.valueOf(789.45);

        Character wrapperCharacter = Character.valueOf('J');

        Boolean wrapperBoolean = Boolean.TRUE;

        System.out.println("\nWrapper Objects");
        System.out.println(wrapperInteger);
        System.out.println(wrapperDouble);

        // ============================================================
        // AUTO-BOXING
        // ============================================================

        // Primitive variable stored in Stack.

        int salary = 50000;

        // Auto-boxing
        // Compiler converts:
        // Integer boxedSalary = Integer.valueOf(salary);
        //
        // boxedSalary reference -> Stack
        // Integer object -> Heap

        Integer boxedSalary = salary;

        System.out.println("\nAuto Boxing");
        System.out.println(boxedSalary);

        // Auto-boxing for double

        double pi = 3.14159;

        Double boxedPi = pi;

        System.out.println(boxedPi);

        // ============================================================
        // UNBOXING
        // ============================================================

        // Integer object already exists in Heap.

        Integer ageWrapper = Integer.valueOf(25);

        // Compiler converts:
        // int age = ageWrapper.intValue();

        // age is a primitive local variable.
        // Stored in Stack Memory.

        int age = ageWrapper;

        System.out.println("\nUnboxing");
        System.out.println(age);

        // Unboxing Double

        Double temperatureWrapper = Double.valueOf(36.8);

        double temperature = temperatureWrapper;

        System.out.println(temperature);

        // ============================================================
        // DIFFERENCE BETWEEN PRIMITIVE AND WRAPPER
        // ============================================================

        // Primitive variable
        // Value directly stored in Stack.

        int x = 10;

        // Wrapper reference in Stack.
        // Integer object in Heap.

        Integer y = Integer.valueOf(10);

        System.out.println("\nPrimitive vs Wrapper");
        System.out.println(x);
        System.out.println(y);

        // ============================================================
        // NULL REFERENCES
        // ============================================================

        // Only reference variables can become null.

        Student anotherStudent = new Student();

        anotherStudent.id = 200;

        // anotherStudent reference still exists in Stack.
        // Heap object becomes eligible for Garbage Collection
        // if no other references point to it.

        anotherStudent = null;

        // Wrapper object

        Integer number = Integer.valueOf(100);

        number = null;

        // String created using new

        String message = new String("Hello");

        message = null;

        // Array

        int[] numbers = new int[5];

        numbers = null;

        // ============================================================
        // METHOD CALL
        // ============================================================

        displayData(student);

        // ============================================================
        // End of main()
        //
        // Entire main() stack frame is destroyed.
        //
        // All local primitive variables disappear.
        //
        // All local reference variables disappear.
        //
        // Heap objects become eligible for Garbage Collection
        // if no live references remain.
        // ============================================================
    }

    static void displayData(Student student) {

        // student is a LOCAL REFERENCE VARIABLE.
        // Stored in this method's Stack Frame.
        // It points to an existing Heap object.
        // Destroyed when displayData() returns.

        int localVariable = 500;

        // localVariable is stored in Stack.
        // Destroyed when this method finishes.

        System.out.println("\nInside displayData()");
        System.out.println(student.id);
        System.out.println(student.name);
        System.out.println(localVariable);
    }
}

class Student {

    // Instance variables.
    // Stored inside each Student object in Heap Memory.
    // Created when new Student() executes.
    // Destroyed when object is Garbage Collected.

    int id;

    String name;
}

