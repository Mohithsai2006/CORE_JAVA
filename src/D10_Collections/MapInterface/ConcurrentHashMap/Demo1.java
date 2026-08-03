package D10_Collections.MapInterface.ConcurrentHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/*
 * ==========================================================
 * DEMO 1 : CONCURRENTHASHMAP BASICS
 * ==========================================================
 *
 * Topics Covered
 * --------------
 * ✔ ConcurrentHashMap stores data as Key-Value pairs
 * ✔ Thread-safe implementation
 * ✔ No null key
 * ✔ No null value
 * ✔ Keys are unique
 * ✔ Values can be duplicated
 * ✔ put()
 * ✔ get()
 * ✔ remove()
 * ✔ containsKey()
 * ✔ containsValue()
 * ✔ putIfAbsent()
 * ✔ replace()
 * ✔ computeIfAbsent()
 * ✔ computeIfPresent()
 * ✔ compute()
 * ✔ merge()
 * ✔ Traversing using entrySet()
 *
 * Internal Working
 * ----------------
 * ✔ Uses Bucket Array
 * ✔ Uses CAS (Compare And Swap)
 * ✔ Uses Fine-Grained Locking
 * ✔ Uses Red-Black Tree when collisions increase
 *
 * Time Complexity (Average)
 * -------------------------
 * put()          -> O(1)
 * get()          -> O(1)
 * remove()       -> O(1)
 */

public class Demo1 {

    public static void main(String[] args) {

        /*
         * Default Constructor
         *
         * Creates an empty
         * ConcurrentHashMap.
         */

        ConcurrentHashMap<Integer, String> students =
                new ConcurrentHashMap<>();

        /*
         * put()
         *
         * Inserts Key-Value pairs.
         */

        students.put(101, "Java");
        students.put(102, "Spring");
        students.put(103, "Hibernate");
        students.put(104, "React");

        System.out.println("Initial Map");

        System.out.println(students);

        /*
         * Duplicate Key
         *
         * Existing value gets updated.
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

        students.put(105, "Java");

        System.out.println();

        System.out.println("After Duplicate Value");

        System.out.println(students);

        /*
         * get()
         */

        System.out.println();

        System.out.println("Key 102 : "
                + students.get(102));

        /*
         * containsKey()
         */

        System.out.println();

        System.out.println("Contains Key 101 : "
                + students.containsKey(101));

        /*
         * containsValue()
         */

        System.out.println("Contains Value React : "
                + students.containsValue("React"));

        /*
         * putIfAbsent()
         *
         * Inserts only if key
         * is not already present.
         */

        students.putIfAbsent(102, "Python");

        students.putIfAbsent(106, "Python");

        System.out.println();

        System.out.println("After putIfAbsent()");

        System.out.println(students);

        /*
         * replace()
         *
         * Replaces value of
         * existing key.
         */

        students.replace(101, "Advanced Java");

        System.out.println();

        System.out.println("After replace()");

        System.out.println(students);

        /*
         * computeIfAbsent()
         *
         * Executes lambda only if
         * key is absent.
         */

        students.computeIfAbsent(107,
                key -> "Microservices");

        /*
         * Key already exists.
         *
         * Lambda will NOT execute.
         */

        students.computeIfAbsent(102,
                key -> "NodeJS");

        System.out.println();

        System.out.println("After computeIfAbsent()");

        System.out.println(students);

        /*
         * computeIfPresent()
         *
         * Executes lambda only if
         * key already exists.
         */

        students.computeIfPresent(103,

                (key, value) -> value + " Framework");

        /*
         * Key not present.
         *
         * Nothing happens.
         */

        students.computeIfPresent(200,

                (key, value) -> "Nothing");

        System.out.println();

        System.out.println("After computeIfPresent()");

        System.out.println(students);

        /*
         * compute()
         *
         * Always executes.
         *
         * If key exists,
         * update value.
         *
         * If key absent,
         * create new entry.
         */

        students.compute(108,

                (key, value) -> "Docker");

        students.compute(101,

                (key, value) -> value + " Programming");

        System.out.println();

        System.out.println("After compute()");

        System.out.println(students);

        /*
         * merge()
         *
         * If key absent,
         * inserts new value.
         *
         * If key present,
         * combines old and new values.
         */

        students.merge(

                103,

                " + Security",

                (oldValue, newValue)

                        -> oldValue + newValue);

        students.merge(

                109,

                "Kubernetes",

                (oldValue, newValue)

                        -> oldValue + newValue);

        System.out.println();

        System.out.println("After merge()");

        System.out.println(students);

        /*
         * remove()
         */

        students.remove(104);

        System.out.println();

        System.out.println("After remove()");

        System.out.println(students);

        /*
         * Traversing
         */

        System.out.println();

        System.out.println("Traversing Map");

        for (Map.Entry<Integer, String> entry
                : students.entrySet()) {

            System.out.println(

                    entry.getKey()

                            + " -> "

                            + entry.getValue());
        }

        /*
         * Null Key
         *
         * Uncommenting below line
         * throws NullPointerException.
         */

        // students.put(null,"Java");

        /*
         * Null Value
         *
         * Uncommenting below line
         * throws NullPointerException.
         */

        // students.put(110,null);

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