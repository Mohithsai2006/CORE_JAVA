package D10_Collections.SetInterface.ConcurrentSkipListSet;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.concurrent.ConcurrentSkipListSet;
public class Demo1 {
    public static void main(String[] args) {
        /*
         * ConcurrentSkipListSet
         *
         * ----------------------------
         * Features
         * ----------------------------
         *
         * 1) Thread Safe
         * 2) Sorted Collection
         * 3) No Duplicate Elements
         * 4) Null NOT Allowed
         * 5) Uses ConcurrentSkipListMap internally
         * 6) ConcurrentSkipListMap uses Skip List
         * 7) Search, Insert, Delete -> O(log n)
         * 8) Iterator is Weakly Consistent
         * 9) No Initial Capacity
         * 10) No Load Factor
         * 11) No Resize
         * 12) No Rehashing
         * 13) No Treeification
         *
         */

        //----------------------------------------------------------
        // Constructors
        //----------------------------------------------------------

        /*
         * Creates an empty ConcurrentSkipListSet.
         *
         * Internally
         *
         * ConcurrentSkipListMap
         *          ↓
         *     Sentinel Head Node
         */

        ConcurrentSkipListSet<Integer> set =
                new ConcurrentSkipListSet<>();


        /*
         * Creates from another collection.
         *
         * Elements are inserted one by one.
         *
         * Duplicate elements are ignored.
         */

        ConcurrentSkipListSet<Integer> set2 =
                new ConcurrentSkipListSet<>(
                        Arrays.asList(
                                50,
                                10,
                                40,
                                20,
                                10,
                                30
                        )
                );

        System.out.println(set2);

        System.out.println("--------------------------------");

        //----------------------------------------------------------
        // add()
        //----------------------------------------------------------

        /*
         * Internally
         *
         * Search appropriate location.
         *
         * ↓
         *
         * Create Level-0 Node.
         *
         * ↓
         *
         * Random Promotion.
         *
         * ↓
         *
         * Link node in higher levels.
         */

        set.add(50);
        set.add(20);
        set.add(90);
        set.add(40);
        set.add(10);

        /*
         * Duplicate.
         *
         * compareTo()==0
         *
         * Not inserted.
         */

        System.out.println(
                set.add(20)
        );

        System.out.println(set);

        System.out.println("--------------------------------");

        //----------------------------------------------------------
        // contains()
        //----------------------------------------------------------

        /*
         * Search starts
         * from top-most level.
         *
         * Average
         * O(log n)
         */

        System.out.println(
                set.contains(40)
        );

        System.out.println(
                set.contains(100)
        );

        System.out.println("--------------------------------");

        //----------------------------------------------------------
        // remove()
        //----------------------------------------------------------

        /*
         * Removes node
         * from ALL levels.
         */

        set.remove(40);

        System.out.println(set);

        System.out.println("--------------------------------");

        //----------------------------------------------------------
        // first()
        //----------------------------------------------------------

        /*
         * Smallest element.
         */

        System.out.println(
                set.first()
        );

        //----------------------------------------------------------
        // last()
        //----------------------------------------------------------

        /*
         * Largest element.
         */

        System.out.println(
                set.last()
        );

        System.out.println("--------------------------------");

        //----------------------------------------------------------
        // higher()
        //----------------------------------------------------------

        /*
         * Strictly greater element.
         */

        System.out.println(
                set.higher(20)
        );

        //----------------------------------------------------------
        // lower()
        //----------------------------------------------------------

        /*
         * Strictly smaller element.
         */

        System.out.println(
                set.lower(50)
        );

        //----------------------------------------------------------
        // ceiling()
        //----------------------------------------------------------

        /*
         * Greater OR Equal.
         */

        System.out.println(
                set.ceiling(21)
        );

        //----------------------------------------------------------
        // floor()
        //----------------------------------------------------------

        /*
         * Smaller OR Equal.
         */

        System.out.println(
                set.floor(21)
        );

        System.out.println("--------------------------------");

        //----------------------------------------------------------
        // pollFirst()
        //----------------------------------------------------------

        /*
         * Removes
         * smallest element.
         */

        System.out.println(
                set.pollFirst()
        );

        System.out.println(set);

        //----------------------------------------------------------
        // pollLast()
        //----------------------------------------------------------

        /*
         * Removes
         * largest element.
         */

        System.out.println(
                set.pollLast()
        );

        System.out.println(set);

        System.out.println("--------------------------------");

        //----------------------------------------------------------
        // addAll()
        //----------------------------------------------------------

        set.addAll(set2);

        System.out.println(set);

        System.out.println("--------------------------------");

        //----------------------------------------------------------
        // containsAll()
        //----------------------------------------------------------

        System.out.println(
                set.containsAll(set2)
        );

        System.out.println("--------------------------------");

        //----------------------------------------------------------
        // headSet()
        //----------------------------------------------------------

        /*
         * Elements
         * less than 40.
         */

        NavigableSet<Integer> head =
                set.headSet(
                        40,
                        false
                );

        System.out.println(head);

        //----------------------------------------------------------
        // tailSet()
        //----------------------------------------------------------

        /*
         * Elements
         * >=30
         */

        NavigableSet<Integer> tail =
                set.tailSet(
                        30,
                        true
                );

        System.out.println(tail);

        //----------------------------------------------------------
        // subSet()
        //----------------------------------------------------------

        /*
         * Between
         * 20 and 50.
         */

        NavigableSet<Integer> sub =
                set.subSet(
                        20,
                        true,
                        50,
                        true
                );

        System.out.println(sub);

        System.out.println("--------------------------------");

        //----------------------------------------------------------
        // Iterator
        //----------------------------------------------------------

        /*
         * Weakly Consistent Iterator.
         *
         * Never throws
         * ConcurrentModificationException.
         */

        Iterator<Integer> iterator =
                set.iterator();

        while(iterator.hasNext())
        {
            System.out.println(
                    iterator.next()
            );
        }

        System.out.println("--------------------------------");

        //----------------------------------------------------------
        // Descending Iterator
        //----------------------------------------------------------

        Iterator<Integer> descending =
                set.descendingIterator();

        while(descending.hasNext())
        {
            System.out.println(
                    descending.next()
            );
        }

        System.out.println("--------------------------------");

        //----------------------------------------------------------
        // Enhanced For Loop
        //----------------------------------------------------------

        for(Integer number : set)
        {
            System.out.println(number);
        }

        System.out.println("--------------------------------");

        //----------------------------------------------------------
        // forEach()
        //----------------------------------------------------------

        set.forEach(System.out::println);

        System.out.println("--------------------------------");

        //----------------------------------------------------------
        // toArray()
        //----------------------------------------------------------

        Object[] objects =
                set.toArray();

        for(Object object : objects)
        {
            System.out.println(object);
        }

        System.out.println("--------------------------------");

        //----------------------------------------------------------
        // comparator()
        //----------------------------------------------------------

        /*
         * Returns comparator.
         *
         * Natural ordering
         * returns null.
         */

        System.out.println(
                set.comparator()
        );

        //----------------------------------------------------------
        // size()
        //----------------------------------------------------------

        System.out.println(
                set.size()
        );

        //----------------------------------------------------------
        // isEmpty()
        //----------------------------------------------------------

        System.out.println(
                set.isEmpty()
        );

        System.out.println("--------------------------------");

        //----------------------------------------------------------
        // equals()
        //----------------------------------------------------------

        System.out.println(
                set.equals(set2)
        );

        //----------------------------------------------------------
        // hashCode()
        //----------------------------------------------------------

        System.out.println(
                set.hashCode()
        );

        System.out.println("--------------------------------");

        //----------------------------------------------------------
        // clear()
        //----------------------------------------------------------

        set.clear();

        System.out.println(set);

        System.out.println(
                set.isEmpty()
        );

        System.out.println("--------------------------------");

        //----------------------------------------------------------
        // Constructor with Comparator
        //----------------------------------------------------------

        /*
         * Descending order.
         */

        ConcurrentSkipListSet<Integer> reverse =
                new ConcurrentSkipListSet<>(
                        Comparator.reverseOrder()
                );

        reverse.add(10);
        reverse.add(70);
        reverse.add(30);
        reverse.add(50);

        System.out.println(reverse);

    }

}