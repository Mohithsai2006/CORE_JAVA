package D6_interfaces;
//------------------------------------------------------------
// Program: Default Method Conflict
//------------------------------------------------------------
interface A {
    default void show() {
        System.out.println("Inside Interface A");
    }
}
interface B {
    default void show() {
        System.out.println("Inside Interface B");
    }
}
// Must override because both interfaces
// contain the same default method.
class Demo1 implements A, B {
    @Override
    public void show() {
        A.super.show();
        B.super.show();
        System.out.println("Inside Demo");
    }
}
public class DefaultMethodConflict {
    public static void main(String[] args) {
        Demo1 demo = new Demo1();
        demo.show();
    }
}
/*
----------------------------
Output
----------------------------
Inside Interface A
Inside Interface B
Inside Demo
----------------------------
Topics Covered
----------------------------
✔ Default methods
✔ Conflict resolution
✔ A.super.method()
*/