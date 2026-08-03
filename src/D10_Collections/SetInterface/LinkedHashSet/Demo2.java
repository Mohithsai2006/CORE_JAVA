package D10_Collections.SetInterface.LinkedHashSet;
import java.util.HashSet;
import java.util.LinkedHashSet;

class Student {

    int id;
    String name;

    Student(int id,String name)
    {
        this.id=id;
        this.name=name;
    }

    /*
     * Bucket selection.
     */

    @Override
    public int hashCode() {

        System.out.println("hashCode() : "+name);

        return id;
    }

    /*
     * Duplicate detection.
     */

    @Override
    public boolean equals(Object obj) {

        System.out.println("equals() called");

        Student other=(Student)obj;

        return this.id==other.id;
    }

    @Override
    public String toString() {

        return id+" "+name;
    }

}

public class Demo2 {

    public static void main(String[] args) {

        HashSet<Student> hashSet =
                new HashSet<>();

        LinkedHashSet<Student> linkedHashSet =
                new LinkedHashSet<>();

        Student s1 =
                new Student(101,"John");

        Student s2 =
                new Student(102,"David");

        Student s3 =
                new Student(103,"Scott");

        Student duplicate =
                new Student(101,"Duplicate");

        /*
         * -----------------------------
         * HashSet
         * -----------------------------
         */

        hashSet.add(s2);

        hashSet.add(s1);

        hashSet.add(s3);

        hashSet.add(duplicate);

        System.out.println();

        System.out.println("HashSet");

        /*
         * Order depends upon hashing.
         */

        System.out.println(hashSet);

        System.out.println();

        /*
         * -----------------------------
         * LinkedHashSet
         * -----------------------------
         */

        linkedHashSet.add(s2);

        linkedHashSet.add(s1);

        linkedHashSet.add(s3);

        linkedHashSet.add(duplicate);

        System.out.println();

        System.out.println("LinkedHashSet");

        /*
         * Maintains insertion order.
         *
         * Internally LinkedHashMap
         * keeps a doubly linked list
         * using before & after pointers.
         */

        System.out.println(linkedHashSet);

        System.out.println();

        /*
         * contains()
         *
         * hashCode()
         * ↓
         * Bucket
         * ↓
         * equals()
         */

        System.out.println(
                linkedHashSet.contains(
                        new Student(102,"XYZ")
                )
        );

        System.out.println();

        /*
         * Remove
         *
         * Removed from:
         *
         * 1.Hash Table
         * 2.Doubly Linked List
         */

        linkedHashSet.remove(s2);

        System.out.println(linkedHashSet);

    }

}
