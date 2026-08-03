package D2_casting.Referencecast;

// ==========================================================
// Parent Class
// ==========================================================
class Animal {

    void eat() {
        System.out.println("Animal is eating.");
    }

    void sleep() {
        System.out.println("Animal is sleeping.");
    }

}

// ==========================================================
// Child Class
// ==========================================================
class Dog extends Animal {

    // Method Overriding
    @Override
    void eat() {
        System.out.println("Dog is eating.");
    }

    void bark() {
        System.out.println("Dog is barking.");
    }
}

public class Castingeg {

    public static void main(String[] args) {

  Animal a=new Dog();//upcast
  a.eat();
  Dog d=(Dog)a;//downcast
  d.bark();
  Animal a2=new Animal();
  Dog d1=(Dog)a2;
    }
}