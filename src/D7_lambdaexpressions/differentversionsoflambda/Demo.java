package D7_lambdaexpressions.differentversionsoflambda;
// No Parameter
@FunctionalInterface
interface Message {

    void print();
}

// One Parameter
@FunctionalInterface
interface Square {

    int square(int x);
}

// Multiple Parameters
@FunctionalInterface
interface Calculator {

    int add(int a, int b);
}
public class Demo {

    public static void main(String[] args) {

        // ===============================
        // No Parameter
        // ===============================

        // Empty brackets because method has no parameters
        Message m = () -> System.out.println("Welcome!");

        m.print();


        // ===============================
        // One Parameter
        // ===============================

        // Datatype omitted
        // Compiler infers x is int
        Square s = x -> x * x;

        System.out.println("Square = " + s.square(5));


        // ===============================
        // Multiple Parameters
        // ===============================

        // Parentheses mandatory for multiple parameters
        Calculator c1 = (a, b) -> a + b;

        System.out.println("Sum = " + c1.add(10, 20));


        // ===============================
        // Multiple Statements
        // ===============================

        Calculator c2 = (a, b) -> {

            int result = a + b;

            System.out.println("Adding numbers...");

            // return required because body uses {}
            return result;
        };

        System.out.println(c2.add(40, 60));
    }
}
