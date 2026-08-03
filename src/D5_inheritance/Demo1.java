package D5_inheritance;
/*
 * ============================================================
 * Demo 1 : Basic Inheritance
 *
 * Concepts Covered
 * ----------------
 * 1. extends keyword
 * 2. Parent Class
 * 3. Child Class
 * 4. Inherited variables
 * 5. Inherited methods
 * 6. Child's own methods
 * ============================================================
 */

class Animal {

    // Parent variables
    String name = "Tom";

    int age = 5;

    // Parent method
    void eat() {
        System.out.println("Animal is eating...");
    }

    // Parent method
    void sleep() {
        System.out.println("Animal is sleeping...");
    }
}

// Dog inherits everything from Animal
class Dog extends Animal {

    // Child's own variable
    String breed = "Golden Retriever";

    // Child's own method
    void bark() {
        System.out.println("Dog is barking...");
    }
}

public class Demo1 {

    public static void main(String[] args) {

        // Creating Dog object
        Dog dog = new Dog();

        System.out.println("===== Inherited Variables =====");

        // inherited variables
        System.out.println("Name : " + dog.name);

        System.out.println("Age  : " + dog.age);

        System.out.println("Breed: " + dog.breed);

        System.out.println();

        System.out.println("===== Inherited Methods =====");

        // inherited methods
        dog.eat();

        dog.sleep();

        // child method
        dog.bark();
    }
}