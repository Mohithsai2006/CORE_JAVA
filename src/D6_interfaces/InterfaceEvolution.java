package D6_interfaces;
//------------------------------------------------------------
// Program: Interface Evolution
// Demonstrates features added in Java versions.
//------------------------------------------------------------
interface Demo {
    // Java 1.0
    void m1();
    // Java 8
    default void m2() {
        System.out.println("Default Method");
    }
    // Java 8
    static void m3() {
        System.out.println("Static Method");
    }
    // Java 9
    private void helper() {
        System.out.println("Private Helper Method");
    }
    // Java 9
    default void m4() {
        helper();
        System.out.println("Calling Private Method");
    }
}
class Test implements Demo {
    @Override
    public void m1() {
        System.out.println("Abstract Method");
    }
}
public class InterfaceEvolution {
    public static void main(String[] args) {
        Demo demo = new Test();
        demo.m1();
        demo.m2();
        demo.m4();
        Demo.m3();
    }
}
/*
----------------------------
Topics Covered
----------------------------
✔ Abstract method
✔ Default method
✔ Static method
✔ Private method
✔ Java 8 features
✔ Java 9 features
*/