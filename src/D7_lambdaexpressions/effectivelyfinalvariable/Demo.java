package D7_lambdaexpressions.effectivelyfinalvariable;
public class Demo {
    int y=10;
    public static void main(String[] args) {
        // Local variable
        int number = 100;
        // Lambda captures the value of number
        Printer p = () -> {

            System.out.println("Number = " + number);

        };
        p.print();
        // Uncommenting below line gives compile-time error
//        number++;
        /*
        Error:
        Local variable number defined in an enclosing scope
        must be final or effectively final.
        */
    }
}