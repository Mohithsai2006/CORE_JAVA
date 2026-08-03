package D10_Collections.MapInterface.AbstractMapclass.HashMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
/*
 * ==========================================================
 * DEMO 2 : CUSTOM OBJECT AS HASHMAP KEY
 * ==========================================================
 *
 * Topics Covered
 * --------------
 * ✔ Using custom objects as keys
 * ✔ Why hashCode() is important
 * ✔ Why equals() is important
 * ✔ Duplicate keys based on object equality
 * ✔ HashMap uses hashCode() first
 * ✔ HashMap uses equals() to verify keys
 *
 * Interview Point
 * ---------------
 * If a custom class is used as a HashMap key,
 * always override both hashCode() and equals().
 */

class Student {

    private int id;
    private String name;

    Student(int id, String name) {

        this.id = id;
        this.name = name;
    }

    /*
     * hashCode()
     *
     * Generates hash based on object data.
     */

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }

    /*
     * equals()
     *
     * Determines whether two Student
     * objects are logically equal.
     */

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Student other = (Student) obj;

        return id == other.id &&
                Objects.equals(name, other.name);
    }

    @Override
    public String toString() {

        return "Student{id=" + id +
                ", name='" + name + "'}";
    }
}

public class Demo2 {

    public static void main(String[] args) {

        HashMap<Student, String> map = new HashMap<>();

        /*
         * Two different objects
         * containing the same data.
         */

        Student s1 = new Student(101, "Mohith");

        Student s2 = new Student(101, "Mohith");

        /*
         * Insert first object.
         */

        map.put(s1, "Java");

        /*
         * Insert second object.
         *
         * Since hashCode() and equals()
         * consider both objects equal,
         * the existing value is updated.
         */

        map.put(s2, "Spring Boot");

        System.out.println("Map");

        System.out.println(map);

        System.out.println();

        System.out.println("Size : "
                + map.size());

        System.out.println();

        /*
         * Retrieve value using another
         * logically equal object.
         */

        Student searchKey =
                new Student(101, "Mohith");

        System.out.println("Search Result : "
                + map.get(searchKey));

        System.out.println();

        /*
         * Traversing HashMap
         */

        for (Map.Entry<Student, String> entry
                : map.entrySet()) {

            System.out.println(

                    entry.getKey()

                            + " -> "

                            + entry.getValue());
        }

    }

}