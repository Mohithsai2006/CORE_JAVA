package D10_Collections.MapInterface.AbstractMapclass.HashMap.LinkedHashMap;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Demo1 {

    public static void main(String[] args) {

        /*
         * HashMap
         *
         * Does NOT guarantee insertion order.
         */

        Map<Integer, String> hashMap = new HashMap<>();

        hashMap.put(103, "C");
        hashMap.put(101, "A");
        hashMap.put(104, "D");
        hashMap.put(102, "B");

        System.out.println("HashMap");

        for (Map.Entry<Integer, String> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println();

        /*
         * LinkedHashMap
         *
         * Preserves insertion order.
         */

        Map<Integer, String> linkedMap = new LinkedHashMap<>();

        linkedMap.put(103, "C");
        linkedMap.put(101, "A");
        linkedMap.put(104, "D");
        linkedMap.put(102, "B");

        System.out.println("LinkedHashMap");

        for (Map.Entry<Integer, String> entry : linkedMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
