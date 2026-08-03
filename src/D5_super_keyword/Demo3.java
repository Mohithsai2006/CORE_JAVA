//Demo 3 – Parent Constructor Rules
//Topics Covered
//✔ Parent has only parameterized constructor
//✔ Why super() is required
//✔ Constructor Rules
//✔ Compile-time Error
//✔ Immediate Parent
package D5_super_keyword;
class A {
    A(int x) {
        System.out.println("Parent : " + x);
    }
}
class B extends A {
    B() {
        // super() would cause error
        // because A() does not exist
        super(100);
        System.out.println("Child Constructor");
    }
}
public class Demo3 {
    public static void main(String[] args) {
        B obj = new B();
    }
}