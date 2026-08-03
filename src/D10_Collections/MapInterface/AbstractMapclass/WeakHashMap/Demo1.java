package D10_Collections.MapInterface.AbstractMapclass.WeakHashMap;
import java.util.WeakHashMap;
class Student {

    int id;

    Student(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student-" + id;
    }
}

public class Demo1 {

    public static void main(String[] args) throws Exception {

        WeakHashMap<Student, String> map = new WeakHashMap<>();

        Student s = new Student(101);

        map.put(s, "Java");

        System.out.println("Before GC : " + map);

        // Remove the only strong reference
        s = null;

        System.gc();

        Thread.sleep(2000);

        System.out.println("After GC : " + map);
    }
}