package D10_Collections.ListInterface.Vector;
import java.util.Vector;

/*
 * ============================================================================
 *                         VECTOR - DEMO 1
 * ============================================================================
 *
 * Definition
 * ----------
 * Vector is a legacy implementation of the List interface.
 *
 * Internally it stores elements inside a dynamic Object array.
 * Whenever the current capacity becomes full, Vector automatically
 * creates a bigger array and copies all existing elements into it.
 *
 *
 * Purpose
 * -------
 * ✔ Store objects dynamically.
 * ✔ Maintain insertion order.
 * ✔ Allow duplicate elements.
 * ✔ Allow null values.
 * ✔ Provide index-based access.
 * ✔ Provide thread safety using synchronized methods.
 *
 *
 * ============================================================================
 * IMPORTANT INTERVIEW POINTS
 * ============================================================================
 *
 * 1. Default Capacity : 10
 *
 *    Why?
 *    ----
 *    Vector allocates an internal Object array capable of storing
 *    10 elements when the default constructor is used.
 *
 *
 * 2. Initial Size : 0
 *
 *    Why?
 *    ----
 *    Capacity indicates allocated memory.
 *    Size indicates stored elements.
 *
 *    Initially memory is allocated,
 *    but no elements are inserted.
 *
 *
 * 3. Growth Rate : 100%
 *
 *    Why?
 *    ----
 *    When capacity becomes full,
 *    Vector doubles its capacity.
 *
 *    Example
 *
 *    10
 *      ↓
 *    20
 *      ↓
 *    40
 *      ↓
 *    80
 *      ↓
 *    160
 *
 *    This reduces frequent reallocations.
 *
 *
 * 4. Duplicate Elements : YES
 *
 *    Why?
 *    ----
 *    Vector implements List.
 *    Every List implementation allows duplicates.
 *
 *
 * 5. Null Values : YES
 *
 *    Why?
 *    ----
 *    Vector stores object references.
 *    null is also a valid object reference.
 *
 *
 * 6. Insertion Order : YES
 *
 *    Why?
 *    ----
 *    Elements are stored sequentially
 *    inside the internal array.
 *
 *
 * 7. Sorted Order : NO
 *
 *    Why?
 *    ----
 *    Vector stores elements exactly
 *    in insertion order.
 *
 *    Sorting happens only when
 *    Collections.sort() is used.
 *
 *
 * 8. Random Access : YES (O(1))
 *
 *    Why?
 *    ----
 *    Since Vector uses an array,
 *    any element can be accessed directly
 *    using its index.
 *
 *
 * 9. Thread Safe : YES
 *
 *    Why?
 *    ----
 *    Almost every public method
 *    is synchronized.
 *
 *    Therefore,
 *    only one thread can execute
 *    those methods at a time.
 *
 *
 * 10. Best Use Case
 *
 *     Use Vector when multiple threads
 *     modify the same list.
 *
 *     Otherwise ArrayList is usually preferred
 *     because it avoids synchronization overhead.
 *
 *
 * ============================================================================
 * MAJOR OPERATIONS COVERED
 * ============================================================================
 *
 * ✔ Creation
 * ✔ Size
 * ✔ Capacity
 * ✔ Capacity Growth
 * ✔ Add
 * ✔ Retrieve
 * ✔ Update
 * ✔ Verification
 * ✔ Delete
 *
 * ============================================================================
 */

public class Demo1 {

    public static void main(String[] args) {

        /*
         * Creates an empty Vector.
         *
         * Default Capacity = 10
         * Initial Size = 0
         */

        Vector<Student> students = new Vector<>();


        System.out.println("========== INITIAL DETAILS ==========");

        System.out.println("Initial Size     : " + students.size());

        System.out.println("Initial Capacity : " + students.capacity());


        /*
         * ====================================================
         * ADD OPERATION
         * ====================================================
         */

        students.add(new Student(101, "Mohith", 91.5));

        students.add(new Student(102, "Rahul", 82.3));

        students.add(new Student(103, "Sai", 76.2));

        students.add(new Student(104, "Kiran", 88.4));

        /*
         * Insert at a specific index.
         */

        students.add(2,
                new Student(105, "Ajay", 93.7));


        System.out.println("\n========== AFTER INSERTION ==========");

        System.out.println(students);


        /*
         * ====================================================
         * RETRIEVAL OPERATIONS
         * ====================================================
         */

        System.out.println("\nFirst Student");

        System.out.println(students.firstElement());

        System.out.println("\nLast Student");

        System.out.println(students.lastElement());

        System.out.println("\nStudent at Index 2");

        System.out.println(students.get(2));


        /*
         * ====================================================
         * UPDATE OPERATION
         * ====================================================
         */

        students.set(1,
                new Student(200,
                        "Updated Rahul",
                        95.0));

        System.out.println("\n========== AFTER UPDATE ==========");

        System.out.println(students);


        /*
         * ====================================================
         * VERIFICATION OPERATIONS
         * ====================================================
         */

        System.out.println("\nCurrent Size : "
                + students.size());

        System.out.println("Current Capacity : "
                + students.capacity());

        System.out.println("Is Empty : "
                + students.isEmpty());

        System.out.println("Contains First Student : "
                + students.contains(students.firstElement()));

        System.out.println("Index Of First Student : "
                + students.indexOf(students.firstElement()));


        /*
         * ====================================================
         * DELETE OPERATIONS
         * ====================================================
         */

        students.remove(2);

        students.remove(students.lastElement());

        System.out.println("\n========== AFTER DELETION ==========");

        System.out.println(students);


        /*
         * ====================================================
         * CAPACITY GROWTH DEMONSTRATION
         * ====================================================
         *
         * Add more elements until capacity increases.
         */

        System.out.println("\n========== CAPACITY GROWTH ==========");

        System.out.println("Capacity Before Filling : "
                + students.capacity());

        int previousCapacity = students.capacity();

        int id = 1000;

        while (students.capacity() == previousCapacity) {

            students.add(
                    new Student(
                            id++,
                            "Student-" + id,
                            80));
        }

        System.out.println("Old Capacity : "
                + previousCapacity);

        System.out.println("New Capacity : "
                + students.capacity());

        System.out.println("Current Size : "
                + students.size());

        /*
         * Expected Output
         *
         * Old Capacity : 10
         * New Capacity : 20
         *
         * (Capacity doubled by 100%)
         */

    }

}