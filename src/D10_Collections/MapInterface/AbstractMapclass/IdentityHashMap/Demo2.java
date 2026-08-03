package D10_Collections.MapInterface.AbstractMapclass.IdentityHashMap;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Objects;
/*
 * ==========================================================
 * DEMO 2 : CUSTOM OBJECT AS KEY
 * ==========================================================
 *
 * Topics Covered
 * --------------
 * ✔ Custom Object
 * ✔ equals()
 * ✔ hashCode()
 * ✔ HashMap Behaviour
 * ✔ IdentityHashMap Behaviour
 *
 * Interview Point
 * ---------------
 * IdentityHashMap completely ignores
 * equals() and hashCode().
 */
class Student {
    private int id;
    private String name;
    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
    /*
     * Logical Equality.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null ||
                getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
        return id == other.id &&
                Objects.equals(name, other.name);
    }
    /*
     * Logical Hash Code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
    @Override
    public String toString() {
        return id + " - " + name;
    }
}
public class Demo2 {
    public static void main(String[] args) {
        /*
         * Two different objects.
         *
         * Same data.
         */
        Student s1 =
                new Student(101, "Mohith");
        Student s2 =
                new Student(101, "Mohith");
        /*
         * HashMap
         */
        HashMap<Student, String> hashMap =
                new HashMap<>();
        hashMap.put(s1, "Java");
        /*
         * equals() returns true.
         *
         * Existing value updated.
         */
        hashMap.put(s2, "Spring Boot");
        System.out.println("HashMap");
        System.out.println(hashMap);
        System.out.println("Size : "
                + hashMap.size());
        System.out.println();
        /*
         * IdentityHashMap
         */
        IdentityHashMap<Student, String> identityMap =
                new IdentityHashMap<>();
        identityMap.put(s1, "Java");
        /*
         * s1 != s2
         *
         * Therefore,
         * another entry is created.
         */
        identityMap.put(s2, "Spring Boot");
        System.out.println("IdentityHashMap");
        System.out.println(identityMap);
        System.out.println("Size : "
                + identityMap.size());
    }

}