package D10_Collections.MapInterface.AbstractMapclass.TreeMap;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
/*
 * ==========================================================
 * DEMO 2 : TREEMAP USING CUSTOM COMPARATOR
 * ==========================================================
 *
 * Topics Covered
 * --------------
 * ✔ Custom Comparator
 * ✔ Descending Order
 * ✔ Comparator Interface
 * ✔ compare() Method
 * ✔ CRUD Operations
 * ✔ Traversing TreeMap
 *
 * Interview Points
 * ----------------
 * TreeMap normally sorts keys
 * using Natural Ordering.
 *
 * If a Comparator is supplied,
 * TreeMap ignores Natural Ordering
 * and follows Comparator logic.
 *
 * Time Complexity
 * ---------------
 * put()          -> O(log n)
 * get()          -> O(log n)
 * remove()       -> O(log n)
 */

/*
 * Custom Comparator
 *
 * Sorts keys in descending order.
 */
class DescendingComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer key1, Integer key2) {
        /*
         * Reverse comparison.
         *
         * Larger key comes first.
         */
        return key2.compareTo(key1);
    }
}
public class Demo2 {
    public static void main(String[] args) {
        /*
         * TreeMap using
         * Custom Comparator.
         */
        TreeMap<Integer, String> students =
                new TreeMap<>(new DescendingComparator());
        /*
         * Insert entries.
         *
         * Comparator decides
         * where every key is stored.
         */
        students.put(103, "Spring");
        students.put(101, "Java");
        students.put(105, "React");
        students.put(102, "Python");
        students.put(104, "Hibernate");
        System.out.println("TreeMap (Descending Order)");
        System.out.println(students);
        /*
         * get()
         */
        System.out.println();
        System.out.println("Key 104 : "
                + students.get(104));

        /*
         * firstKey()
         *
         * Since descending order,
         * first key becomes largest.
         */

        System.out.println();

        System.out.println("First Key : "
                + students.firstKey());

        /*
         * lastKey()
         *
         * Smallest key.
         */

        System.out.println("Last Key : "
                + students.lastKey());

        /*
         * higherKey()
         *
         * According to comparator order.
         */

        System.out.println();

        System.out.println("Higher Key of 103 : "
                + students.higherKey(103));

        /*
         * lowerKey()
         */

        System.out.println("Lower Key of 103 : "
                + students.lowerKey(103));

        /*
         * Traversing TreeMap.
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
        students.remove(104);
        System.out.println();
        System.out.println("After Removing Key 104");
        System.out.println(students);

    }

}