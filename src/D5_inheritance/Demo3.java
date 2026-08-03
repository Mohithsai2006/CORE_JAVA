package D5_inheritance;
/*
 * ============================================================
 * Demo 3 : Advanced Inheritance
 *
 * Concepts Covered
 * ----------------
 * 1. Hierarchical Inheritance
 * 2. protected
 * 3. super.variable
 * 4. super.method()
 * 5. final method
 * 6. Upcasting
 * 7. Downcasting
 * 8. instanceof
 * ============================================================
 */

class Employee {

    // Accessible inside subclasses
    protected String company = "OpenAI";

    String role = "Employee";

    Employee() {
        System.out.println("Employee Constructor");
    }

    void work() {
        System.out.println("Employee is working...");
    }

    final void login() {
        System.out.println("Secure Login Successful");
    }
}

class Developer extends Employee {

    String role = "Developer";

    @Override
    void work() {

        System.out.println("Developer writes Java code");

        System.out.println("Company : " + company);

        // Parent variable
        System.out.println("Parent Role : " + super.role);

        // Child variable
        System.out.println("Child Role  : " + role);

        // Parent method
        super.work();
    }

    void code() {
        System.out.println("Coding Spring Boot...");
    }
}

class Tester extends Employee {

    @Override
    void work() {
        System.out.println("Tester tests application");
    }
}

public class Demo3 {

    public static void main(String[] args) {

        System.out.println("===== Upcasting =====");

        Employee emp = new Developer();

        emp.work();

        emp.login();

        System.out.println();

        System.out.println("===== Downcasting =====");

        if (emp instanceof Developer) {

            Developer dev = (Developer) emp;

            dev.code();
        }

        System.out.println();

        System.out.println("===== Hierarchical Inheritance =====");

        Employee tester = new Tester();

        tester.work();
    }
}
