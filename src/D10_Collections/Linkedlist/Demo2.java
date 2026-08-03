package D10_Collections.Linkedlist;
import java.util.Iterator;
import java.util.LinkedList;
/*
 * ============================================================================
 *                      LINKEDLIST - DEMO 2
 * ============================================================================
 *
 * Definition
 * ----------
 * LinkedList implements both
 *
 *      List
 * and
 *      Deque
 *
 * interfaces.
 *
 * Because it implements Deque,
 * LinkedList can work as
 *
 * ✔ Queue (FIFO)
 * ✔ Deque (Double Ended Queue)
 * ✔ Stack (LIFO)
 *
 *
 * ============================================================================
 * DEQUE OPERATIONS
 * ============================================================================
 *
 * Front                                  Rear
 *
 *   ▲                                      ▲
 *   │                                      │
 * null ← A ⇄ B ⇄ C ⇄ D → null
 *
 *
 * We can insert/remove from BOTH ends.
 *
 *
 * ============================================================================
 * METHODS COVERED
 * ============================================================================
 *
 * Queue Methods
 * -------------
 * offer()
 * peek()
 * poll()
 *
 * Deque Methods
 * -------------
 * addFirst()
 * addLast()
 *
 * offerFirst()
 * offerLast()
 *
 * peekFirst()
 * peekLast()
 *
 * pollFirst()
 * pollLast()
 *
 * Stack Methods
 * -------------
 * push()
 * pop()
 *
 * Iterator
 * --------
 * descendingIterator()
 *
 * ============================================================================
 */
public class Demo2 {
    public static void main(String[] args) {
        LinkedList<Student> students = new LinkedList<>();
        /*
         * =====================================================
         * addFirst()
         * =====================================================
         *
         * Inserts node at beginning.
         */
        students.addFirst(
                new Student(
                        101,
                        "Mohith",
                        91));
        students.addFirst(
                new Student(
                        102,
                        "Rahul",
                        82));
        System.out.println("After addFirst()");

        System.out.println(students);



        /*
         * =====================================================
         * addLast()
         * =====================================================
         *
         * Inserts node at end.
         */

        students.addLast(
                new Student(
                        103,
                        "Sai",
                        87));
        students.addLast(
                new Student(
                        104,
                        "Ajay",
                        95));
        System.out.println("\nAfter addLast()");
        System.out.println(students);
        /*
         * =====================================================
         * offer()
         * =====================================================
         *
         * Queue insertion.
         *
         * Adds element at rear.
         */
        students.offer(
                new Student(
                        105,
                        "Kiran",
                        90));
        System.out.println("\nAfter offer()");
        System.out.println(students);
        /*
         * =====================================================
         * offerFirst()
         * =====================================================
         */
        students.offerFirst(
                new Student(
                        106,
                        "Anil",
                        84));

        System.out.println("\nAfter offerFirst()");
        System.out.println(students);
        /*
         * =====================================================
         * offerLast()
         * =====================================================
         */
        students.offerLast(
                new Student(
                        107,
                        "Vijay",
                        80));

        System.out.println("\nAfter offerLast()");
        System.out.println(students);
        /*
         * =====================================================
         * peek()
         * =====================================================
         *
         * Returns first element.
         *
         * Does NOT remove.
         */
        System.out.println("\npeek()");
        System.out.println(students.peek());
        /*
         * =====================================================
         * peekFirst()
         * =====================================================
         */
        System.out.println("\npeekFirst()");
        System.out.println(students.peekFirst());
        /*
         * =====================================================
         * peekLast()
         * =====================================================
         */
        System.out.println("\npeekLast()");
        System.out.println(students.peekLast());
        /*
         * =====================================================
         * poll()
         * =====================================================
         *
         * Removes first node.
         */
        System.out.println("\npoll()");
        System.out.println(students.poll());
        System.out.println(students);
        /*
         * =====================================================
         * pollFirst()
         * =====================================================
         */
        System.out.println("\npollFirst()");
        System.out.println(students.pollFirst());
        System.out.println(students);
        /*
         * =====================================================
         * pollLast()
         * =====================================================
         */
        System.out.println("\npollLast()");
        System.out.println(students.pollLast());
        System.out.println(students);
        /*
         * =====================================================
         * push()
         * =====================================================
         *
         * Works like Stack.
         *
         * Internally same as addFirst().
         */
        students.push(
                new Student(
                        201,
                        "Push-1",
                        99));
        students.push(
                new Student(
                        202,
                        "Push-2",
                        98));
        System.out.println("\nAfter push()");
        System.out.println(students);
        /*
         * =====================================================
         * pop()
         * =====================================================
         *
         * Removes first node.
         *
         * Internally same as removeFirst().
         */
        System.out.println("\npop()");
        System.out.println(students.pop());
        System.out.println(students);
        /*
         * =====================================================
         * descendingIterator()
         * =====================================================
         *
         * Traverses from last node
         * to first node.
         */
        System.out.println("\nDescending Iterator");
        Iterator<Student> iterator =
                students.descendingIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}