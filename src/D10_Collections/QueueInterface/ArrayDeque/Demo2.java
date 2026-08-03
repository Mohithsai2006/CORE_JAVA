package D10_Collections.QueueInterface.ArrayDeque;
import java.util.ArrayDeque;
import java.util.Iterator;
/*
 * ============================================================================
 *                      ARRAYDEQUE - DEMO 2
 * ============================================================================
 *
 * Demo 1 Covered
 * --------------
 * ✔ add()
 * ✔ offer()
 * ✔ peek()
 * ✔ element()
 * ✔ poll()
 * ✔ remove()
 * ✔ contains()
 * ✔ size()
 * ✔ clear()
 *
 *
 * Demo 2 Covers
 * -------------
 * ✔ addFirst()
 * ✔ addLast()
 * ✔ offerFirst()
 * ✔ offerLast()
 * ✔ peekFirst()
 * ✔ peekLast()
 * ✔ pollFirst()
 * ✔ pollLast()
 * ✔ removeFirst()
 * ✔ removeLast()
 * ✔ push()
 * ✔ pop()
 * ✔ descendingIterator()
 *
 * ============================================================================
 */
public class Demo2 {

    public static void main(String[] args) {

        ArrayDeque<Integer> deque =
                new ArrayDeque<>();


        /*
         * =====================================================
         * addFirst()
         * =====================================================
         *
         * Inserts element at Head.
         */

        deque.addFirst(20);
        deque.addFirst(10);

        System.out.println("After addFirst()");

        System.out.println(deque);



        /*
         * =====================================================
         * addLast()
         * =====================================================
         *
         * Inserts element at Tail.
         */

        deque.addLast(30);
        deque.addLast(40);

        System.out.println("\nAfter addLast()");

        System.out.println(deque);



        /*
         * =====================================================
         * offerFirst()
         * =====================================================
         *
         * Inserts at Head.
         */

        deque.offerFirst(5);

        System.out.println("\nAfter offerFirst()");

        System.out.println(deque);



        /*
         * =====================================================
         * offerLast()
         * =====================================================
         *
         * Inserts at Tail.
         */

        deque.offerLast(50);

        System.out.println("\nAfter offerLast()");

        System.out.println(deque);



        /*
         * =====================================================
         * peekFirst()
         * =====================================================
         *
         * Returns Head.
         *
         * Does NOT remove.
         */

        System.out.println("\npeekFirst() : "
                + deque.peekFirst());



        /*
         * =====================================================
         * peekLast()
         * =====================================================
         *
         * Returns Tail.
         *
         * Does NOT remove.
         */

        System.out.println("peekLast() : "
                + deque.peekLast());



        /*
         * =====================================================
         * pollFirst()
         * =====================================================
         *
         * Removes Head.
         */

        System.out.println("\npollFirst() : "
                + deque.pollFirst());

        System.out.println(deque);



        /*
         * =====================================================
         * pollLast()
         * =====================================================
         *
         * Removes Tail.
         */

        System.out.println("\npollLast() : "
                + deque.pollLast());

        System.out.println(deque);



        /*
         * =====================================================
         * removeFirst()
         * =====================================================
         *
         * Removes Head.
         *
         * Throws exception if empty.
         */

        System.out.println("\nremoveFirst() : "
                + deque.removeFirst());

        System.out.println(deque);



        /*
         * =====================================================
         * removeLast()
         * =====================================================
         *
         * Removes Tail.
         *
         * Throws exception if empty.
         */

        System.out.println("\nremoveLast() : "
                + deque.removeLast());

        System.out.println(deque);



        /*
         * =====================================================
         * push()
         * =====================================================
         *
         * Works like Stack.
         *
         * Internally same as addFirst().
         */

        deque.push(100);
        deque.push(200);

        System.out.println("\nAfter push()");

        System.out.println(deque);



        /*
         * =====================================================
         * pop()
         * =====================================================
         *
         * Removes Head.
         *
         * Internally same as removeFirst().
         */

        System.out.println("\npop() : "
                + deque.pop());

        System.out.println(deque);



        /*
         * =====================================================
         * descendingIterator()
         * =====================================================
         *
         * Traverses from Tail to Head.
         */

        System.out.println("\nDescending Iterator");

        Iterator<Integer> iterator =
                deque.descendingIterator();

        while (iterator.hasNext()) {

            System.out.print(
                    iterator.next() + " ");

        }

    }

}
