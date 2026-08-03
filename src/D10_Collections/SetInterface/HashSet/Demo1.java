package D10_Collections.SetInterface.HashSet;

import java.util.HashSet;

public class Demo1 {

    public static void main(String[] args) {

        /*
         * HashSet
         *
         * -> Stores only unique elements.
         * -> Internally uses HashMap.
         * -> Elements are stored as HashMap keys.
         * -> Dummy PRESENT object is stored as value.
         * -> Order is NOT guaranteed.
         * -> Allows only one null.
         */

        HashSet<String> fruits = new HashSet<>();

        /*
         * add()
         *
         * Returns true if element is inserted.
         * Returns false if duplicate.
         */

        System.out.println(fruits.add("Apple"));     // true
        System.out.println(fruits.add("Banana"));    // true
        System.out.println(fruits.add("Orange"));    // true

        /*
         * Duplicate element.
         *
         * HashSet internally calls
         *
         * HashMap.put(key, PRESENT)
         *
         * Since key already exists,
         * insertion fails.
         */

        System.out.println(fruits.add("Apple"));     // false

        System.out.println();

        /*
         * HashSet does NOT maintain insertion order.
         * Output order may differ.
         */

        System.out.println(fruits);

        System.out.println();

        /*
         * contains()
         *
         * Internally:
         *
         * hashCode()
         * ↓
         * Bucket
         * ↓
         * equals()
         *
         * Average Complexity : O(1)
         */

        System.out.println(fruits.contains("Banana"));
        System.out.println(fruits.contains("Mango"));

        System.out.println();

        /*
         * remove()
         *
         * Removes element if present.
         */

        System.out.println(fruits.remove("Orange"));

        System.out.println(fruits);

        System.out.println();

        /*
         * size()
         */

        System.out.println("Size : " + fruits.size());

        /*
         * isEmpty()
         */

        System.out.println(fruits.isEmpty());

        System.out.println();

        /*
         * One null is allowed.
         */

        fruits.add(null);
        fruits.add(null);
        fruits.add(null);

        System.out.println(fruits);

        System.out.println();

        /*
         * Iteration
         */

        for(String fruit : fruits)
        {
            System.out.println(fruit);
        }

        System.out.println();

        /*
         * clear()
         */

        fruits.clear();

        System.out.println(fruits);

        System.out.println("Empty : " + fruits.isEmpty());
    }
}