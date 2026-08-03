package D11_comparator.aImplementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student {

    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return id + " " + name;
    }
}

// Separate Comparator class
class NameComparator implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {

        // Compare names alphabetically
        return s1.name.compareTo(s2.name);

    }
}

public class Demo {

    public static void main(String[] args) {

        List<Student> list = new ArrayList<>();

        list.add(new Student(103, "Krishna"));
        list.add(new Student(101, "Anil"));
        list.add(new Student(102, "Ravi"));

        // Pass Comparator object
        Collections.sort(list, new NameComparator());

        System.out.println(list);

    }
}