package D10_Collections.SetInterface.TreeSet;
import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;
public class Demo1 {
    public static void main(String[] args) {
        /*
         * TreeSet
         *
         * -> Stores only unique elements.
         * -> Maintains elements in sorted order.
         * -> Internally uses TreeMap.
         * -> TreeMap internally uses Red-Black Tree.
         * -> Does NOT use hashCode() or equals().
         * -> Uses compareTo() (Natural Ordering)
         *    or Comparator (Custom Ordering).
         * -> Null is NOT allowed (Java 7+).
         * -> Average Operations:
         *      add()      -> O(log n)
         *      remove()   -> O(log n)
         *      contains() -> O(log n)
         */
        //-------------------------------------------------------
        // Constructors
        //-------------------------------------------------------
        TreeSet<Integer> numbers = new TreeSet<>();
        /*
         * Empty TreeSet created.
         *
         * Internally
         *
         * TreeSet
         *      ↓
         * TreeMap
         *      ↓
         * Red-Black Tree
         */

        TreeSet<Integer> numbers2 =
                new TreeSet<>(Arrays.asList(60,70,80));
        System.out.println("------------------------------------");
        /*
         * add()
         *
         * Elements are inserted according to sorting order.
         *
         * Every insertion performs:
         *
         * compareTo()
         *      ↓
         * Left or Right traversal
         *      ↓
         * Insert node
         *      ↓
         * Re-balance Red-Black Tree
         */

        numbers.add(50);
        numbers.add(10);
        numbers.add(40);
        numbers.add(20);
        numbers.add(30);

        /*
         * Duplicate
         *
         * compareTo() returns 0
         *
         * Not inserted.
         */

        System.out.println(numbers.add(20));

        System.out.println(numbers);

        System.out.println("------------------------------------");

        /*
         * addAll()
         *
         * Adds every element from another collection.
         *
         * Each element individually undergoes
         * Red-Black Tree insertion.
         */

        numbers.addAll(numbers2);

        System.out.println(numbers);

        System.out.println("------------------------------------");

        /*
         * contains()
         *
         * Internally:
         *
         * compareTo()
         *      ↓
         * Tree traversal
         *      ↓
         * Found?
         */

        System.out.println(numbers.contains(40));

        System.out.println(numbers.contains(100));

        System.out.println("------------------------------------");

        /*
         * containsAll()
         */

        System.out.println(
                numbers.containsAll(numbers2)
        );

        System.out.println("------------------------------------");

        /*
         * first()
         *
         * Returns smallest element.
         */

        System.out.println(
                "First : " + numbers.first()
        );

        /*
         * last()
         *
         * Returns largest element.
         */

        System.out.println(
                "Last : " + numbers.last()
        );

        System.out.println("------------------------------------");

        /*
         * higher()
         *
         * Strictly greater element.
         */

        System.out.println(
                "Higher(40) : " + numbers.higher(40)
        );

        /*
         * lower()
         *
         * Strictly smaller element.
         */

        System.out.println(
                "Lower(40) : " + numbers.lower(40)
        );

        /*
         * ceiling()
         *
         * >= given element
         */

        System.out.println(
                "Ceiling(41) : "
                        + numbers.ceiling(41)
        );

        /*
         * floor()
         *
         * <= given element
         */

        System.out.println(
                "Floor(41) : "
                        + numbers.floor(41)
        );

        System.out.println("------------------------------------");

        /*
         * headSet()
         *
         * All elements less than given value.
         */

        System.out.println(
                numbers.headSet(40)
        );

        /*
         * tailSet()
         *
         * All elements >= given value.
         */

        System.out.println(
                numbers.tailSet(40)
        );

        /*
         * subSet()
         *
         * fromInclusive
         * toExclusive
         */

        System.out.println(
                numbers.subSet(20,60)
        );

        System.out.println("------------------------------------");

        /*
         * pollFirst()
         *
         * Removes smallest element.
         */

        System.out.println(
                numbers.pollFirst()
        );

        /*
         * pollLast()
         *
         * Removes largest element.
         */

        System.out.println(
                numbers.pollLast()
        );

        System.out.println(numbers);

        System.out.println("------------------------------------");

        /*
         * remove()
         *
         * Internally:
         *
         * Search node
         *      ↓
         * Remove node
         *      ↓
         * Re-balance Red-Black Tree
         */

        numbers.remove(40);

        System.out.println(numbers);

        System.out.println("------------------------------------");

        /*
         * removeAll()
         */

        numbers.removeAll(numbers2);

        System.out.println(numbers);

        System.out.println("------------------------------------");

        /*
         * retainAll()
         *
         * Keeps only common elements.
         */

        TreeSet<Integer> retain =
                new TreeSet<>();

        retain.add(20);
        retain.add(30);

        numbers.retainAll(retain);

        System.out.println(numbers);

        System.out.println("------------------------------------");

        /*
         * size()
         */

        System.out.println(
                "Size : " + numbers.size()
        );

        /*
         * isEmpty()
         */

        System.out.println(
                numbers.isEmpty()
        );

        System.out.println("------------------------------------");

        /*
         * Iterator
         *
         * Iterates in ascending sorted order.
         */

        Iterator<Integer> iterator =
                numbers.iterator();

        while(iterator.hasNext())
        {
            System.out.println(iterator.next());
        }

        System.out.println("------------------------------------");

        /*
         * Descending Iterator
         *
         * Reverse sorted order.
         */

        Iterator<Integer> reverse =
                numbers.descendingIterator();

        while(reverse.hasNext())
        {
            System.out.println(reverse.next());
        }

        System.out.println("------------------------------------");

        /*
         * Enhanced for-loop
         */

        for(Integer number : numbers)
        {
            System.out.println(number);
        }

        System.out.println("------------------------------------");

        /*
         * forEach()
         */

        numbers.forEach(System.out::println);

        System.out.println("------------------------------------");

        /*
         * toArray()
         */

        Object[] array =
                numbers.toArray();

        for(Object object : array)
        {
            System.out.println(object);
        }

        System.out.println("------------------------------------");

        /*
         * clone()
         *
         * Creates shallow copy.
         */

        TreeSet<Integer> clone =
                (TreeSet<Integer>) numbers.clone();

        System.out.println(clone);

        System.out.println("------------------------------------");

        /*
         * equals()
         *
         * Compares contents.
         */

        System.out.println(
                numbers.equals(clone)
        );

        /*
         * hashCode()
         *
         * Returns hash code of entire Set.
         *
         * Individual elements are NOT stored
         * using hashCode().
         */

        System.out.println(
                numbers.hashCode()
        );

        System.out.println("------------------------------------");

        /*
         * clear()
         */

        numbers.clear();

        System.out.println(numbers);

        System.out.println(
                numbers.isEmpty()
        );

    }

}