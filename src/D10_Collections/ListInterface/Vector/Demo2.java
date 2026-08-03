package D10_Collections.ListInterface.Vector;

import java.util.Collections;
import java.util.Enumeration;
import java.util.Vector;

/*
 * ============================================================================
 *                           VECTOR - DEMO 2
 * ============================================================================
 *
 * Definition
 * ----------
 * This demo covers the remaining methods available in Vector.
 *
 * Vector is one of the oldest collection classes in Java.
 * Apart from implementing List, it also provides several legacy
 * methods that existed before the Collections Framework.
 *
 * ============================================================================
 * TOPICS COVERED
 * ============================================================================
 *
 * ✔ Legacy Methods
 * ✔ Capacity Management
 * ✔ Bulk Operations
 * ✔ Enumeration
 * ✔ Cloning
 * ✔ Conversion to Array
 * ✔ Clearing Vector
 *
 * ============================================================================
 * METHODS COVERED
 * ============================================================================
 *
 * Legacy Methods
 * --------------
 * firstElement()
 * lastElement()
 * elementAt()
 * insertElementAt()
 * setElementAt()
 * removeElementAt()
 * removeAllElements()
 *
 * Capacity Methods
 * ----------------
 * capacity()
 * ensureCapacity()
 * trimToSize()
 * setSize()
 *
 * Bulk Operations
 * ---------------
 * addAll()
 * containsAll()
 * removeAll()
 * retainAll()
 *
 * Other Methods
 * -------------
 * clone()
 * copyInto()
 * toArray()
 * elements()  --> Enumeration
 *
 * ============================================================================
 */

public class Demo2 {

    public static void main(String[] args) {

        Vector<Student> students = new Vector<>();

        /*
         * ---------------------------------------------------------
         * Adding Students
         * ---------------------------------------------------------
         */

        students.add(new Student(101, "Mohith", 90));
        students.add(new Student(102, "Rahul", 80));
        students.add(new Student(103, "Sai", 95));

        System.out.println("Original Vector");
        System.out.println(students);

        /*
         * =========================================================
         * LEGACY METHODS
         * =========================================================
         */

        System.out.println("\n========== LEGACY METHODS ==========");

        /*
         * Returns first element.
         */

        System.out.println("First Element : "
                + students.firstElement());

        /*
         * Returns last element.
         */

        System.out.println("Last Element : "
                + students.lastElement());

        /*
         * Returns element present at given index.
         */

        System.out.println("Element At Index 1 : "
                + students.elementAt(1));

        /*
         * Inserts object at specified position.
         */

        students.insertElementAt(
                new Student(104,
                        "Ajay",
                        75),
                1);

        System.out.println("\nAfter insertElementAt()");
        System.out.println(students);

        /*
         * Replaces element.
         */

        students.setElementAt(
                new Student(105,
                        "Updated Student",
                        99),
                2);

        System.out.println("\nAfter setElementAt()");
        System.out.println(students);

        /*
         * Removes element at given position.
         */

        students.removeElementAt(1);

        System.out.println("\nAfter removeElementAt()");
        System.out.println(students);

        /*
         * =========================================================
         * CAPACITY METHODS
         * =========================================================
         */

        System.out.println("\n========== CAPACITY METHODS ==========");

        System.out.println("Current Capacity : "
                + students.capacity());

        /*
         * Ensures minimum capacity.
         *
         * If current capacity is smaller,
         * Vector increases it.
         */

        students.ensureCapacity(25);

        System.out.println("After ensureCapacity(25)");

        System.out.println("Capacity : "
                + students.capacity());

        /*
         * setSize()
         *
         * Changes logical size.
         */

        students.setSize(8);

        System.out.println("\nAfter setSize(8)");

        System.out.println(students);

        System.out.println("Size : "
                + students.size());

        /*
         * trimToSize()
         *
         * Removes unused memory.
         */

        students.trimToSize();

        System.out.println("\nAfter trimToSize()");

        System.out.println("Capacity : "
                + students.capacity());

        /*
         * =========================================================
         * BULK OPERATIONS
         * =========================================================
         */

        Vector<Student> newStudents = new Vector<>();

        newStudents.add(
                new Student(201,
                        "Kiran",
                        85));

        newStudents.add(
                new Student(202,
                        "Anil",
                        87));

        /*
         * addAll()
         */

        students.addAll(newStudents);

        System.out.println("\nAfter addAll()");
        System.out.println(students);

        /*
         * containsAll()
         */

        System.out.println("\nContains All : "
                + students.containsAll(newStudents));

        /*
         * retainAll()
         *
         * Keeps only common elements.
         */

        Vector<Student> copy = new Vector<>(students);

        copy.retainAll(newStudents);

        System.out.println("\nretainAll()");
        System.out.println(copy);

        /*
         * removeAll()
         *
         * Removes matching elements.
         */

        students.removeAll(newStudents);

        System.out.println("\nAfter removeAll()");
        System.out.println(students);
        /*
         * =========================================================
         * CLONE
         * =========================================================
         */
        Vector<Student> cloned =
                (Vector<Student>) students.clone();
        System.out.println("\nCloned Vector");
        System.out.println(cloned);
        /*
         * =========================================================
         * COPY INTO ARRAY
         * =========================================================
         */
        Object[] array =
                new Object[students.size()];
        students.copyInto(array);
        System.out.println("\ncopyInto()");
        for (Object obj : array) {
            System.out.println(obj);
        }
        /*
         * =========================================================
         * TO ARRAY
         * =========================================================
         */
        Object[] objects = students.toArray();
        System.out.println("\ntoArray()");
        for (Object obj : objects) {
            System.out.println(obj);
        }
        /*
         * =========================================================
         * ENUMERATION
         * =========================================================
         *
         * Enumeration is the legacy iterator used before
         * Iterator was introduced.
         *
         * Methods
         * --------
         * hasMoreElements()
         * nextElement()
         */
        System.out.println("\n========== ENUMERATION ==========");
        Enumeration<Student> enumeration =
                students.elements();
        while (enumeration.hasMoreElements()) {
            System.out.println(
                    enumeration.nextElement());
        }
        /*
         * =========================================================
         * REMOVE ALL ELEMENTS
         * =========================================================
         */
        students.removeAllElements();
        System.out.println("\nAfter removeAllElements()");
        System.out.println(students);
        System.out.println("Is Empty : "
                + students.isEmpty());

    }
}