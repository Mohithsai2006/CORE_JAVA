package D5_encapsulation;
class Student {
    // Private data (Hidden)
    private int id;
    private String name;
    // Setter methods
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    // Getter methods
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
}
public class Demo1 {
    public static void main(String[] args) {
        Student s = new Student();
        // Updating private data using setters
        s.setId(101);
        s.setName("Rahul");
        // Reading private data using getters
        System.out.println("ID   : " + s.getId());
        System.out.println("Name : " + s.getName());
    }
}
//Topics Covered
//✔ What is Encapsulation
//✔ private variables
//✔ getter()
//✔ setter()
//✔ this keyword
//✔ Object creation
//✔ Reading and updating private data
//✔ Memory understanding (Stack & Heap)