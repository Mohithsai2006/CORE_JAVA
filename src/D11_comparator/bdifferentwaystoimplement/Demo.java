package D11_comparator.bdifferentwaystoimplement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student {

    int id;
    String name;
    int marks;

    Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    // Getter used by Method Reference
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return id + "  " + name + "  " + marks;
    }
}

//------------------------------------------------------
// Way 1 : Separate Comparator Classes
//------------------------------------------------------

class IdComparator implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        return Integer.compare(s1.id, s2.id);
    }
}

class NameComparator implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        return s1.name.compareTo(s2.name);
    }
}

class MarksComparator implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        return Integer.compare(s1.marks, s2.marks);
    }
}

public class Demo {

    public static void main(String[] args) {

        List<Student> list = new ArrayList<>();

        list.add(new Student(103, "Krishna", 82));
        list.add(new Student(101, "Anil", 95));
        list.add(new Student(102, "Ravi", 76));

        //--------------------------------------------------
        // Way 1 : Separate Comparator Class
        //--------------------------------------------------

        Collections.sort(list, new IdComparator());
        System.out.println("Sort by ID");
        System.out.println(list);

        Collections.sort(list, new NameComparator());
        System.out.println("\nSort by Name");
        System.out.println(list);

        Collections.sort(list, new MarksComparator());
        System.out.println("\nSort by Marks");
        System.out.println(list);

        //--------------------------------------------------
        // Way 2 : Anonymous Inner Class
        //--------------------------------------------------

        Collections.sort(list, new Comparator<Student>() {

            @Override
            public int compare(Student s1, Student s2) {

                // Sort by Marks (Descending)
                return Integer.compare(s2.marks, s1.marks);
            }

        });

        System.out.println("\nAnonymous Inner Class");
        System.out.println(list);

        //--------------------------------------------------
        // Way 3 : Lambda Expression
        //--------------------------------------------------

        Collections.sort(list,
                (s1, s2) -> s1.name.compareTo(s2.name));

        System.out.println("\nLambda Expression");
        System.out.println(list);

        //--------------------------------------------------
        // Way 4 : Method Reference
        //--------------------------------------------------

        list.sort(Comparator.comparing(Student::getName));

        System.out.println("\nMethod Reference");
        System.out.println(list);

    }
}