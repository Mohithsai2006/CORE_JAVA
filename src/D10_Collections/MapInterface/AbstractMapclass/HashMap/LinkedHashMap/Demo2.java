package D10_Collections.MapInterface.AbstractMapclass.HashMap.LinkedHashMap;
import java.util.LinkedHashMap;
import java.util.Map;
public class Demo2 {

    public static void main(String[] args) {

        /*
         * Third parameter = true
         *
         * Maintains access order instead
         * of insertion order.
         */

        LinkedHashMap<Integer, String> map =
                new LinkedHashMap<>(16, 0.75f, true);

        map.put(101, "Java");
        map.put(102, "Python");
        map.put(103, "Spring");
        map.put(104, "React");

        System.out.println("Initial Order");
        System.out.println(map);

        /*
         * Access key 102
         */

        map.get(102);

        System.out.println();

        System.out.println("After accessing key 102");
        System.out.println(map);

        /*
         * Access key 101
         */

        map.get(101);

        System.out.println();

        System.out.println("After accessing key 101");
        System.out.println(map);
    }
}