package D5_abstraction;
public class Demo3 {

    public static void main(String[] args) {


        /*
            Parent reference
            Child object


            Account reference
            SavingsAccount object


            Runtime polymorphism
        */


        Account account =
                new SavingsAccount(
                        101,
                        "Mohith",
                        50000
                );


        System.out.println("----- ACCOUNT DETAILS -----");

        account.showDetails();


        System.out.println("\n----- BANK OPERATIONS -----");

        account.deposit(10000);

        account.withdraw(5000);



        /*
            Accessing interface methods

            Account reference cannot directly
            access interface methods.

            So we type cast.

        */


        Transferable transfer =
                (Transferable) account;


        transfer.transferMoney(2000);



        LoanEligible loan =
                (LoanEligible) account;


        loan.applyLoan();



        Taxable tax =
                (Taxable) account;


        tax.calculateTax();



        System.out.println("\n----- STATIC METHOD -----");

        Account.bankInfo();

    }
}



/*
    ABSTRACT CLASS

    Represents identity.

    Account IS-A base concept.

    Every account has:

    accountNumber
    holderName
    balance

*/


abstract class Account {


    int accountNumber;

    String holderName;

    double balance;



    Account(
            int accountNumber,
            String holderName,
            double balance
    ) {

        this.accountNumber = accountNumber;

        this.holderName = holderName;

        this.balance = balance;


        System.out.println(
                "Account constructor executed"
        );
    }



    /*
        Concrete method

        Common for every account.
    */

    void deposit(double amount) {

        balance += amount;

        System.out.println(
                "Deposited : " + amount
        );
    }



    /*
        Abstract method

        Different accounts have
        different withdrawal rules.
    */

    abstract void withdraw(double amount);



    /*
        Concrete method
    */

    void showDetails() {

        System.out.println(
                "Account Number : "
                        + accountNumber
        );


        System.out.println(
                "Holder Name : "
                        + holderName
        );


        System.out.println(
                "Balance : "
                        + balance
        );
    }



    static void bankInfo() {

        System.out.println(
                "ABC Banking System"
        );
    }

}





/*
    INTERFACE 1

    Capability:

    Account can transfer money.

*/


interface Transferable {


    void transferMoney(double amount);


}




/*
    INTERFACE 2

    Capability:

    Account can apply loan.

*/


interface LoanEligible {


    void applyLoan();


}




/*
    INTERFACE 3

    Capability:

    Account can calculate tax.

*/


interface Taxable {


    void calculateTax();

}





/*
    Concrete Class


    SavingsAccount:

    IS-A Account

    CAN-DO:

    Transfer

    Loan

    Tax

*/


class SavingsAccount extends Account
        implements Transferable, LoanEligible, Taxable {



    SavingsAccount(
            int accountNumber,
            String holderName,
            double balance
    ) {

        super(
                accountNumber,
                holderName,
                balance
        );


        System.out.println(
                "Savings Account constructor executed"
        );
    }




    @Override
    void withdraw(double amount) {


        if(amount <= balance) {

            balance -= amount;

            System.out.println(
                    "Withdrawn : " + amount
            );

        }
        else {

            System.out.println(
                    "Insufficient balance"
            );
        }

    }





    @Override
    public void transferMoney(double amount) {


        balance -= amount;


        System.out.println(
                "Transferred : " + amount
        );
    }




    @Override
    public void applyLoan() {


        System.out.println(
                "Loan approved for Savings Account"
        );

    }





    @Override
    public void calculateTax() {


        System.out.println(
                "Tax calculated"
        );

    }

}
