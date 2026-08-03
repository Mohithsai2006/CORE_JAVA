package D5_abstraction;

abstract class Vehicle {

    // Instance variables
    // Every child object will contain these variables
    String brand;
    int speed;

    // Abstract class constructor
    // Executes when child object is created
    Vehicle(String brand, int speed) {
        this.brand = brand;
        this.speed = speed;

        System.out.println("Vehicle constructor executed");
    }


    // Concrete method
    // Common behavior for all vehicles
    void stop() {
        System.out.println(brand + " stopped");
    }


    // Abstract method
    // Child classes must provide implementation
    abstract void start();


    // Final method
    // Child classes cannot override this
    final void displayInfo() {
        System.out.println("Brand : " + brand);
        System.out.println("Speed : " + speed);
    }


    // Static method
    // Belongs to class, not object
    static void vehicleInfo() {
        System.out.println("All vehicles need engines or power sources");
    }

}



class Car extends Vehicle {

    String model;


    Car(String brand, int speed, String model) {

        // Calling parent abstract class constructor
        super(brand, speed);

        this.model = model;

        System.out.println("Car constructor executed");
    }


    // Implementing abstract method
    @Override
    void start() {
        System.out.println("Car starts using push button");
    }


    void showModel() {
        System.out.println("Model : " + model);
    }

}




class Bike extends Vehicle {


    Bike(String brand, int speed) {

        super(brand, speed);

        System.out.println("Bike constructor executed");
    }


    @Override
    void start() {
        System.out.println("Bike starts using self start");
    }

}




class Truck extends Vehicle {


    Truck(String brand, int speed) {

        super(brand, speed);

        System.out.println("Truck constructor executed");
    }


    @Override
    void start() {
        System.out.println("Truck starts using diesel ignition");
    }

}




public class Demo1 {

    public static void main(String[] args) {


        /*

        Cannot create:

        Vehicle v = new Vehicle();

        Because Vehicle is abstract.

        */


        // Parent reference
        // Child object

        Vehicle v1 = new Car("BMW",220,"X5");

        Vehicle v2 = new Bike("Yamaha",120);

        Vehicle v3 = new Truck("Volvo",90);



        System.out.println("\n--- CAR ---");

        v1.start();
        v1.displayInfo();
        v1.stop();



        System.out.println("\n--- BIKE ---");

        v2.start();
        v2.displayInfo();
        v2.stop();



        System.out.println("\n--- TRUCK ---");

        v3.start();
        v3.displayInfo();
        v3.stop();



        Vehicle.vehicleInfo();

    }

}