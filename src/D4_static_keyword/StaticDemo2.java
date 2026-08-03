package D4_static_keyword;

class Employee {
    static int companyId;
    // Static Block 1
    static {
        System.out.println("Static Block 1");
//        companyId = 1001;
    }
    // Static Block 2
    static {
        System.out.println("Static Block 2");
    }
    // Instance Block
    {
       System.out.println("Instance Block");
    }
    // Constructor
    Employee() {
        System.out.println("Constructor");
    }
    static void companyInfo() {
        System.out.println("Company ID : " + companyId);
    }
}
public class StaticDemo2 {
    static {
        System.out.println("Main Class Static Block");
    }
    public static void main(String[] args) {
        System.out.println("Main Started");
        Employee.companyInfo();
        System.out.println();
        Employee e1 = new Employee();
        System.out.println();
        Employee e2 = new Employee();
        System.out.println();
        System.out.println("Main Ended");
    }
}

//
//Concepts covered
//
//Static block
//Multiple static blocks
//Static variable initialization
//Static method
//Constructor
//Instance block
//Main method execution order