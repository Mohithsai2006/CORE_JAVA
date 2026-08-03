package D6_serialization.serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Demo {

    public static void main(String[] args) {

        // Creating object in Heap Memory
        Student student = new Student(101, "Mohith", 95.5);

        try {
            // Creates student.dat file
            FileOutputStream fos = new FileOutputStream("student.dat");
            // Converts Object into Byte Stream
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            // Serialize object
            oos.writeObject(student);
            System.out.println("Object Serialized Successfully.");
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
