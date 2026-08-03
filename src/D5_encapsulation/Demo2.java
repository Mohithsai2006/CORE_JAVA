package D5_encapsulation;
class BankAccount {
    private double balance;
    private final String accountHolder;
    private String password;
    // Constructor
    public BankAccount(String accountHolder) {
        this.accountHolder = accountHolder;
    }
    // Setter with validation
    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        } else {
            System.out.println("Invalid Balance!");
        }
    }
    // Getter (Read-only)
    public double getBalance() {
        return balance;
    }
    // Read-only property
    public String getAccountHolder() {
        return accountHolder;
    }
    // Write-only property
    public void setPassword(String password) {
        this.password = password;
        System.out.println("Password Updated Successfully");
    }
    // No getPassword() provided
}

public class Demo2 {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount("Rahul");
        acc.setBalance(5000);
        System.out.println("Balance : " + acc.getBalance());
        acc.setBalance(-1000);   // Validation fails
        System.out.println("Account Holder : " + acc.getAccountHolder());
        acc.setPassword("Java@123");
        //System.out.println(acc.getPassword()); // Compile-time Error
    }
}
//Topics Covered
//✔ Validation
//✔ Data Security
//✔ Read-only Object
//✔ Write-only Object
//✔ Getter only
//✔ Setter only
//✔ Invalid data prevention