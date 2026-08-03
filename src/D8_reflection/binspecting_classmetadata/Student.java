package D8_reflection.binspecting_classmetadata;
/*
 * An interface just to demonstrate
 * getInterfaces().
 */
interface Learner {

}
/*
 * Parent class to demonstrate
 * getSuperclass().
 */
class Person {

}
/*
 * Student class whose metadata
 * will be inspected.
 */
public class Student extends Person implements Learner {
    // Instance variable
    private int id;
    // Static variable
    static String college = "ABC";
    // Constructor
    public Student() {

    }
    // Normal Method
    public void study() {

    }
}