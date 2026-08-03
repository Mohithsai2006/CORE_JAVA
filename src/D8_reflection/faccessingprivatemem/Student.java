package D8_reflection.faccessingprivatemem;

public class Student {

    // Private Field
    private int id = 101;

    // Private Field
    private String name = "Mohith";

    // Public Constructor
    public Student() {
        System.out.println("Public Constructor Executed");
    }

    // Private Constructor
    private Student(int id, String name) {

        this.id = id;
        this.name = name;

        System.out.println("Private Constructor Executed");
    }

    // Public Method
    public void display() {

        System.out.println(id + " " + name);

    }

    // Private Method
    private void show() {

        System.out.println("Private Method Executed");

    }

}
