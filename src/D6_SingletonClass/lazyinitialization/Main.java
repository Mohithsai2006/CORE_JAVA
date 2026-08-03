package D6_SingletonClass.lazyinitialization;
class Singleton {

    // Static because only one copy should exist for the entire class.
    // Initially null because object is created only when needed.
    private static Singleton obj = null;

    // Private constructor prevents other classes from creating objects
    // using the new keyword.
    private Singleton() {
        System.out.println("Singleton Object Created");
    }

    // Static method because we need to call it without creating an object.
    public static Singleton getInstance() {

        // Create object only if it doesn't already exist.
        if (obj == null) {
            obj = new Singleton();
        }

        return obj;
    }
}

public class Main {

    public static void main(String[] args) {

        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        System.out.println(s1);
        System.out.println(s2);
    }
}