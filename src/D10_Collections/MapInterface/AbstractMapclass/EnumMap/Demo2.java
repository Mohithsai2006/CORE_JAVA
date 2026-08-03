package D10_Collections.MapInterface.AbstractMapclass.EnumMap;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.WeakHashMap;

enum Priority {

    LOW,
    MEDIUM,
    HIGH,
    CRITICAL
}

public class Demo2 {

    public static void main(String[] args) {

        HashMap<Priority, String> hashMap =
                new HashMap<>();

        EnumMap<Priority, String> enumMap =
                new EnumMap<>(Priority.class);

        hashMap.put(Priority.CRITICAL, "P1");
        hashMap.put(Priority.LOW, "P4");
        hashMap.put(Priority.HIGH, "P2");

        enumMap.put(Priority.CRITICAL, "P1");
        enumMap.put(Priority.LOW, "P4");
        enumMap.put(Priority.HIGH, "P2");

        System.out.println("HashMap");
        System.out.println(hashMap);

        System.out.println();

        System.out.println("EnumMap");
        System.out.println(enumMap);
    }
}
//Possible Output
//HashMap
//
//{HIGH=P2, LOW=P4, CRITICAL=P1}
//
//EnumMap
//
//{LOW=P4, HIGH=P2, CRITICAL=P1}
//
//Notice that EnumMap iterates in the natural declaration order of the enum (LOW, MEDIUM, HIGH, CRITICAL),
// not in insertion order. That's an important interview point.