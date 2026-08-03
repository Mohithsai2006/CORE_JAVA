//Demo 4 – super Rules & Restrictions
//Topics Covered
//✔ super not allowed in static method
//✔ super not allowed in main()
//✔ super() first statement rule
//✔ this() vs super()
//✔ Immediate Parent Concept

package D5_super_keyword;

class Parent {

    void display() {

        System.out.println("Parent Method");
    }
}
class Child extends Parent {
    Child() {
        super(); // Must be first statement
        System.out.println("Child Constructor");
    }
    static void show() {
        // super.display(); // ERROR
        System.out.println("Static methods cannot use super.");
    }
}
public class Demo4 {
    public static void main(String[] args) {
        Child obj = new Child();
        obj.display();
        Child.show();
        // super.display(); // ERROR (main() is static)
    }
}
