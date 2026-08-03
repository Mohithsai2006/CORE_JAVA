package D6_interfaces;
// Program: Default, Static and Private Methods
// Demonstrates:
// 1. default method
// 2. static method
// 3. private method (Java 9)
interface Mobile {
    void call();
    // Has implementation.
    default void message() {
        common();
        System.out.println("Sending Message");
    }
    // Called using interface name.
    static void company() {
        System.out.println("Android Mobile");
    }
    // Used only inside this interface.
    private void common() {
        System.out.println("Preparing Message...");
    }
}
class Samsung implements Mobile {
    @Override
    public void call() {
        System.out.println("Calling...");
    }
}
public class DefaultStaticPrivateMethods {
    public static void main(String[] args) {
        Mobile mobile = new Samsung();
        mobile.call();
        mobile.message();
        Mobile.company();
    }
}
/*
----------------------------
Topics Covered
----------------------------
✔ default method
✔ static method
✔ private method
*/