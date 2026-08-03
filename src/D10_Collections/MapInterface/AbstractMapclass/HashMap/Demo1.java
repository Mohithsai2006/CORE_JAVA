package D10_Collections.MapInterface.AbstractMapclass.HashMap;
import java.util.HashMap;
import java.util.Map;
/*
 * ==========================================================
 * DEMO 1 : HASHMAP BASICS
 * ==========================================================
 *
 * Topics Covered
 * --------------
 * ✔ HashMap stores data as Key-Value pairs
 * ✔ Keys are unique
 * ✔ Values can be duplicated
 * ✔ Duplicate key updates existing value
 * ✔ Allows one null key
 * ✔ Allows multiple null values
 * ✔ Constructors
 * ✔ Basic CRUD operations
 * ✔ containsKey() and containsValue()
 * ✔ getOrDefault()
 * ✔ putIfAbsent()
 * ✔ replace()
 * ✔ remove()
 * ✔ size()
 * ✔ Traversing using entrySet()
 * ✔ HashMap does NOT maintain insertion order
 * ✔ HashMap is NOT synchronized
 *
 * Time Complexity (Average)
 * -------------------------
 * put()           -> O(1)
 * get()           -> O(1)
 * remove()        -> O(1)
 * containsKey()  -> O(1)
 */

public class Demo1 {

    public static void main(String[] args) {

        /*
         * Constructor 1
         *
         * Default Capacity = 16
         * Default Load Factor = 0.75
         */

        HashMap<Integer, String> students = new HashMap<>();

        /*
         * put()
         *
         * Adds Key-Value pairs.
         */

        students.put(101, "Mohith");
        students.put(102, "Sai");
        students.put(103, "Java");
        students.put(104, "Spring");

        System.out.println("Initial Map");
        System.out.println(students);

        /*
         * Duplicate key
         *
         * Existing value gets replaced.
         */

        students.put(103, "Spring Boot");

        System.out.println();
        System.out.println("After Updating Key 103");
        System.out.println(students);

        /*
         * Duplicate values are allowed.
         */

        students.put(105, "Sai");

        /*
         * One null key is allowed.
         */

        students.put(null, "Unknown");

        /*
         * Multiple null values are allowed.
         */

        students.put(106, null);
        students.put(107, null);

        System.out.println();
        System.out.println("After Null Key & Null Values");
        System.out.println(students);

        /*
         * get()
         */

        System.out.println();
        System.out.println("Student 102 : "
                + students.get(102));

        /*
         * getOrDefault()
         */

        System.out.println();

        System.out.println("Student 200 : "
                + students.getOrDefault(200, "Not Found"));

        /*
         * containsKey()
         */

        System.out.println();

        System.out.println("Contains Key 101 : "
                + students.containsKey(101));

        /*
         * containsValue()
         */

        System.out.println("Contains Value Java : "
                + students.containsValue("Java"));

        /*
         * putIfAbsent()
         *
         * Adds only if key is absent.
         */

        students.putIfAbsent(102, "Python");

        students.putIfAbsent(108, "Python");

        /*
         * replace()
         */

        students.replace(101, "Mohith Sai");

        /*
         * remove()
         */

        students.remove(107);

        /*
         * size()
         */

        System.out.println();

        System.out.println("Size : "
                + students.size());

        /*
         * Traversing using entrySet()
         */

        System.out.println();
        System.out.println("Traversing HashMap");

        for (Map.Entry<Integer, String> entry
                : students.entrySet()) {

            System.out.println(

                    entry.getKey()

                            + " -> "

                            + entry.getValue());
        }

        /*
         * clear()
         */

        students.clear();

        System.out.println();

        System.out.println("After clear()");

        System.out.println(students);

        System.out.println("Is Empty : "
                + students.isEmpty());

    }

}