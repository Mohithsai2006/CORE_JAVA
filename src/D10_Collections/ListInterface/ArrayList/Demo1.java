package D10_Collections.ListInterface.ArrayList;

import java.lang.reflect.Field;
import java.util.ArrayList;

/*
 * ============================================================================
 *                         ARRAYLIST - DEMO 1
 * ============================================================================
 *
 * Definition
 * ----------
 * ArrayList is one of the most commonly used implementations of the List
 * interface.
 *
 * Internally, it stores elements inside a dynamically growing Object array.
 *
 * Unlike a normal array, ArrayList automatically increases its capacity
 * whenever the current array becomes full.
 *
 *
 * Purpose
 * -------
 * ✔ Store multiple objects dynamically.
 * ✔ Maintain insertion order.
 * ✔ Allow duplicate elements.
 * ✔ Allow null values.
 * ✔ Provide fast random access.
 * ✔ Automatically grow whenever required.
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
 * In Java 8+, ArrayList DOES NOT immediately allocate memory.
 *
 * Memory is allocated only when the first element is inserted.
 *
 * After first insertion,
 * an internal Object array of size 10 is created.
 *
 *
 * --------------------------------------------------------------
 *
 * 2. Initial Capacity : 0
 *
 * Why?
 * ----
 * Initially, ArrayList points to an EMPTY array.
 *
 * No unnecessary memory is allocated.
 *
 *
 * --------------------------------------------------------------
 *
 * 3. Initial Size : 0
 *
 * Why?
 * ----
 * Size represents the number of stored elements.
 *
 * Since no objects are inserted initially,
 * size is zero.
 *
 *
 * --------------------------------------------------------------
 *
 * 4. Growth Strategy : 50%
 *
 * Why?
 * ----
 * Whenever the array becomes full,
 *
 * newCapacity =
 * oldCapacity + (oldCapacity >> 1)
 *
 * Example
 *
 * 10
 * ↓
 * 15
 * ↓
 * 22
 * ↓
 * 33
 * ↓
 * 49
 * ↓
 * 73
 *
 * Growing by 50% reduces memory wastage compared to doubling
 * the size every time.
 *
 *
 * --------------------------------------------------------------
 *
 * 5. Duplicate Elements : YES
 *
 * Why?
 * ----
 * ArrayList implements List.
 * Every List implementation allows duplicates.
 *
 *
 * --------------------------------------------------------------
 *
 * 6. Null Values : YES
 *
 * Why?
 * ----
 * ArrayList stores object references.
 * null is also a valid object reference.
 *
 *
 * --------------------------------------------------------------
 *
 * 7. Insertion Order : Maintained
 *
 * Why?
 * ----
 * Elements are stored sequentially inside the internal array.
 *
 *
 * --------------------------------------------------------------
 *
 * 8. Sorted Order : NO
 *
 * Why?
 * ----
 * Elements remain in insertion order.
 *
 * Sorting happens only when
 * Collections.sort() is called.
 *
 *
 * --------------------------------------------------------------
 *
 * 9. Random Access : YES (O(1))
 *
 * Why?
 * ----
 * Since elements are stored in an array,
 * any index can be accessed directly.
 *
 *
 * --------------------------------------------------------------
 *
 * 10. Thread Safe : NO
 *
 * Why?
 * ----
 * Methods are NOT synchronized.
 *
 * Therefore multiple threads modifying the same ArrayList
 * may produce inconsistent results.
 *
 *
 * --------------------------------------------------------------
 *
 * 11. Best Use Case
 *
 * ArrayList is best suited for
 *
 * ✔ Frequent searching
 * ✔ Frequent retrieval
 * ✔ Random access
 * ✔ Single-threaded applications
 *
 *
 * ============================================================================
 * OPERATIONS COVERED
 * ============================================================================
 *
 * ✔ Creation
 * ✔ Size
 * ✔ Internal Capacity
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

    /*
     * Helper method.
     *
     * ArrayList doesn't expose capacity().
     *
     * Using Reflection ONLY for learning purposes.
     */

    private static int getCapacity(ArrayList<?> list) {

        try {

            Field field =
                    ArrayList.class.getDeclaredField("elementData");

            field.setAccessible(true);

            Object[] array = (Object[]) field.get(list);

            return array.length;

        } catch (Exception e) {

            return -1;
        }

    }

    public static void main(String[] args) {

        /*
         * Initially
         *
         * Size = 0
         * Capacity = 0
         */

        ArrayList<Student> students = new ArrayList<>();


        System.out.println("========== INITIAL DETAILS ==========");

        System.out.println("Initial Size : "
                + students.size());

        System.out.println("Initial Capacity : "
                + getCapacity(students));

        /*
         * ====================================================
         * ADD OPERATION
         * ====================================================
         */

        students.add(new Student(101, "Mohith", 91));

        System.out.println("\nAfter First Insertion");

        System.out.println("Size : "
                + students.size());

        System.out.println("Capacity : "
                + getCapacity(students));

        students.add(new Student(102, "Rahul", 88));

        students.add(new Student(103, "Sai", 77));

        students.add(new Student(104, "Ajay", 90));

        students.add(2,
                new Student(105, "Kiran", 84));

        System.out.println("\nAfter Adding Students");

        System.out.println(students);

        /*
         * ====================================================
         * RETRIEVAL
         * ====================================================
         */

        System.out.println("\nFirst Student");

        System.out.println(students.get(0));

        System.out.println("\nStudent At Index 2");

        System.out.println(students.get(2));

        /*
         * ====================================================
         * UPDATE
         * ====================================================
         */

        students.set(1,
                new Student(200,
                        "Updated Rahul",
                        99));

        System.out.println("\nAfter Update");

        System.out.println(students);

        /*
         * ====================================================
         * VERIFICATION
         * ====================================================
         */

        System.out.println("\nCurrent Size : "
                + students.size());

        System.out.println("Contains First Student : "
                + students.contains(students.get(0)));

        System.out.println("Index Of First Student : "
                + students.indexOf(students.get(0)));

        System.out.println("Is Empty : "
                + students.isEmpty());

        /*
         * ====================================================
         * DELETE
         * ====================================================
         */

        students.remove(2);

        students.remove(students.get(students.size() - 1));

        System.out.println("\nAfter Deletion");

        System.out.println(students);

        /*
         * ====================================================
         * CAPACITY GROWTH
         * ====================================================
         */

        System.out.println("\n========== CAPACITY GROWTH ==========");

        int previousCapacity = getCapacity(students);

        System.out.println("Current Capacity : "
                + previousCapacity);

        int id = 1000;

        while (getCapacity(students) == previousCapacity) {

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
                + getCapacity(students));

        System.out.println("Current Size : "
                + students.size());

        /*
         * Continue filling to observe:
         *
         * 10
         * ↓
         * 15
         * ↓
         * 22
         * ↓
         * 33
         * ↓
         * 49
         *
         * ...
         */

    }

}
