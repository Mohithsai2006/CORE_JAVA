package D10_Collections.ListInterface.ArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;

/*
 * ============================================================================
 *                      ARRAYLIST - DEMO 2
 * ============================================================================
 *
 * Definition
 * ----------
 * This demo covers the advanced methods available in ArrayList.
 *
 * Apart from CRUD operations, ArrayList provides several utility methods
 * for bulk operations, iteration, sorting, cloning and capacity management.
 *
 *
 * ============================================================================
 * TOPICS COVERED
 * ============================================================================
 *
 * ✔ Bulk Operations
 * ✔ Sorting
 * ✔ Cloning
 * ✔ Iterators
 * ✔ ListIterator
 * ✔ forEach()
 * ✔ replaceAll()
 * ✔ subList()
 * ✔ toArray()
 * ✔ ensureCapacity()
 * ✔ trimToSize()
 *
 * ============================================================================
 * METHODS COVERED
 * ============================================================================
 *
 * addAll()
 * containsAll()
 * removeAll()
 * retainAll()
 *
 * iterator()
 * listIterator()
 * forEach()
 *
 * Collections.sort()
 * Collections.reverse()
 * Collections.shuffle()
 *
 * replaceAll()
 *
 * subList()
 *
 * clone()
 *
 * toArray()
 *
 * ensureCapacity()
 *
 * trimToSize()
 *
 * ============================================================================
 */

public class Demo2 {

    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student(101,"Mohith",91));
        students.add(new Student(102,"Rahul",84));
        students.add(new Student(103,"Sai",77));

        System.out.println("Original ArrayList");

        System.out.println(students);

        /*
         * ==========================================================
         * addAll()
         * ==========================================================
         *
         * Adds an entire collection.
         */

        ArrayList<Student> newStudents = new ArrayList<>();

        newStudents.add(new Student(201,"Ajay",80));
        newStudents.add(new Student(202,"Kiran",88));

        students.addAll(newStudents);

        System.out.println("\nAfter addAll()");

        System.out.println(students);

        /*
         * ==========================================================
         * containsAll()
         * ==========================================================
         */

        System.out.println("\nContains All : "
                + students.containsAll(newStudents));

        /*
         * ==========================================================
         * retainAll()
         * ==========================================================
         *
         * Keeps only common elements.
         */

        ArrayList<Student> copy =
                new ArrayList<>(students);

        copy.retainAll(newStudents);

        System.out.println("\nretainAll()");

        System.out.println(copy);

        /*
         * ==========================================================
         * removeAll()
         * ==========================================================
         */

        students.removeAll(newStudents);

        System.out.println("\nAfter removeAll()");

        System.out.println(students);

        /*
         * ==========================================================
         * iterator()
         * ==========================================================
         */

        System.out.println("\nIterator");

        Iterator<Student> iterator =
                students.iterator();

        while(iterator.hasNext()){

            System.out.println(iterator.next());

        }

        /*
         * ==========================================================
         * listIterator()
         * ==========================================================
         */

        System.out.println("\nListIterator (Forward)");

        ListIterator<Student> listIterator =
                students.listIterator();

        while(listIterator.hasNext()){

            System.out.println(listIterator.next());

        }

        System.out.println("\nListIterator (Backward)");

        while(listIterator.hasPrevious()){

            System.out.println(listIterator.previous());

        }

        /*
         * ==========================================================
         * forEach()
         * ==========================================================
         */

        System.out.println("\nforEach()");

        students.forEach(System.out::println);

        /*
         * ==========================================================
         * replaceAll()
         * ==========================================================
         *
         * Updates every element.
         */

        students.replaceAll(student ->
                new Student(
                        student.getId(),
                        student.getName().toUpperCase(),
                        student.getMarks()));

        System.out.println("\nAfter replaceAll()");

        System.out.println(students);

        /*
         * ==========================================================
         * Collections.sort()
         * ==========================================================
         */

        ArrayList<Integer> numbers =
                new ArrayList<>();

        numbers.add(40);
        numbers.add(10);
        numbers.add(30);
        numbers.add(20);

        Collections.sort(numbers);

        System.out.println("\nSorted Numbers");

        System.out.println(numbers);

        /*
         * ==========================================================
         * reverse()
         * ==========================================================
         */

        Collections.reverse(numbers);

        System.out.println("\nReverse");

        System.out.println(numbers);

        /*
         * ==========================================================
         * shuffle()
         * ==========================================================
         */

        Collections.shuffle(numbers);

        System.out.println("\nShuffle");

        System.out.println(numbers);

        /*
         * ==========================================================
         * subList()
         * ==========================================================
         */

        ArrayList<Integer> values =
                new ArrayList<>();

        for(int i=1;i<=10;i++){

            values.add(i);

        }

        System.out.println("\nSubList");

        System.out.println(values.subList(2,7));

        /*
         * ==========================================================
         * clone()
         * ==========================================================
         */

        ArrayList<Student> cloned =
                (ArrayList<Student>) students.clone();

        System.out.println("\nCloned ArrayList");

        System.out.println(cloned);

        /*
         * ==========================================================
         * toArray()
         * ==========================================================
         */

        Object[] objects =
                students.toArray();

        System.out.println("\ntoArray()");

        for(Object obj : objects){

            System.out.println(obj);

        }

        /*
         * ==========================================================
         * ensureCapacity()
         * ==========================================================
         *
         * Increases internal capacity if required.
         */

        ArrayList<Integer> list =
                new ArrayList<>();

        list.ensureCapacity(50);

        System.out.println("\nensureCapacity(50)");

        for(int i=1;i<=25;i++){

            list.add(i);

        }

        System.out.println(list);

        /*
         * ==========================================================
         * trimToSize()
         * ==========================================================
         *
         * Removes unused capacity.
         */

        list.trimToSize();

        System.out.println("\ntrimToSize()");

        System.out.println(list);

    }

}
