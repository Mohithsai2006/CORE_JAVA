package D6_SingletonClass.synchronizedmethod;

class Singleton {

    private static Singleton obj;

    private Singleton() {
        System.out.println("Singleton Created");
    }

    // Only one thread can execute this method at a time.
    public static synchronized Singleton getInstance() {
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
