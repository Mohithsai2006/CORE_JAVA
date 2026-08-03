package D10_Collections.SetInterface.LinkedHashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
public class Demo1 {
    public static void main(String[] args) {
        /*
         * LinkedHashSet
         *
         * -> Stores unique elements.
         * -> Maintains insertion order.
         * -> Internally uses LinkedHashMap.
         * -> Allows one null.
         * -> Not synchronized.
         */

        // ---------------------------------------------------
        // Constructors
        // ---------------------------------------------------

        LinkedHashSet<String> fruits = new LinkedHashSet<>();

        LinkedHashSet<String> fruits2 =
                new LinkedHashSet<>(20);

        LinkedHashSet<String> fruits3 =
                new LinkedHashSet<>(20,0.75f);

        System.out.println("--------------------------------");

        /*
         * add()
         *
         * Returns true if inserted.
         * Returns false if duplicate.
         */

        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");

        // duplicate

        System.out.println(fruits.add("Apple"));

        // one null allowed

        fruits.add(null);
        fruits.add(null);

        System.out.println(fruits);

        System.out.println("--------------------------------");

        /*
         * addAll()
         */

        fruits2.add("Mango");
        fruits2.add("Grapes");

        fruits.addAll(fruits2);

        System.out.println(fruits);

        System.out.println("--------------------------------");

        /*
         * contains()
         */

        System.out.println(fruits.contains("Apple"));
        System.out.println(fruits.contains("Kiwi"));

        System.out.println("--------------------------------");

        /*
         * containsAll()
         */

        System.out.println(fruits.containsAll(fruits2));

        System.out.println("--------------------------------");

        /*
         * remove()
         */

        fruits.remove("Orange");

        System.out.println(fruits);

        System.out.println("--------------------------------");

        /*
         * removeAll()
         */

        fruits.removeAll(fruits2);

        System.out.println(fruits);

        System.out.println("--------------------------------");

        /*
         * retainAll()
         */

        fruits3.add("Apple");
        fruits3.add("Watermelon");

        fruits.retainAll(fruits3);

        System.out.println(fruits);

        System.out.println("--------------------------------");

        /*
         * size()
         */

        System.out.println(fruits.size());

        /*
         * isEmpty()
         */

        System.out.println(fruits.isEmpty());

        System.out.println("--------------------------------");

        /*
         * Iterator
         *
         * Iterates in insertion order.
         */

        Iterator<String> iterator =
                fruits.iterator();

        while(iterator.hasNext())
        {
            System.out.println(iterator.next());
        }

        System.out.println("--------------------------------");

        /*
         * Enhanced for loop
         */

        for(String fruit : fruits)
        {
            System.out.println(fruit);
        }

        System.out.println("--------------------------------");

        /*
         * toArray()
         */

        Object arr[] = fruits.toArray();

        for(Object object : arr)
        {
            System.out.println(object);
        }

        System.out.println("--------------------------------");

        /*
         * clone()
         *
         * Creates shallow copy.
         */

        LinkedHashSet<String> clone =
                (LinkedHashSet<String>) fruits.clone();

        System.out.println(clone);

        System.out.println("--------------------------------");

        /*
         * equals()
         */

        System.out.println(fruits.equals(clone));

        /*
         * hashCode()
         */

        System.out.println(fruits.hashCode());

        System.out.println("--------------------------------");

        /*
         * clear()
         */

        fruits.clear();

        System.out.println(fruits);

        System.out.println(fruits.isEmpty());

    }

}
