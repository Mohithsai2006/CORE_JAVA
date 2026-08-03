package D10_Collections.QueueInterface.PriorityQueue;
import java.util.PriorityQueue;
/*
 * ============================================================================
 *                      PRIORITYQUEUE - DEMO 1
 * ============================================================================
 *
 * Definition
 * ----------
 * PriorityQueue is a class that implements the Queue interface.
 *
 * Unlike LinkedList and ArrayDeque,
 * PriorityQueue stores elements according to their priority,
 * not insertion order.
 *
 * By default, Java uses Natural Ordering (Min Heap).
 *
 * ============================================================================
 * INTERNAL STRUCTURE
 * ============================================================================
 *
 * Internally uses a Resizable Array represented as a Binary Min Heap.
 *
 *                 10
 *               /    \
 *             20      30
 *            /  \    /  \
 *          50   40  60   80
 *
 * Head
 * ----
 * The Head always stores the highest priority element.
 * (Smallest element by default)
 *
 * Tail
 * ----
 * There is NO fixed Tail because heap elements are rearranged
 * after every insertion/removal.
 *
 * Heapify Up
 * ----------
 * Insert 15
 *
 * Before
 *
 *      10
 *     /  \
 *   20    30
 *
 * After insertion
 *
 *      10
 *     /  \
 *   20    30
 *  /
 *15
 *
 * Since 15 < 20, Java swaps them.
 * This process is called Heapify Up (Sift Up).
 *
 * ============================================================================
 * IMPORTANT INTERVIEW POINTS
 * ============================================================================
 *
 * Default Capacity      : 11
 * Initial Size          : 0
 * Capacity Growth       : Automatic
 * Duplicate Elements    : YES
 * Null Values           : NO
 * Insertion Order       : NO
 * Sorted Order          : NO (Only Head is guaranteed)
 * Random Access         : NO
 * Thread Safe           : NO
 *
 * Best Use Cases
 * --------------
 * CPU Scheduling
 * Task Scheduling
 * Dijkstra Algorithm
 * Huffman Coding
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
 * ✔ contains()
 * ✔ size()
 * ✔ poll()
 * ✔ remove()
 * ✔ clear()
 *
 * ============================================================================
 */

public class Demo1 {

    public static void main(String[] args) {

        /*
         * Creates an empty PriorityQueue.
         *
         * Initially
         *
         * Head = null
         * Size = 0
         */

        PriorityQueue<Integer> queue = new PriorityQueue<>();


        System.out.println("========== INITIAL DETAILS ==========");

        System.out.println("Size : " + queue.size());

        System.out.println("Is Empty : " + queue.isEmpty());


        /*
         * =====================================================
         * add()
         * =====================================================
         *
         * Inserts according to priority.
         */

        queue.add(50);
        queue.add(20);
        queue.add(70);
        queue.add(10);

        System.out.println("\nAfter add()");

        System.out.println(queue);


        /*
         * =====================================================
         * offer()
         * =====================================================
         *
         * Also inserts according to priority.
         */

        queue.offer(40);
        queue.offer(15);

        System.out.println("\nAfter offer()");

        System.out.println(queue);


        /*
         * =====================================================
         * peek()
         * =====================================================
         *
         * Returns highest priority element.
         *
         * Does NOT remove it.
         */

        System.out.println("\npeek() : " + queue.peek());


        /*
         * =====================================================
         * element()
         * =====================================================
         *
         * Similar to peek().
         * Throws exception if queue is empty.
         */

        System.out.println("element() : " + queue.element());


        /*
         * =====================================================
         * VERIFICATION
         * =====================================================
         */

        System.out.println("\nContains 20 : "
                + queue.contains(20));

        System.out.println("Current Size : "
                + queue.size());


        /*
         * =====================================================
         * poll()
         * =====================================================
         *
         * Removes the Head
         * (Highest Priority Element)
         */

        System.out.println("\npoll() : "
                + queue.poll());

        System.out.println(queue);


        /*
         * =====================================================
         * remove()
         * =====================================================
         *
         * Removes the next highest priority element.
         */

        System.out.println("\nremove() : "
                + queue.remove());

        System.out.println(queue);


        /*
         * =====================================================
         * clear()
         * =====================================================
         */

        queue.clear();

        System.out.println("\nAfter clear()");

        System.out.println(queue);


        /*
         * =====================================================
         * FINAL DETAILS
         * =====================================================
         */

        System.out.println("\nFinal Size : "
                + queue.size());

        System.out.println("Is Empty : "
                + queue.isEmpty());

    }
}