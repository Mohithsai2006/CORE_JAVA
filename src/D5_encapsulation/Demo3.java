package D5_encapsulation;
class Employee {
    // Different access modifiers
    private int id = 101;
    int age = 25;                  // default
    protected String department = "IT";
    public String company = "OpenAI";
    // Public method to access private variable
    public int getId() {
        return id;
    }
    // Public method to modify private variable
    public void setId(int id) {
        this.id = id;
    }
    void display() {
        // All members accessible inside same class
        System.out.println("Private   : " + id);
        System.out.println("Default   : " + age);
        System.out.println("Protected : " + department);
        System.out.println("Public    : " + company);
    }
}
public class Demo3 {
    public static void main(String[] args) {
        Employee emp = new Employee();
        // Access through methods (Encapsulation)
        emp.setId(500);
        System.out.println("Employee ID : " + emp.getId());
        // Accessible
        System.out.println("Age : " + emp.age);
        // Accessible
        System.out.println("Department : " + emp.department);
        // Accessible
        System.out.println("Company : " + emp.company);
        emp.display();
        // emp.id = 100;  // Compile-time Error (private)
    }
}
//Topics Covered
//✔ private
//✔ default (package-private)
// ✔ protected
//✔ public
//✔ Encapsulation
//✔ Why private is preferred
//✔ Access through public methods
//✔ Same-class access