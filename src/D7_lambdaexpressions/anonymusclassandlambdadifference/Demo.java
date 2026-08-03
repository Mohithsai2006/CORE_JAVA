package D7_lambdaexpressions.anonymusclassandlambdadifference;

public class Demo {
    public static void main(String[] args) {

        // ================================
        // Anonymous Inner Class
        // ================================

        Greeting g1 = new Greeting() {

            // Compiler creates a separate anonymous class internally.
            @Override
            public void sayHello() {
                System.out.println("Hello from Anonymous Class");
            }
        };

        // Calling abstract method
        g1.sayHello();


        // ================================
        // Lambda Expression
        // ================================

        // Lambda provides implementation of sayHello()
        Greeting g2 = () -> {
            System.out.println("Hello from Lambda Expression");
        };

        g2.sayHello();
    }
}
