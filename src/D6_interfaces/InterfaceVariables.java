package D6_interfaces;
//------------------------------------------------------------
// Program: Interface Variables
// Demonstrates:
// 1. Variables inside interface
// 2. public static final
// 3. Accessing constants
//-----------------------------------------------------------
interface College {
    // Compiler automatically adds:
    // public static final
    int FEES = 50000;
    String COLLEGE_NAME = "ABC Engineering College";
}
public class InterfaceVariables {
    public static void main(String[] args) {
        // Access using interface name.
        System.out.println("College Name : " + College.COLLEGE_NAME);
        System.out.println("Fees : " + College.FEES);
        // Not Allowed
        // College.FEES = 60000;
        // Interface variables are final.
    }
}
/*
Topics Covered
✔ Interface variables
✔ public static final
✔ Constants
✔ Access using interface name
*/