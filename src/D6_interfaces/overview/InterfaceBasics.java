package D6_interfaces.overview;
//------------------------------------------------------------
// Program: Interface Basics
// Demonstrates:
// 1. Creating an interface
// 2. Implementing an interface
// 3. Interface reference
// 4. Runtime polymorphism
//------------------------------------------------------------

// Interface defines a contract.
// Every implementing class must provide implementation.
interface Animal {

    // By default: public abstract
    void sound();
}

// Dog implements Animal interface.
class Dog implements Animal {
    // Must be public because interface methods are public.
    @Override
    public void sound() {
        System.out.println("Dog Barks");
    }
}
// Cat also implements Animal interface.
class Cat implements Animal {
    @Override
    public void sound() {
        System.out.println("Cat Meows");
    }
}
public class InterfaceBasics {
    public static void main(String[] args) {
        // Interface reference referring to Dog object.
        Animal a1 = new Dog();
        // Calls Dog's implementation.
        a1.sound();
        // Interface reference referring to Cat object.
        Animal a2 = new Cat();
        // Calls Cat's implementation.
        a2.sound();
        // Not Allowed
        // Animal a = new Animal();
        // Interfaces cannot be instantiated.
    }
}
/*
----------------------------
Topics Covered
----------------------------
✔ Interface creation
✔ implements keyword
✔ Method overriding
✔ Interface reference
✔ Runtime polymorphism
✔ Cannot create interface object
*/