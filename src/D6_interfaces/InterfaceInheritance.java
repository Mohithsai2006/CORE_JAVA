package D6_interfaces;
//------------------------------------------------------------
// Program: Interface Inheritance
//------------------------------------------------------------
interface Animal {
    void eat();
}
// Interface extending another interface.
interface Dog extends Animal {
    void bark();
}
class Puppy implements Dog {
    @Override
    public void eat() {
        System.out.println("Puppy is Eating");
    }
    @Override
    public void bark() {
        System.out.println("Puppy is Barking");
    }
}
public class InterfaceInheritance {
    public static void main(String[] args) {
        Puppy puppy = new Puppy();
        puppy.eat();
        puppy.bark();
    }
}
/*
----------------------------
Output
----------------------------
Puppy is Eating
Puppy is Barking
----------------------------
Topics Covered
----------------------------
✔ Interface inheritance
✔ extends keyword
✔ Multiple method implementation
*/