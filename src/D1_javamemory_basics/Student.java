package D1_javamemory_basics;

class Student {

    static {
        System.out.println("Static Block");
    }

    int id = initializeId();
    String name = initializeName();

    {
        System.out.println("Instance Block");
    }

    Student() {
        System.out.println("Constructor");
    }

    int initializeId() {
        System.out.println("Instance Variable id");
        return 101;
    }

    String initializeName() {
        System.out.println("Instance Variable name");
        return "Mohith";
    }

    void display() {
        System.out.println(id + " " + name);
    }
}