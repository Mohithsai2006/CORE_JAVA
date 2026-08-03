package  D5_inheritance;
/*
 * ============================================================
 * Demo 2 : Multilevel Inheritance
 *
 * Concepts Covered
 * ----------------
 * 1. Multilevel Inheritance
 * 2. Constructor Chaining
 * 3. super()
 * 4. Method Overriding
 * 5. Runtime Polymorphism
 * 6. Upcasting
 * ============================================================
 */

class Animal {

    Animal() {
        System.out.println("Animal Constructor");
    }

    void sound() {
        System.out.println("Animal makes sound");
    }
}

class Dog extends Animal {

    Dog() {

        // Calls Animal constructor
        super();

        System.out.println("Dog Constructor");
    }

    @Override
    void sound() {
        System.out.println("Dog Barks");
    }
}

class Puppy extends Dog {

    Puppy() {

        // Calls Dog constructor
        super();

        System.out.println("Puppy Constructor");
    }

    @Override
    void sound() {
        System.out.println("Puppy makes cute bark");
    }

    void play() {
        System.out.println("Puppy is playing...");
    }
}

public class Demo2 {

    public static void main(String[] args) {

        System.out.println("===== Constructor Chaining =====");

        Puppy puppy = new Puppy();

        System.out.println();

        System.out.println("===== Runtime Polymorphism =====");

        // Upcasting
        Animal animal = new Puppy();

        // JVM checks actual object (Puppy)
        animal.sound();

        System.out.println();

        System.out.println("===== Normal Object =====");

        puppy.play();

        puppy.sound();
    }
}