package D8_reflection.cworkingwithconstructors;

/*
 * Student class with constructors having
 * different access modifiers.
 */
public class Student {

    private int id;
    private String name;

    // Public no-argument constructor
    public Student() {
        System.out.println("Public No-Arg Constructor");
    }

    // Public parameterized constructor
    public Student(int id) {
        this.id = id;
        System.out.println("Public Constructor(int)");
    }

    // Protected constructor
    protected Student(String name) {
        this.name = name;
        System.out.println("Protected Constructor(String)");
    }

    // Private constructor
    private Student(int id, String name) {
        this.id = id;
        this.name = name;
        System.out.println("Private Constructor(int,String)");
    }
}