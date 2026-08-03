package D10_Collections.SetInterface.CopyonwriteSet;
import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;
public class Demo2 {
    public static void main(String[] args) {
        CopyOnWriteArraySet<String> set =
                new CopyOnWriteArraySet<>();
        set.add("Apple");
        set.add("Banana");
        set.add("Orange");
        /*
         * Internal Array
         *
         * Index
         *
         * 0 -> Apple
         * 1 -> Banana
         * 2 -> Orange
         */

        System.out.println(set);

        System.out.println();

        /*
         * Snapshot Iterator
         *
         * Iterator captures the
         * CURRENT array.
         */

        Iterator<String> iterator =
                set.iterator();

        /*
         * Another thread (simulated here)
         * modifies the Set.
         *
         * Java DOES NOT modify
         * the existing array.
         *
         * Instead
         *
         * Old Array
         *
         * Apple
         * Banana
         * Orange
         *
         * ↓ Copy
         *
         * New Array
         *
         * Apple
         * Banana
         * Orange
         * Mango
         */

        set.add("Mango");

        System.out.println(
                "Current Set : " + set
        );

        System.out.println();

        /*
         * Iterator still points
         * to OLD array.
         *
         * Mango will NOT appear.
         */

        System.out.println(
                "Snapshot Iterator"
        );

        while(iterator.hasNext())
        {
            System.out.println(
                    iterator.next()
            );
        }

        System.out.println();

        /*
         * New Iterator
         *
         * Captures latest array.
         */
        System.out.println(
                "New Iterator"
        );
        Iterator<String> latest =
                set.iterator();
        while(latest.hasNext())
        {
            System.out.println(
                    latest.next()
            );
        }
        System.out.println();
        /*
         * Duplicate detection.
         *
         * Uses equals().
         *
         * No hash buckets.
         */
        System.out.println(
                set.add("Apple")
        );
        System.out.println();
        /*
         * Remove
         *
         * Creates another array.
         */
        set.remove("Banana");
        System.out.println(set);
        /*
         * Key Interview Point
         *
         * CopyOnWriteArraySet
         * never throws
         * ConcurrentModificationException
         * while iterating.
         */
    }
}