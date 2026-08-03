package D10_Collections.QueueInterface.BlockingQueues.PrioirityBlockingQueue;
import java.util.Iterator;
import java.util.concurrent.PriorityBlockingQueue;
public class Demo1 {
    public static void main(String[] args) throws InterruptedException {
        // Creates a PriorityBlockingQueue with default capacity (11)
        // Queue is UNBOUNDED and thread-safe.
        PriorityBlockingQueue<Integer> queue = new PriorityBlockingQueue<>();
        System.out.println("Initially Queue : " + queue);
        System.out.println("\n================ offer() =================");
        // Inserts elements.
        // Elements are arranged according to their priority
        // (Natural Ordering for Integer).
        queue.offer(40);
        queue.offer(10);
        queue.offer(70);
        queue.offer(20);
        queue.offer(50);
        queue.offer(30);
        System.out.println("After offer(): " + queue);
        /*
           Output may look like

               [10, 20, 30, 40, 50, 70]

           BUT DON'T assume Queue.toString() is sorted.
           Internally it stores elements as a Binary Heap.
           Heap Example

                    10
                  /    \
                20      30
               /  \    /
             40   50 70

           Heap Property:
           Parent <= Children
           Entire array is NOT necessarily sorted.
        */

        System.out.println("\n================ put() =================");
        // put() behaves exactly like offer()
        // because queue is UNBOUNDED.
        queue.put(5);
        System.out.println("After put(5): " + queue);
        /*
           Notice
           Unlike ArrayBlockingQueue
               put()
           never waits because queue never becomes full.
        */
        System.out.println("\n================ peek() =================");
        // Returns highest priority element.
        // Doesn't remove.
        System.out.println("Peek : " + queue.peek());

        System.out.println("Queue after peek : " + queue);

        System.out.println("\n================ contains() =================");

        System.out.println("Contains 20 ? " + queue.contains(20));
        System.out.println("Contains 100 ? " + queue.contains(100));

        System.out.println("\n================ size() =================");

        System.out.println("Queue Size : " + queue.size());

        System.out.println("\n================ Iterator =================");

        /*
           Iterator is Weakly Consistent.

           It DOES NOT guarantee sorted order.

           It simply traverses internal heap array.

           So NEVER use iterator if you need
           elements in priority order.
        */

        Iterator<Integer> itr = queue.iterator();

        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }

        System.out.println();

        System.out.println("\n================ poll() =================");

        /*
           poll()

           Removes Highest Priority Element.

           Every removal performs

               Heapify Down

           Complexity

               O(log n)
        */

        while (!queue.isEmpty()) {

            Integer value = queue.poll();

            System.out.println("Removed : " + value);

            System.out.println("Remaining Queue : " + queue);

            /*
               Observe

               Elements are removed in priority order

               5
               10
               20
               30
               40
               50
               70

               even though internal array
               continuously rearranges itself.
            */
        }

        System.out.println("\n================ take() =================");

        /*
           take()

           If queue is empty

           Current thread waits.

           We'll insert an element from another thread
           after 3 seconds.
        */

        Thread producer = new Thread(() -> {

            try {

                Thread.sleep(3000);

                System.out.println("\nProducer inserting 999");

                queue.put(999);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        producer.start();

        System.out.println("Consumer waiting using take()...");

        // Current thread blocks here
        Integer value = queue.take();

        System.out.println("Received : " + value);

        System.out.println("\nDemo Completed.");
    }
}
