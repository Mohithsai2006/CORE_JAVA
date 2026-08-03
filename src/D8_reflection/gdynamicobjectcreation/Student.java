package D8_reflection.gdynamicobjectcreation;


public class Student {

    private int id;
    private String name;

    // Public No-Argument Constructor
    public Student() {

        System.out.println("Student Object Created");

    }

    public void setId(int id) {

        this.id = id;

    }

    public void setName(String name) {

        this.name = name;

    }

    public void display() {

        System.out.println("----------------------");
        System.out.println("Id   : " + id);
        System.out.println("Name : " + name);
        System.out.println("----------------------");

    }
}
