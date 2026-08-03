package D6_serialization.transientmodifier;
import java.io.*;
public class Demo {
    public static void main(String[] args) {

        Employee emp = new Employee(1, "Mohith", "Java@123");
        try {
            // Serialize
            ObjectOutputStream oos =
                    new ObjectOutputStream(new FileOutputStream("employee.dat"));
            oos.writeObject(emp);
            oos.close();
            // Change static variable after serialization
            Employee.company = "Google";
            // Deserialize
            ObjectInputStream ois =
                    new ObjectInputStream(new FileInputStream("employee.dat"));

            Employee e = (Employee) ois.readObject();
            ois.close();
            System.out.println("ID       : " + e.id);
            System.out.println("Name     : " + e.name);
            System.out.println("Password : " + e.password);
            System.out.println("Company  : " + Employee.company);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}