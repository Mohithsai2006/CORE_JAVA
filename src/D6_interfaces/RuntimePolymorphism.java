package D6_interfaces;
//------------------------------------------------------------
// Program: Runtime Polymorphism
//------------------------------------------------------------
interface Shape {
    void draw();
}
class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }
}
class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Rectangle");
    }
}
public class RuntimePolymorphism {
    public static void main(String[] args) {
        Shape shape;
        shape = new Circle();
        shape.draw();
        shape = new Rectangle();
        shape.draw();
    }
}
/*
----------------------------
Output
----------------------------
Drawing Circle
Drawing Rectangle
----------------------------
Topics Covered
----------------------------
✔ Runtime polymorphism
✔ Dynamic method dispatch
✔ Interface reference
*/