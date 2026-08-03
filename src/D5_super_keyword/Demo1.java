//Demo 1 – super with Variables and Methods
//Topics Covered
//✔ Inheritance
//✔ super variable
//✔ this variable
//✔ Method Overriding
//✔ super.method()
//✔ this.method()
//✔ Current object vs Parent object
package D5_super_keyword;
class Animal {
    String name = "Animal";
    void sound() {
        System.out.println("Animal makes sound");
    }
}
class Dog extends Animal {
    String name = "Dog";
    void sound() {
        System.out.println("Dog barks");
    }
    void display() {
        // Current class variable
        System.out.println("this.name  : " + this.name);
        // Parent class variable
        System.out.println("super.name : " + super.name);
        System.out.println();
        // Current class method
        this.sound();
        // Parent class method
        super.sound();
    }
}
public class Demo1 {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.display();
    }
}
