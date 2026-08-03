package D5_final_keyword;
//Demo 4 – Rules, Static Final, Abstract, Interface, Invalid Combinations
//Topics Covered
//✔ blank static final
//✔ static block initialization
//✔ final abstract class
//✔ final abstract method
//✔ final interface method
//✔ Compile-time Rules
 class Constants {
    // Blank static final
    static final double PI;
    static {
        PI = 3.14159; // Initialized once
    }
}
abstract class Shape {
    abstract void draw();
    final void display() {
        System.out.println("Final Method");
    }
}
class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing Circle");
    }
    /*
    void display() { } // Compile-time Error
    */
}
public class Demo4 {
    public static void main(String[] args) {
        Circle c = new Circle();
        c.draw();
        c.display();
        System.out.println(Constants.PI);
        /*
        Invalid Examples
        final abstract class A { }
        final abstract void show();
        interface Test{
            final void display();
        }
        final constructor() { }
        */
    }
}