package D10_Collections.MapInterface.AbstractMapclass.TreeMap;
import java.util.Map;
import java.util.TreeMap;
/*
 * ==========================================================
 * DEMO 1 : TREEMAP BASICS
 * ==========================================================
 *
 * Topics Covered
 * --------------
 * ✔ TreeMap stores data as Key-Value pairs
 * ✔ Keys are automatically sorted
 * ✔ Uses Natural Ordering (Ascending)
 * ✔ Keys are unique
 * ✔ Values can be duplicated
 * ✔ Duplicate key updates existing value
 * ✔ Null key is NOT allowed
 * ✔ Null values are allowed
 * ✔ Basic CRUD operations
 * ✔ Navigation Methods
 * ✔ firstKey()
 * ✔ lastKey()
 * ✔ higherKey()
 * ✔ lowerKey()
 * ✔ ceilingKey()
 * ✔ floorKey()
 * ✔ descendingMap()
 * ✔ pollFirstEntry()
 * ✔ pollLastEntry()
 * ✔ Traversing using entrySet()
 * Internal Working
 * ----------------
 * TreeMap internally uses a
 * Red-Black Tree (Self Balancing BST)
 *
 * Every insertion automatically
 * places the key in sorted order.
 *
 * Time Complexity
 * ---------------
 * put()          -> O(log n)
 * get()          -> O(log n)
 * remove()       -> O(log n)
 * containsKey()  -> O(log n)
 */
public class Demo1 {
    public static void main(String[] args) {
        /*
         * Default Constructor
         *
         * Uses Natural Ordering.
         */
        TreeMap<Integer, String> students = new TreeMap<>();
        /*
         * put()
         *
         * Keys are inserted.
         *
         * Although inserted randomly,
         * TreeMap automatically sorts them.
         */
        students.put(103, "Spring");
        students.put(101, "Java");
        students.put(105, "React");
        students.put(102, "Python");
        students.put(104, "Hibernate");
        System.out.println("Initial TreeMap");
        System.out.println(students);
        /*
         * Duplicate Key
         *
         * Existing value gets replaced.
         */
        students.put(103, "Spring Boot");
        System.out.println();
        System.out.println("After Updating Key 103");
        System.out.println(students);
        /*
         * Duplicate Values
         *
         * Allowed.
         */
        students.put(106, "Java");

        /*
         * Null Value
         *
         * Allowed.
         */

        students.put(107, null);

        System.out.println();

        System.out.println("After Duplicate & Null Value");

        System.out.println(students);

        /*
         * get()
         *
         * Searches key using
         * Red-Black Tree.
         */

        System.out.println();

        System.out.println("Key 102 : "
                + students.get(102));

        /*
         * containsKey()
         */

        System.out.println();

        System.out.println("Contains Key 104 : "
                + students.containsKey(104));

        /*
         * containsValue()
         */

        System.out.println("Contains Value Java : "
                + students.containsValue("Java"));

        /*
         * firstKey()
         *
         * Returns smallest key.
         */

        System.out.println();

        System.out.println("First Key : "
                + students.firstKey());

        /*
         * lastKey()
         *
         * Returns largest key.
         */

        System.out.println("Last Key : "
                + students.lastKey());

        /*
         * higherKey()
         *
         * Returns next greater key.
         */

        System.out.println();

        System.out.println("Higher Key of 103 : "
                + students.higherKey(103));

        /*
         * lowerKey()
         *
         * Returns next smaller key.
         */

        System.out.println("Lower Key of 103 : "
                + students.lowerKey(103));

        /*
         * ceilingKey()
         *
         * Returns current key
         * or next greater key.
         */

        System.out.println();

        System.out.println("Ceiling Key of 103 : "
                + students.ceilingKey(103));

        System.out.println("Ceiling Key of 1035 : "
                + students.ceilingKey(1035));

        /*
         * floorKey()
         *
         * Returns current key
         * or previous smaller key.
         */

        System.out.println();

        System.out.println("Floor Key of 103 : "
                + students.floorKey(103));

        System.out.println("Floor Key of 1035 : "
                + students.floorKey(1035));

        /*
         * descendingMap()
         *
         * Returns map in reverse order.
         */

        System.out.println();

        System.out.println("Descending Map");

        System.out.println(students.descendingMap());

        /*
         * pollFirstEntry()
         *
         * Removes and returns
         * first entry.
         */

        System.out.println();

        System.out.println("Removed First Entry : "
                + students.pollFirstEntry());

        /*
         * pollLastEntry()
         *
         * Removes and returns
         * last entry.
         */

        System.out.println("Removed Last Entry : "
                + students.pollLastEntry());

        System.out.println();

        System.out.println("TreeMap After Poll Operations");

        System.out.println(students);

        /*
         * Traversing TreeMap
         *
         * Traversal always happens
         * in sorted order.
         */

        System.out.println();

        System.out.println("Traversing TreeMap");

        for (Map.Entry<Integer, String> entry
                : students.entrySet()) {

            System.out.println(

                    entry.getKey()

                            + " -> "

                            + entry.getValue());
        }

        /*
         * remove()
         */

        students.remove(103);

        System.out.println();

        System.out.println("After Removing Key 103");

        System.out.println(students);

        /*
         * size()
         */

        System.out.println();

        System.out.println("Size : "
                + students.size());

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
