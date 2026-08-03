package D6_SingletonClass.enumsingleton;

// Enum Singleton
enum Singleton {

    // JVM automatically creates this single object
    INSTANCE;

    // Enum constructor
    // It is implicitly private.
    Singleton() {
        System.out.println("Singleton Object Created");
    }

    // Business method
    public void display() {
        System.out.println("Welcome to Singleton");
    }
}

public class Main {

    public static void main(String[] args) {

        // Access the only Singleton object
        Singleton s1 = Singleton.INSTANCE;
        Singleton s2 = Singleton.INSTANCE;

        System.out.println(s1);
        System.out.println(s2);

        s1.display();
    }
}
