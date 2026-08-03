package D10_Collections.MapInterface.AbstractMapclass.IdentityHashMap;
import java.util.HashMap;
import java.util.IdentityHashMap;

/*
 * ==========================================================
 * DEMO 1 : HASHMAP vs IDENTITYHASHMAP
 * ==========================================================
 *
 * Topics Covered
 * --------------
 * ✔ HashMap uses equals()
 * ✔ IdentityHashMap uses ==
 * ✔ Two different String objects
 * ✔ Same content but different references
 * ✔ Why HashMap stores one entry
 * ✔ Why IdentityHashMap stores two entries
 *
 * Interview Question
 * ------------------
 * What is the main difference between
 * HashMap and IdentityHashMap?
 */

public class Demo1{

    public static void main(String[] args) {

        /*
         * Two different String objects.
         *
         * Same content.
         * Different memory locations.
         */

        String s1 = new String("Java");

        String s2 = new String("Java");

        /*
         * Verify references.
         */

        System.out.println("s1 == s2 : "
                + (s1 == s2));

        /*
         * Verify logical equality.
         */

        System.out.println("s1.equals(s2) : "
                + s1.equals(s2));

        System.out.println();

        /*
         * HashMap
         *
         * Uses equals() for comparison.
         */

        HashMap<String, Integer> hashMap =
                new HashMap<>();

        hashMap.put(s1, 100);

        /*
         * Since equals() returns true,
         * value gets updated.
         */

        hashMap.put(s2, 200);

        System.out.println("HashMap");

        System.out.println(hashMap);

        System.out.println("Size : "
                + hashMap.size());

        System.out.println();

        /*
         * IdentityHashMap
         *
         * Uses == for comparison.
         */

        IdentityHashMap<String, Integer> identityMap =
                new IdentityHashMap<>();

        identityMap.put(s1, 100);

        /*
         * s1 != s2
         *
         * Therefore,
         * new entry is created.
         */

        identityMap.put(s2, 200);

        System.out.println("IdentityHashMap");

        System.out.println(identityMap);

        System.out.println("Size : "
                + identityMap.size());

    }

}