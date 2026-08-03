package D10_Collections.ListInterface.Vector.Stack;

import java.util.Stack;

/*
 * ============================================================================
 *                           STACK - DEMO 1
 * ============================================================================
 *
 * Definition
 * ----------
 * Stack is a legacy collection class that extends Vector.
 *
 * It follows the LIFO (Last In First Out) principle,
 * meaning the element inserted last is removed first.
 *
 *
 * Inheritance Hierarchy
 * ---------------------
 *
 *        Object
 *           │
 *           ▼
 *        Vector
 *           │
 *           ▼
 *         Stack
 *
 * Since Stack extends Vector,
 * it inherits all Vector methods like
 *
 * add()
 * get()
 * set()
 * remove()
 * contains()
 * size()
 * capacity()
 * etc.
 *
 *
 * ============================================================================
 * PURPOSE
 * ============================================================================
 *
 * Stack is mainly used whenever data needs to be processed
 * in reverse order.
 *
 * Common Applications
 * -------------------
 * ✔ Undo / Redo
 * ✔ Browser Back Button
 * ✔ Function Call Stack
 * ✔ Expression Evaluation
 * ✔ Parenthesis Matching
 * ✔ DFS (Depth First Search)
 *
 *
 * ============================================================================
 * IMPORTANT INTERVIEW POINTS
 * ============================================================================
 *
 * 1. Default Capacity : 10
 *
 * Why?
 * ----
 * Stack extends Vector.
 * Therefore it inherits Vector's default capacity.
 *
 *
 * --------------------------------------------------------------
 *
 * 2. Initial Size : 0
 *
 * Why?
 * ----
 * Initially no elements are stored.
 *
 *
 * --------------------------------------------------------------
 *
 * 3. Growth Strategy : 100%
 *
 * Why?
 * ----
 * Since Stack extends Vector,
 * it follows the same growth strategy.
 *
 * 10
 * ↓
 * 20
 * ↓
 * 40
 * ↓
 * 80
 *
 *
 * --------------------------------------------------------------
 *
 * 4. Duplicate Elements : YES
 *
 * Why?
 * ----
 * Stack inherits Vector,
 * which implements List.
 *
 *
 * --------------------------------------------------------------
 *
 * 5. Null Values : YES
 *
 * Why?
 * ----
 * Stack stores object references.
 * Therefore null values are allowed.
 *
 *
 * --------------------------------------------------------------
 *
 * 6. Insertion Order : Maintained
 *
 * Why?
 * ----
 * Elements are internally stored
 * inside an array exactly in insertion order.
 *
 * However,
 * insertion order and removal order are different.
 *
 *
 * Example
 *
 * Insert
 *
 * A
 * B
 * C
 *
 * Removal
 *
 * C
 * B
 * A
 *
 *
 * --------------------------------------------------------------
 *
 * 7. Sorted Order : NO
 *
 * Why?
 * ----
 * Stack never sorts elements automatically.
 *
 *
 * --------------------------------------------------------------
 *
 * 8. Random Access : YES
 *
 * Why?
 * ----
 * Since Stack extends Vector,
 * get(index) is available.
 *
 *
 * --------------------------------------------------------------
 *
 * 9. Thread Safe : YES
 *
 * Why?
 * ----
 * Stack inherits synchronized methods
 * from Vector.
 *
 *
 * --------------------------------------------------------------
 *
 * 10. Best Use Case
 *
 * Use Stack whenever LIFO behaviour
 * is required.
 *
 *
 * ============================================================================
 * DEMO 1 TOPICS
 * ============================================================================
 *
 * ✔ Creation
 * ✔ Initial Size
 * ✔ Capacity
 * ✔ Capacity Growth
 * ✔ Addition
 * ✔ Retrieval
 * ✔ Updation
 * ✔ Verification
 * ✔ Deletion
 *
 * ============================================================================
 */

public class Demo1 {

    public static void main(String[] args) {

        /*
         * Creates an empty Stack.
         *
         * Internally this is still a Vector.
         */

        Stack<Student> students = new Stack<>();

        System.out.println("========== INITIAL DETAILS ==========");

        System.out.println("Initial Size : "
                + students.size());

        System.out.println("Initial Capacity : "
                + students.capacity());



        /*
         * =====================================================
         * ADD OPERATION
         * =====================================================
         */

        students.add(
                new Student(101,
                        "Mohith",
                        91));

        students.add(
                new Student(102,
                        "Rahul",
                        82));

        students.add(
                new Student(103,
                        "Sai",
                        88));

        students.add(
                new Student(104,
                        "Ajay",
                        95));

        /*
         * Insert at specific index.
         */

        students.add(2,
                new Student(
                        105,
                        "Kiran",
                        86));



        System.out.println("\n========== AFTER INSERTION ==========");

        System.out.println(students);



        /*
         * =====================================================
         * RETRIEVAL
         * =====================================================
         */

        System.out.println("\nFirst Element");

        System.out.println(students.firstElement());



        System.out.println("\nLast Element");

        System.out.println(students.lastElement());



        System.out.println("\nElement At Index 2");

        System.out.println(students.get(2));



        /*
         * =====================================================
         * UPDATE
         * =====================================================
         */

        students.set(1,
                new Student(
                        200,
                        "Updated Rahul",
                        99));



        System.out.println("\n========== AFTER UPDATE ==========");

        System.out.println(students);



        /*
         * =====================================================
         * VERIFICATION
         * =====================================================
         */

        System.out.println("\nCurrent Size : "
                + students.size());



        System.out.println("Current Capacity : "
                + students.capacity());



        System.out.println("Contains First Student : "
                + students.contains(
                students.firstElement()));



        System.out.println("Index Of First Student : "
                + students.indexOf(
                students.firstElement()));



        System.out.println("Is Empty : "
                + students.isEmpty());



        /*
         * =====================================================
         * DELETE
         * =====================================================
         */

        students.remove(2);

        students.remove(students.lastElement());



        System.out.println("\n========== AFTER DELETION ==========");

        System.out.println(students);



        /*
         * =====================================================
         * CAPACITY GROWTH
         * =====================================================
         *
         * Stack grows exactly like Vector.
         */

        System.out.println("\n========== CAPACITY GROWTH ==========");

        int previousCapacity = students.capacity();

        System.out.println("Capacity Before Filling : "
                + previousCapacity);

        int id = 1000;

        while (students.capacity() == previousCapacity) {

            students.add(
                    new Student(
                            id,
                            "Student-" + id,
                            80));

            id++;
        }

        System.out.println("Old Capacity : "
                + previousCapacity);

        System.out.println("New Capacity : "
                + students.capacity());

        System.out.println("Current Size : "
                + students.size());



        /*
         * Expected Growth
         *
         * 10
         * ↓
         * 20
         * ↓
         * 40
         * ↓
         * 80
         *
         * Same as Vector.
         */

    }

}