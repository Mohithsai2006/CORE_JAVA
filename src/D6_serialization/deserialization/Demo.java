package D6_serialization.deserialization;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import D6_serialization.serialization.Student;
public class Demo {

    public static void main(String[] args) {

        try {

            FileInputStream fis = new FileInputStream("student.dat");

            ObjectInputStream ois = new ObjectInputStream(fis);

            // Reading object from file
            Student student = (Student) ois.readObject();

            System.out.println("Object Deserialized Successfully");

            System.out.println(student.id);
            System.out.println(student.name);
            System.out.println(student.marks);

            ois.close();
            fis.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}