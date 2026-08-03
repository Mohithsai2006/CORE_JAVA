package D10_Collections.SetInterface.CopyonwriteSet;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
public class Demo1 {
    public static void main(String[] args) {
        /*
         * CopyOnWriteArraySet
         *
         * -> Thread-safe Set implementation.
         * -> Internally uses CopyOnWriteArrayList.
         * -> Backed by Object[].
         * -> Allows only unique elements.
         * -> Allows one null.
         * -> Maintains insertion order.
         * -> Every modification creates a NEW array.
         *
         * Best suited for:
         * ---------------
         * Many reads
         * Few writes
         */
        //----------------------------------------------------
        // Constructors
        //----------------------------------------------------
        CopyOnWriteArraySet<String> fruits =
                new CopyOnWriteArraySet<>();
        /*
         * Creates an empty Set.
         */
        CopyOnWriteArraySet<String> fruits2 =
                new CopyOnWriteArraySet<>(
                        Arrays.asList(
                                "Mango",
                                "Grapes",
                                "Apple"
                        )
                );
        System.out.println("--------------------------------");
        //----------------------------------------------------
        // add()
        //----------------------------------------------------

        /*
         * Internally
         *
         * Lock
         * ↓
         * Duplicate check
         * ↓
         * Copy existing array
         * ↓
         * Add element
         * ↓
         * Replace reference
         */
        fruits.add("Apple");
        fruits.add("Banana");

        fruits.add("Orange");

        /*
         * Duplicate
         *
         * equals() finds duplicate.
         *
         * No insertion.
         */

        System.out.println(
                fruits.add("Apple")
        );

        /*
         * One null allowed.
         */

        fruits.add(null);

        fruits.add(null);

        System.out.println(fruits);

        System.out.println("--------------------------------");

        //----------------------------------------------------
        // addAll()
        //----------------------------------------------------

        fruits.addAll(fruits2);

        System.out.println(fruits);

        System.out.println("--------------------------------");

        //----------------------------------------------------
        // contains()
        //----------------------------------------------------

        /*
         * Linear search.
         */

        System.out.println(
                fruits.contains("Banana")
        );

        System.out.println(
                fruits.contains("Kiwi")
        );

        System.out.println("--------------------------------");

        //----------------------------------------------------
        // containsAll()
        //----------------------------------------------------

        System.out.println(
                fruits.containsAll(fruits2)
        );

        System.out.println("--------------------------------");

        //----------------------------------------------------
        // remove()
        //----------------------------------------------------

        /*
         * Creates NEW array
         * without removed element.
         */

        fruits.remove("Orange");

        System.out.println(fruits);

        System.out.println("--------------------------------");

        //----------------------------------------------------
        // removeAll()
        //----------------------------------------------------

        fruits.removeAll(fruits2);

        System.out.println(fruits);

        System.out.println("--------------------------------");

        //----------------------------------------------------
        // retainAll()
        //----------------------------------------------------

        CopyOnWriteArraySet<String> retain =
                new CopyOnWriteArraySet<>();

        retain.add("Apple");

        retain.add("Banana");

        fruits.retainAll(retain);

        System.out.println(fruits);

        System.out.println("--------------------------------");

        //----------------------------------------------------
        // size()
        //----------------------------------------------------

        System.out.println(
                "Size : " + fruits.size()
        );

        //----------------------------------------------------
        // isEmpty()
        //----------------------------------------------------

        System.out.println(
                fruits.isEmpty()
        );

        System.out.println("--------------------------------");

        //----------------------------------------------------
        // Iterator
        //----------------------------------------------------

        /*
         * Snapshot Iterator.
         *
         * Safe during concurrent modification.
         */

        Iterator<String> iterator =
                fruits.iterator();

        while(iterator.hasNext())
        {
            System.out.println(
                    iterator.next()
            );
        }

        System.out.println("--------------------------------");

        //----------------------------------------------------
        // Enhanced for-loop
        //----------------------------------------------------

        for(String fruit : fruits)
        {
            System.out.println(fruit);
        }

        System.out.println("--------------------------------");

        //----------------------------------------------------
        // forEach()
        //----------------------------------------------------

        fruits.forEach(System.out::println);

        System.out.println("--------------------------------");

        //----------------------------------------------------
        // toArray()
        //----------------------------------------------------

        Object[] array =
                fruits.toArray();

        for(Object object : array)
        {
            System.out.println(object);
        }

        System.out.println("--------------------------------");

        //----------------------------------------------------
        // equals()
        //----------------------------------------------------

        System.out.println(
                fruits.equals(retain)
        );

        //----------------------------------------------------
        // hashCode()
        //----------------------------------------------------

        System.out.println(
                fruits.hashCode()
        );

        System.out.println("--------------------------------");

        //----------------------------------------------------
        // clear()
        //----------------------------------------------------
        fruits.clear();
        System.out.println(fruits);
        System.out.println(
                fruits.isEmpty()
        );
    }

}
