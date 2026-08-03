package D7_lambdaexpressions.effectivelyfinalvariable;

public class Demo1 {

    // Instance variable (stored inside object on Heap)
    int instanceVar = 100;

    // Static variable (stored once per class)
    static int staticVar = 500;

    public void test() {

        // Local variable (stored in Stack)
        int localVar = 10;

        // Lambda Expression
        Printer p = () -> {

            System.out.println("Local    = " + localVar);
            System.out.println("Instance = " + instanceVar);
            System.out.println("Static   = " + staticVar);

            // Allowed
            instanceVar++;

            // Allowed
            staticVar++;

            // NOT Allowed
//             localVar++;

        };

        System.out.println("------ First Call ------");
        p.print();

        System.out.println();

        // Change variables AFTER lambda creation

        instanceVar = 200;

        staticVar = 700;

        // localVar = 20;   // Compile-time Error

        System.out.println("------ Second Call ------");
        p.print();
    }

    public static void main(String[] args) {

        Demo1 obj = new Demo1();

        obj.test();
    }
}
