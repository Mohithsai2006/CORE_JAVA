package D10_Collections.QueueInterface.PriorityQueue;
import java.util.*;
/*
 * ============================================================================
 *                      PRIORITYQUEUE - DEMO 2
 * ============================================================================
 *
 * Demo 1 covered
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
 * Demo 2 covers
 * -------------
 * ✔ Natural Ordering (Min Heap)
 * ✔ Custom Comparator (Max Heap)
 * ✔ comparator()
 * ✔ iterator()
 * ✔ Important Interview Points
 *
 * ============================================================================
 */

public class Demo2 {

    public static void main(String[] args) {

        /*
         * =====================================================
         * Natural Ordering (Min Heap)
         * =====================================================
         *
         * Smallest element has highest priority.
         */
 Set<Integer> s=new HashSet<>();

        PriorityQueue<Integer> minHeap =
                new PriorityQueue<>();

        minHeap.offer(50);
        minHeap.offer(10);
        minHeap.offer(80);
        minHeap.offer(20);
        minHeap.offer(30);

        System.out.println("========== MIN HEAP ==========");

        System.out.println(minHeap);

        System.out.println("Head : "
                + minHeap.peek());



        /*
         * =====================================================
         * comparator()
         * =====================================================
         *
         * Returns Comparator used by queue.
         *
         * Natural Ordering
         *
         * returns null.
         */

        System.out.println("\nComparator : "
                + minHeap.comparator());



        /*
         * =====================================================
         * iterator()
         * =====================================================
         *
         * Iterator does NOT traverse
         * in sorted order.
         *
         * It simply traverses
         * the internal heap.
         */

        System.out.println("\nIterator Traversal");

        Iterator<Integer> iterator =
                minHeap.iterator();

        while (iterator.hasNext()) {

            System.out.print(
                    iterator.next() + " ");

        }



        /*
         * =====================================================
         * Custom Comparator
         * =====================================================
         *
         * Reverse Order
         *
         * Creates a Max Heap.
         */

        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(
                        Comparator.reverseOrder());



        maxHeap.offer(50);
        maxHeap.offer(10);
        maxHeap.offer(80);
        maxHeap.offer(20);
        maxHeap.offer(30);



        System.out.println("\n\n========== MAX HEAP ==========");

        System.out.println(maxHeap);

        System.out.println("Head : "
                + maxHeap.peek());



        /*
         * =====================================================
         * Removing Elements
         * =====================================================
         *
         * Largest element is removed first
         * because of reverseOrder().
         */

        System.out.println("\nRemoving Elements");

        while (!maxHeap.isEmpty()) {

            System.out.println(
                    maxHeap.poll());

        }



        /*
         * =====================================================
         * Important Interview Point
         * =====================================================
         */

        System.out.println("\n========== INTERVIEW ==========");

        System.out.println(
                "PriorityQueue maintains only\n"
                        + "the Head according to priority.");

        System.out.println(
                "Remaining elements are NOT\n"
                        + "completely sorted.");

    }

}
