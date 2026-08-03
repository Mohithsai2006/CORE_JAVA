package D5_final_keyword;
//Demo 2 – Final Methods and Overriding
//Topics Covered
//✔ final method
//✔ Method overriding prevention
//✔ Inheritance
//✔ Dynamic Method Dispatch
//✔ Compile-time Error
class Animal {
    final void eat() {
        System.out.println("Animal is eating");
    }
    void sound() {
        System.out.println("Animal makes sound");
    }
}
class Dog extends Animal {
    // Cannot override final method
    /*
    void eat() {
        System.out.println("Dog eats");
    }
    */
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}
public class Demo2 {
    public static void main(String[] args) {
        Animal obj = new Dog();
        obj.eat();      // Parent final method
        obj.sound();    // Runtime Polymorphism
    }
}