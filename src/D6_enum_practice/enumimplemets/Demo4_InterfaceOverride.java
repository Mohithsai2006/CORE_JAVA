package D6_enum_practice.enumimplemets;
/*
 * ==========================================================
 * DEMO 4 : INTERFACES & METHOD OVERRIDING
 * ==========================================================
 *
 * Topics Covered
 * --------------
 * ✔ Enum implements Interface
 * ✔ Abstract Method
 * ✔ Constant Specific Implementation
 * ✔ Method Overriding
 * ✔ Override toString()
 * ✔ Why Enum cannot extend another class
 *
 * ==========================================================
 */
// Enum CAN implement interfaces
interface Calculator {
    int calculate(int a, int b);
}
// Every constant behaves like an object.
enum Operation implements Calculator {
    /*
     * Every constant overrides calculate().
     * Think of every constant as its own object.
     */
    ADD {
        @Override
        public int calculate(int a, int b) {
            return a + b;
        }
        @Override
        public String toString() {
            return "Addition Operation";
        }
    },
    SUBTRACT {
        @Override
        public int calculate(int a, int b) {
            return a - b;
        }
        @Override
        public String toString() {
            return "Subtraction Operation";
        }
    },
    MULTIPLY {
        @Override
        public int calculate(int a, int b) {
            return a * b;
        }
        @Override
        public String toString() {
            return "Multiplication Operation";
        }
    },
    DIVIDE {
        @Override
        public int calculate(int a, int b) {
            return a / b;
        }
        @Override
        public String toString() {
            return "Division Operation";
        }
    };
}
public class Demo4_InterfaceOverride {
    public static void main(String[] args) {
        Operation op1 = Operation.ADD;
        Operation op2 = Operation.SUBTRACT;
        Operation op3 = Operation.MULTIPLY;
        Operation op4 = Operation.DIVIDE;
        System.out.println(op1);
        System.out.println(op1.calculate(10, 20));
        System.out.println();
        System.out.println(op2);
        System.out.println(op2.calculate(50, 10));
        System.out.println();
        System.out.println(op3);
        System.out.println(op3.calculate(5, 4));
        System.out.println();
        System.out.println(op4);
        System.out.println(op4.calculate(20, 5));
    }
}
