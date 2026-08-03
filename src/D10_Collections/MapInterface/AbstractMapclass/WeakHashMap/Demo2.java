package D10_Collections.MapInterface.AbstractMapclass.WeakHashMap;

import java.util.WeakHashMap;

public class Demo2 {

    public static void main(String[] args) throws Exception {

        WeakHashMap<Student, String> map = new WeakHashMap<>();

        Student key = new Student(1);

        map.put(key, "Java");

        System.out.println("Contains Key : " + map.containsKey(key));
        System.out.println("Value        : " + map.get(key));

        // Remove the only strong reference
        key = null;

        System.gc();

        Thread.sleep(2000);

        System.out.println("\nAfter GC");

        // Entry may already be removed automatically
        System.out.println("Map : " + map);
        System.out.println("Size: " + map.size());
    }
}
