package D5_abstraction;

public class Demo2 {

    public static void main(String[] args) {

        Payment payment1 = new UpiPayment();
        Payment payment2 = new CardPayment();

        System.out.println("----- UPI PAYMENT -----");

        payment1.pay(5000);
        payment1.refund();


        System.out.println("\n----- CARD PAYMENT -----");

        payment2.pay(8000);
        payment2.refund();


        System.out.println("\n----- STATIC METHOD -----");

        Payment.paymentInfo();


        System.out.println("\n----- FUNCTIONAL INTERFACE -----");

        Calculator calculator = (a, b) -> a + b;

        System.out.println(
                "Addition : " + calculator.calculate(20, 30)
        );
    }
}


/*
    Interface

    It defines a contract.

    It tells WHAT should be done,
    not HOW it should be done.

*/

interface Payment {

    // Interface variables are:
    // public static final automatically

    int MAX_TRANSACTION = 100000;


    // Abstract method
    // public abstract automatically

    void pay(double amount);



    // Default method
    // Introduced in Java 8

    default void refund() {

        validateTransaction();

        System.out.println("Refund completed");
    }



    // Private method
    // Introduced in Java 9

    private void validateTransaction() {

        System.out.println("Transaction validation completed");
    }



    // Static method
    // Belongs to interface

    static void paymentInfo() {

        System.out.println("Online Payment System");
    }

}



/*
    First implementation
*/

class UpiPayment implements Payment {

    @Override
    public void pay(double amount) {

        System.out.println(
                "Paid using UPI : " + amount
        );
    }
}



/*
    Second implementation
*/

class CardPayment implements Payment {

    @Override
    public void pay(double amount) {

        System.out.println(
                "Paid using Card : " + amount
        );
    }
}



/*
    Functional Interface

    Contains exactly one abstract method.

    Used with Lambda expressions.

*/

@FunctionalInterface
interface Calculator {

    int calculate(int a, int b);

}