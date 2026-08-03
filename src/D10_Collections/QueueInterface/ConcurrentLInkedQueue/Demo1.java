package D10_Collections.QueueInterface.ConcurrentLInkedQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.Iterator;
public class Demo1 {
    public static void main(String[] args) {
        /*
         * ==========================================================
         * Creating ConcurrentLinkedQueue
         * ==========================================================
         *
         * Internally:
         * -------------
         * Initially queue is empty.
         *
         * head
         *  |
         *  v
         * null
         *
         * tail
         *  |
         *  v
         * null
         */

        ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<>();


        /*
         * ==========================================================
         * offer()
         * ==========================================================
         *
         * offer() inserts element at the tail of the queue.
         *
         * Internally:
         *
         * Step 1:
         * Creates a new Node.
         *
         * Node
         * ------
         * item = 10
         * next = null
         *
         * Step 2:
         * CAS updates tail.next
         *
         * Step 3:
         * Tail moves to newly inserted node.
         */

        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        queue.offer(40);

        System.out.println("Queue after offer(): " + queue);


        /*
         * Queue internally
         *
         * head
         *  |
         *  v
         * +----+     +----+     +----+     +----+
         * |10  | --> |20  | --> |30  | --> |40  | --> null
         * +----+     +----+     +----+     +----+
         *                                         ^
         *                                         |
         *                                       tail
         */


        /*
         * ==========================================================
         * add()
         * ==========================================================
         *
         * add() internally calls offer().
         *
         * Difference:
         * ----------
         * Since ConcurrentLinkedQueue is unbounded,
         * add() always succeeds.
         */

        queue.add(50);

        System.out.println("\nAfter add(50)");
        System.out.println(queue);


        /*
         * ==========================================================
         * peek()
         * ==========================================================
         *
         * Returns first element.
         *
         * Does NOT remove it.
         *
         * head remains same.
         */

        System.out.println("\npeek(): " + queue.peek());

        System.out.println("Queue after peek()");
        System.out.println(queue);


        /*
         * ==========================================================
         * poll()
         * ==========================================================
         *
         * Removes first element.
         *
         * Before:
         *
         * head
         *  |
         *  v
         * 10 -> 20 -> 30 -> 40 -> 50
         *
         * After:
         *
         * head
         *  |
         *  v
         * 20 -> 30 -> 40 -> 50
         *
         * Node containing 10 becomes eligible for GC.
         */

        System.out.println("\npoll(): " + queue.poll());

        System.out.println("Queue after poll()");
        System.out.println(queue);


        /*
         * ==========================================================
         * element()
         * ==========================================================
         *
         * Returns first element.
         *
         * Throws NoSuchElementException
         * if queue is empty.
         */

        System.out.println("\nelement(): " + queue.element());


        /*
         * ==========================================================
         * contains()
         * ==========================================================
         *
         * Traverses node by node.
         *
         * Complexity:
         * O(n)
         */

        System.out.println("\nContains 30 : " + queue.contains(30));

        System.out.println("Contains 100 : " + queue.contains(100));


        /*
         * ==========================================================
         * size()
         * ==========================================================
         *
         * IMPORTANT:
         *
         * ConcurrentLinkedQueue does NOT maintain
         * an internal count variable.
         *
         * Instead,
         * it traverses every node.
         *
         * Complexity:
         * O(n)
         */

        System.out.println("\nSize : " + queue.size());


        /*
         * ==========================================================
         * isEmpty()
         * ==========================================================
         */

        System.out.println("\nIs Empty : " + queue.isEmpty());


        /*
         * ==========================================================
         * Iterator
         * ==========================================================
         *
         * Iterator is Weakly Consistent.
         *
         * Means:
         *
         * Queue can change while iterator is traversing.
         *
         * No ConcurrentModificationException.
         */

        System.out.println("\nTraversing using Iterator");

        Iterator<Integer> iterator = queue.iterator();

        while (iterator.hasNext()) {

            Integer value = iterator.next();

            System.out.println(value);
        }


        /*
         * ==========================================================
         * remove(Object)
         * ==========================================================
         *
         * Removes first occurrence.
         *
         * Traverses queue.
         */

        queue.remove(40);

        System.out.println("\nAfter remove(40)");
        System.out.println(queue);


        /*
         * ==========================================================
         * clear()
         * ==========================================================
         *
         * Removes every node.
         *
         * Queue becomes:
         *
         * head
         *  |
         *  v
         * null
         *
         * tail
         *  |
         *  v
         * null
         */

        queue.clear();

        System.out.println("\nAfter clear()");
        System.out.println(queue);


        /*
         * ==========================================================
         * poll() on empty queue
         * ==========================================================
         *
         * Returns null.
         */

        System.out.println("\npoll() on empty queue : " + queue.poll());


        /*
         * ==========================================================
         * peek() on empty queue
         * ==========================================================
         *
         * Returns null.
         */

        System.out.println("peek() on empty queue : " + queue.peek());


        /*
         * ==========================================================
         * add null
         * ==========================================================
         *
         * Uncomment below line.
         *
         * ConcurrentLinkedQueue does NOT allow null.
         *
         * Reason:
         * poll() returns null when queue is empty.
         *
         * If null elements are allowed,
         * JVM cannot distinguish
         * between
         *
         * "actual null element"
         *
         * and
         *
         * "empty queue".
         */

        // queue.offer(null);   // NullPointerException
    }
}