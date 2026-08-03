package D10_Collections.QueueInterface.BlockingQueues.ArrayBlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
public class Demo1 {
    public static void main(String[] args) throws Exception {
        /*
         * =============================================================
         * Creating ArrayBlockingQueue
         * =============================================================
         *
         * Capacity is mandatory.
         *
         * Queue Capacity = 5
         *
         * Internally
         *
         * items[]
         *
         * +------+------+------+------+------+
         * |      |      |      |      |      |
         * +------+------+------+------+------+
         *
         * takeIndex = 0
         * putIndex  = 0
         * count     = 0
         */
        ArrayBlockingQueue<Integer> queue =
                new ArrayBlockingQueue<>(5);

        /*
         * =============================================================
         * add()
         * =============================================================
         *
         * Inserts element.
         *
         * Throws IllegalStateException
         * if queue becomes full.
         *
         * Internally
         *
         * lock.lock()
         *
         * Insert element.
         *
         * putIndex moves forward.
         *
         * count++
         *
         * lock.unlock()
         */
        queue.add(10);
        queue.add(20);
        queue.add(30);
        System.out.println("After add()");
        System.out.println(queue);
        /*
         * Queue
         *
         * +------+------+------+------+------+
         * |10    |20    |30    |      |      |
         * +------+------+------+------+------+
         *
         * takeIndex = 0
         * putIndex  = 3
         * count     = 3
         */
        /*
         * =============================================================
         * offer()
         * =============================================================
         *
         * Returns true if insertion succeeds.
         *
         * Returns false if queue is full.
         *
         * Does NOT throw exception.
         */
        System.out.println("\noffer(40) : " + queue.offer(40));
        System.out.println("offer(50) : " + queue.offer(50));
        System.out.println(queue);


        /*
         * Queue becomes full.
         */

        System.out.println("\noffer(60)");

        System.out.println(queue.offer(60)); // false


        /*
         * =============================================================
         * remainingCapacity()
         * =============================================================
         *
         * Capacity = 5
         *
         * Current Elements = 5
         *
         * Remaining = 0
         */

        System.out.println();

        System.out.println("Remaining Capacity : "
                + queue.remainingCapacity());


        /*
         * =============================================================
         * peek()
         * =============================================================
         *
         * Returns first element.
         *
         * Does NOT remove.
         */

        System.out.println("\npeek() : "
                + queue.peek());

        System.out.println(queue);


        /*
         * =============================================================
         * element()
         * =============================================================
         *
         * Same as peek().
         *
         * Difference:
         *
         * Throws exception if queue is empty.
         */

        System.out.println("\nelement() : "
                + queue.element());


        /*
         * =============================================================
         * poll()
         * =============================================================
         *
         * Removes first element.
         *
         * Returns null if queue is empty.
         *
         * Internally
         *
         * takeIndex moves.
         *
         * count--
         */

        System.out.println("\npoll() : "
                + queue.poll());

        System.out.println(queue);


        /*
         * Queue
         *
         * +------+------+------+------+------+
         * |      |20    |30    |40    |50    |
         * +------+------+------+------+------+
         *
         * takeIndex = 1
         * putIndex  = 0
         * count     = 4
         */


        /*
         * =============================================================
         * offer() after poll()
         * =============================================================
         *
         * Circular array.
         *
         * putIndex wraps around.
         */

        queue.offer(60);

        System.out.println("\nAfter offer(60)");

        System.out.println(queue);


        /*
         * Internally
         *
         * +------+------+------+------+------+
         * |60    |20    |30    |40    |50    |
         * +------+------+------+------+------+
         *
         * putIndex
         *
         * (4+1)%5 = 0
         */


        /*
         * =============================================================
         * contains()
         * =============================================================
         */

        System.out.println("\nContains 40 : "
                + queue.contains(40));

        System.out.println("Contains 100 : "
                + queue.contains(100));


        /*
         * =============================================================
         * size()
         * =============================================================
         *
         * Returns count variable.
         *
         * O(1)
         */

        System.out.println("\nSize : "
                + queue.size());


        /*
         * =============================================================
         * remove(Object)
         * =============================================================
         *
         * Removes first occurrence.
         */

        queue.remove(40);

        System.out.println("\nAfter remove(40)");

        System.out.println(queue);


        /*
         * =============================================================
         * Timed offer()
         * =============================================================
         *
         * Waits for specified duration
         * if queue is full.
         *
         * Here queue is not full,
         * so insertion succeeds immediately.
         */

        System.out.println("\nTimed offer : "
                + queue.offer(70,
                2,
                TimeUnit.SECONDS));

        System.out.println(queue);


        /*
         * =============================================================
         * clear()
         * =============================================================
         *
         * Removes all elements.
         *
         * count = 0
         */

        queue.clear();

        System.out.println("\nAfter clear()");

        System.out.println(queue);


        /*
         * =============================================================
         * poll() on empty queue
         * =============================================================
         *
         * Returns null.
         */

        System.out.println("\npoll() : "
                + queue.poll());


        /*
         * =============================================================
         * peek() on empty queue
         * =============================================================
         */

        System.out.println("peek() : "
                + queue.peek());


        /*
         * =============================================================
         * add() after clear()
         * =============================================================
         */

        queue.add(100);

        queue.add(200);

        System.out.println("\nAfter adding again");

        System.out.println(queue);


        /*
         * =============================================================
         * Null values
         * =============================================================
         *
         * ArrayBlockingQueue
         * does NOT allow null.
         */

        // queue.add(null);      // NullPointerException

    }
}
