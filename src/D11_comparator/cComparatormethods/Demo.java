package D11_comparator.cComparatormethods;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Student {

    int id;
    String name;
    int marks;
    int age;

    Student(int id, String name, int marks, int age) {
        this.id = id;
        this.name = name;
        this.marks = marks;
        this.age = age;
    }

    // Getter methods are required because Comparator.comparing()
    // accepts a Function (method reference or lambda) that extracts
    // the value to be compared.

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return id + "  " + name + "  " + marks + "  " + age;
    }
}

public class Demo {

    public static void main(String[] args) {

        List<Student> list = new ArrayList<>();

        list.add(new Student(103,"Krishna",85,22));
        list.add(new Student(101,"Anil",95,20));
        list.add(new Student(104,null,75,19));
        list.add(new Student(102,"Ravi",95,21));
        list.add(new Student(105,null,90,18));

        //---------------------------------------------------------
        // 1. Comparator.comparing()
        //---------------------------------------------------------

        // Creates a Comparator object.
        //
        // Student::getId is a Method Reference.
        // For every comparison Java internally executes:
        //
        //      s1.getId()
        //      s2.getId()
        //
        // Then compares both ids.
        //
        // Internally similar to:
        //
        // (s1,s2) -> Integer.compare(s1.getId(), s2.getId())
        //
        Comparator<Student> idComparator =
                Comparator.comparing(Student::getId);

        // Pass Comparator object to sort().
        // TimSort repeatedly calls
        //
        // idComparator.compare(student1,student2)
        //
        // until the list becomes sorted.
        list.sort(idComparator);

        System.out.println("Sort By ID");
        System.out.println(list);



        //---------------------------------------------------------
        // 2. reversed()
        //---------------------------------------------------------

        // Comparator.comparing() creates
        //
        // Ascending Comparator
        //
        // 70
        // 80
        // 90
        //
        Comparator<Student> marksComparator =
                Comparator.comparing(Student::getMarks);

        // reversed() DOES NOT modify marksComparator.
        //
        // It creates another Comparator object
        // whose compare() result is exactly opposite.
        //
        // Ascending
        //
        // compare(a,b)
        //
        // becomes
        //
        // compare(b,a)
        //
        // New order
        //
        // 90
        // 80
        // 70
        Comparator<Student> descendingComparator =
                marksComparator.reversed();

        list.sort(descendingComparator);

        System.out.println("\nMarks Descending");
        System.out.println(list);



        //---------------------------------------------------------
        // 3. thenComparing()
        //---------------------------------------------------------

        // Primary Comparator
        //
        // Compare students by Marks.
        Comparator<Student> multiComparator =

                Comparator.comparing(Student::getMarks)

                        // Java comes here ONLY IF
                        //
                        // compare(Marks)
                        //
                        // returns 0
                        //
                        // meaning Marks are equal.
                        //
                        // Then Age becomes second key.
                        .thenComparing(Student::getAge)

                        // Again,
                        //
                        // Java reaches here ONLY IF
                        //
                        // Marks == Same
                        // AND
                        // Age == Same
                        //
                        // Finally compare Names.
                        .thenComparing(Student::getName,
                                Comparator.nullsLast(String::compareTo));

        list.sort(multiComparator);

        System.out.println("\nMarks -> Age -> Name");
        System.out.println(list);



        //---------------------------------------------------------
        // 4. nullsFirst()
        //---------------------------------------------------------

        // Suppose Name is null.
        //
        // Java CANNOT execute
        //
        // null.compareTo("Anil")
        //
        // because null has no methods.
        //
        // That causes
        //
        // NullPointerException
        //
        // nullsFirst() tells Java:
        //
        // Before calling compareTo(),
        // first check whether any value is null.
        //
        // If null exists,
        // place it BEFORE all non-null values.
        //
        Comparator<Student> nullFirstComparator =

                Comparator.comparing(

                        Student::getName,

                        Comparator.nullsFirst(String::compareTo)

                );

        list.sort(nullFirstComparator);

        System.out.println("\nnullsFirst()");
        System.out.println(list);



        //---------------------------------------------------------
        // 5. nullsLast()
        //---------------------------------------------------------

        // Works exactly opposite.
        //
        // If Name is null,
        // move it to END of list.
        //
        Comparator<Student> nullLastComparator =

                Comparator.comparing(

                        Student::getName,

                        Comparator.nullsLast(String::compareTo)

                );

        list.sort(nullLastComparator);

        System.out.println("\nnullsLast()");
        System.out.println(list);



        //---------------------------------------------------------
        // 6. Chaining Everything
        //---------------------------------------------------------

        // Comparator chaining means
        // Java compares objects step by step.
        //
        // Step 1
        // Compare Marks.
        //
        // If different,
        // sorting decision completed.
        //
        // Otherwise
        // ↓
        //
        // Step 2
        // Compare Age.
        //
        // If different,
        // sorting decision completed.
        //
        // Otherwise
        // ↓
        //
        // Step 3
        // Compare Name.
        //
        // Finally reverse COMPLETE result.
        //
        Comparator<Student> finalComparator =

                Comparator.comparing(Student::getMarks)

                        .thenComparing(Student::getAge)

                        .thenComparing(

                                Student::getName,

                                Comparator.nullsLast(String::compareTo)

                        )

                        // Reverse final ordering.
                        //
                        // Highest Marks first.
                        // Highest Age first.
                        // Reverse Name order.
                        //
                        .reversed();

        list.sort(finalComparator);

        System.out.println("\nFinal Comparator");
        System.out.println(list);

    }
}