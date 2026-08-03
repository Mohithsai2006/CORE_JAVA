package D10_Collections.SetInterface.HashSet;
import java.util.HashSet;
class Student {
    int id;
    String name;
    Student(int id, String name)
    {
        this.id = id;
        this.name = name;
    }
    /*
     * hashCode()
     *
     * HashSet first calls hashCode()
     * to decide which bucket the object
     * should be stored in.
     */
    @Override
    public int hashCode() {
        System.out.println("hashCode() called for : " + name);
        return id;
    }
    /*
     * equals()
     *
     * If two objects land in the same bucket,
     * HashSet calls equals()
     * to check duplicate.
     */
    @Override
    public boolean equals(Object obj) {
        System.out.println("equals() called");
        Student other = (Student)obj;
        return this.id == other.id;
    }
    @Override
    public String toString() {
        return id + " " + name;
    }
}
public class Demo2 {
    public static void main(String[] args) {
        HashSet<Student> set = new HashSet<>();
        Student s1 = new Student(101,"John");
        Student s2 = new Student(102,"David");
        Student s3 = new Student(101,"John Duplicate");
        /*
         * s1
         *
         * hashCode()
         * ↓
         * Bucket calculated
         * ↓
         * Bucket empty
         * ↓
         * Inserted
         */
        set.add(s1);
        System.out.println();
        /*
         * Different hashCode()
         *
         * Different bucket.
         */

        set.add(s2);

        System.out.println();

        /*
         * Same hashCode()
         *
         * Goes to same bucket.
         *
         * equals() is called.
         *
         * Since ids are same,
         * duplicate is detected.
         *
         * Object is NOT inserted.
         */

        set.add(s3);

        System.out.println();

        /*
         * Final HashSet
         */

        System.out.println(set);

        System.out.println();

        /*
         * contains()
         *
         * Again hashCode()
         * ↓
         * Bucket
         * ↓
         * equals()
         */

        System.out.println(
                set.contains(new Student(101,"XYZ"))
        );

    }

}