package D6_interfaces;
//------------------------------------------------------------
// Program: Interface Methods
// Demonstrates:
// 1. Abstract methods in interface
// 2. Method overriding
//------------------------------------------------------------
interface Vehicle {
    void start();
    void stop();
}
class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println("Car Started");
    }
    @Override
    public void stop() {
        System.out.println("Car Stopped");
    }
}
public class InterfaceMethods {
    public static void main(String[] args) {
        Vehicle vehicle = new Car();
        vehicle.start();
        vehicle.stop();
    }
}
/*
----------------------------
Output
----------------------------
Car Started
Car Stopped
----------------------------
Topics Covered
----------------------------
✔ Abstract methods
✔ Method overriding
✔ Interface reference
*/