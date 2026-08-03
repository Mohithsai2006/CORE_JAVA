package D10_Collections.SetInterface.TreeSet;
import java.util.Comparator;
import java.util.TreeSet;
/*
 * Student class implementing Comparable.
 *
 * TreeSet uses compareTo()
 * when no Comparator is supplied.
 */
class Student implements Comparable<Student> {

    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /*
     * compareTo()
     *
     * TreeSet NEVER calls hashCode().
     * TreeSet NEVER calls equals().
     *
     * It ONLY calls compareTo()
     * to:
     *
     * 1. Find insertion position.
     * 2. Detect duplicates.
     * 3. Maintain sorting.
     */

    @Override
    public int compareTo(Student other) {

        System.out.println(
                "compareTo() : "
                        + this.name +
                        " -> " +
                        other.name
        );

        /*
         * Ascending order by id.
         */

        return Integer.compare(this.id, other.id);
    }

    /*
     * Only added for demonstration.
     *
     * TreeSet does NOT use them
     * while inserting/searching.
     */

    @Override
    public boolean equals(Object obj) {

        System.out.println("equals() called");

        Student other = (Student) obj;

        return this.id == other.id;
    }

    @Override
    public int hashCode() {

        System.out.println("hashCode() called");

        return id;
    }

    @Override
    public String toString() {

        return id + " " + name;
    }

}

public class Demo2 {

    public static void main(String[] args) {

        /*
         * ===================================================
         * Natural Ordering
         * ===================================================
         */

        TreeSet<Student> students =
                new TreeSet<>();

        Student s1 =
                new Student(105,"John");

        Student s2 =
                new Student(101,"David");

        Student s3 =
                new Student(110,"Scott");

        Student duplicate =
                new Student(101,"Duplicate");

        /*
         * First object.
         *
         * Tree empty.
         *
         * Root becomes John.
         */

        students.add(s1);

        System.out.println();

        /*
         * compareTo()
         *
         * 101 < 105
         *
         * Goes to left side.
         */

        students.add(s2);

        System.out.println();

        /*
         * compareTo()
         *
         * 110 > 105
         *
         * Goes to right side.
         */

        students.add(s3);

        System.out.println();

        /*
         * compareTo()
         *
         * Duplicate id.
         *
         * compareTo()
         * returns 0.
         *
         * TreeSet treats it as duplicate.
         *
         * equals() is NEVER called.
         */

        students.add(duplicate);

        System.out.println();

        System.out.println(
                "Natural Ordering"
        );

        System.out.println(students);

        System.out.println();

        /*
         * contains()
         *
         * Again uses compareTo().
         *
         * No hashCode().
         * No equals().
         */

        System.out.println(
                students.contains(
                        new Student(105,"XYZ")
                )
        );

        System.out.println();

        /*
         * ===================================================
         * Custom Ordering
         * ===================================================
         *
         * Descending by id.
         */

        TreeSet<Student> descending =
                new TreeSet<>(

                        Comparator.comparingInt(
                                (Student s)->s.id
                        ).reversed()

                );

        descending.add(s1);
        descending.add(s2);
        descending.add(s3);

        System.out.println(
                "Descending Order"
        );

        System.out.println(descending);

    }

}
