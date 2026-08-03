package D4_static_keyword;
class Car {
    int speed = 120;          // Instance variable
    static int wheels = 4;    // Static variable
    static void staticMethod() {
        System.out.println("Static Method");
        // Static can access static
        System.out.println("Wheels : " + wheels);
        // Cannot access instance directly
        // System.out.println(speed); // Error
        // 'this' is not allowed
        // System.out.println(this.speed); // Error
        // Access instance using object
        Car c = new Car();
        System.out.println("Speed : " + c.speed);
    }
    void instanceMethod() {
        System.out.println("Instance Method");
        // Instance can access instance
        System.out.println(speed);
        // Instance can access static
        System.out.println(wheels);
        // Calling static method
        staticMethod();
    }
}
public class StaticDemo3 {
    public static void main(String[] args) {
        // Local variables cannot be static
        // static int x = 10; // Compile-time Error
        Car.staticMethod();
        System.out.println();
        Car c = new Car();
        c.instanceMethod();
    }
}