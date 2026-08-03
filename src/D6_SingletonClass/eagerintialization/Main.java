package D6_SingletonClass.eagerintialization;

class Singleton {

    // Object created immediately when the class is loaded.
    private static final Singleton obj = new Singleton();

    // Prevent object creation outside the class.
    private Singleton() {
        System.out.println("Singleton Created");
    }

    // Returns the already-created object.
    public static Singleton getInstance() {
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
