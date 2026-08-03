package D6_serialization.serialization;

import java.io.Serial;
import java.io.Serializable;

// Serializable is a Marker Interface.
// It tells JVM that objects of this class can be serialized.
public class Student implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    public int id;
    public String name;
    public double marks;

    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;

        System.out.println("Student Constructor Executed");
    }
}