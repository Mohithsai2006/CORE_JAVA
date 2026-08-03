package D10_Collections.QueueInterface.ArrayDeque;
import java.util.ArrayDeque;
/*
 * ============================================================================
 *                      ARRAYDEQUE - DEMO 1
 * ============================================================================
 *
 * Definition
 * ----------
 * ArrayDeque is a class that implements the
 *
 *      Deque
 *
 * interface.
 *
 * Since Deque extends Queue,
 * ArrayDeque can work as
 *
 * ✔ Queue (FIFO)
 * ✔ Deque (Double Ended Queue)
 * ✔ Stack (LIFO)
 *
 * Unlike LinkedList,
 * ArrayDeque does NOT use Node objects.
 *
 * Instead,
 * it stores elements inside a
 *
 *      Resizable Circular Array.
 *
 *
 * ============================================================================
 * INTERNAL STRUCTURE
 * ============================================================================
 *
 * Internally uses a Circular Array.
 *
 *                  Head                  Tail
 *                    │                     │
 *                    ▼                     ▼
 *      +----+----+----+----+----+----+----+
 *      |    | 10 | 20 | 30 | 40 |    |    |
 *      +----+----+----+----+----+----+----+
 *
 *
 * Head
 * ----
 * First element of the deque.
 *
 * Queue removal happens from Head.
 *
 *
 * Tail
 * ----
 * Last element of the deque.
 *
 * Queue insertion happens at Tail.
 *
 *
 * Since this is a Deque,
 *
 * insertion and removal
 *
 * are possible from BOTH ends.
 *
 *
 * Front (Head)
 *      ↑
 * 10 20 30 40
 *            ↓
 *        Rear (Tail)
 *
 *
 * ============================================================================
 * IMPORTANT INTERVIEW POINTS
 * ============================================================================
 *
 * 1. Default Capacity : Resizable Circular Array
 *
 * 2. Initial Size : 0
 *
 * 3. Capacity Growth : Automatic
 *
 * 4. Duplicate Elements : YES
 *
 * 5. Null Values : NO
 *    Why?
 *    null is reserved internally.
 *
 * 6. Insertion Order : YES
 *
 * 7. Sorted Order : NO
 *
 * 8. Random Access : NO
 *
 * 9. Thread Safe : NO
 *
 * 10. Best Use Cases
 *
 * Queue
 * Deque
 * Stack
 * Sliding Window
 * BFS Traversal
 *
 *
 * ============================================================================
 * DEMO 1 TOPICS
 * ============================================================================
 *
 * ✔ Creation
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
 * ============================================================================
 */

public class Demo1 {

    public static void main(String[] args) {

        /*
         * Creates an empty ArrayDeque.
         *
         * Initially
         *
         * Head = null
         * Tail = null
         * Size = 0
         */

        ArrayDeque<Integer> deque =
                new ArrayDeque<>();


        System.out.println("========== INITIAL DETAILS ==========");

        System.out.println("Initial Size : "
                + deque.size());

        System.out.println("Is Empty : "
                + deque.isEmpty());


        /*
         * =====================================================
         * add()
         * =====================================================
         *
         * Queue insertion.
         *
         * Adds element at Tail.
         */

        deque.add(10);
        deque.add(20);
        deque.add(30);
        deque.add(40);

        System.out.println("\nAfter add()");

        System.out.println(deque);



        /*
         * =====================================================
         * offer()
         * =====================================================
         *
         * Also inserts at Tail.
         */

        deque.offer(50);

        deque.offer(60);

        System.out.println("\nAfter offer()");

        System.out.println(deque);



        /*
         * =====================================================
         * peek()
         * =====================================================
         *
         * Returns Head.
         *
         * Does NOT remove.
         */

        System.out.println("\npeek() : "
                + deque.peek());



        /*
         * =====================================================
         * element()
         * =====================================================
         *
         * Returns Head.
         *
         * Throws exception if empty.
         */

        System.out.println("element() : "
                + deque.element());



        /*
         * =====================================================
         * VERIFICATION
         * =====================================================
         */

        System.out.println("\nContains 30 : "
                + deque.contains(30));

        System.out.println("Current Size : "
                + deque.size());



        /*
         * =====================================================
         * poll()
         * =====================================================
         *
         * Removes Head.
         */

        System.out.println("\npoll() : "
                + deque.poll());

        System.out.println(deque);



        /*
         * =====================================================
         * remove()
         * =====================================================
         *
         * Removes Head.
         */

        System.out.println("\nremove() : "
                + deque.remove());

        System.out.println(deque);



        /*
         * =====================================================
         * clear()
         * =====================================================
         */

        deque.clear();

        System.out.println("\nAfter clear()");

        System.out.println(deque);



        /*
         * =====================================================
         * FINAL DETAILS
         * =====================================================
         */

        System.out.println("\nFinal Size : "
                + deque.size());

        System.out.println("Is Empty : "
                + deque.isEmpty());

    }

}
