package D6_SingletonClass.Doublecheckedlocking;

class Singleton {

    // Volatile prevents instruction reordering
    // and ensures visibility across threads.
    private static volatile Singleton obj;

    // Prevent external object creation.
    private Singleton() {
        System.out.println("Singleton Created");
    }

    public static Singleton getInstance() {

        // First check avoids locking once object exists.
        if (obj == null) {

            // Lock on the Class object.
            synchronized (Singleton.class) {

                // Second check ensures only one object
                // is created if multiple threads entered together.
                if (obj == null) {
                    obj = new Singleton();
                }
            }
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