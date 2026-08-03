package proxydesignpattern.virtualproxy.reflectiondynamicproxy;

/*
 * ==========================================================
 * REAL OBJECT
 * ==========================================================
 *
 * This class contains the actual business logic.
 *
 * Creating this object is assumed to be expensive,
 * so we will create it only when required.
 */

public class StudentServiceImpl implements StudentService {

    /*
     * Constructor
     *
     * This will execute only once because
     * our proxy lazily creates this object.
     */
    public StudentServiceImpl() {

        System.out.println("Creating Expensive StudentService...");
    }

    @Override
    public void addStudent() {

        System.out.println("Student Added");
    }

    @Override
    public void deleteStudent() {

        System.out.println("Student Deleted");
    }

    @Override
    public void updateStudent() {

        System.out.println("Student Updated");
    }
}
