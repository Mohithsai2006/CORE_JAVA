package D10_Collections.QueueInterface.ConcurrentLInkedQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
public class Demo2 {
    public static void main(String[] args) throws InterruptedException {
        /*
         * Shared Queue
         *
         * Multiple threads will access this queue simultaneously.
         *
         * Internally
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
         * Producer Thread
         * ==========================================================
         * Continuously inserts elements.
         *
         * Internally every offer()
         *
         * 1. Creates a new Node.
         * 2. Uses CAS to update tail.next.
         * 3. Moves tail.
         */

        Runnable producer = () -> {

            for (int i = 1; i <= 10; i++) {

                queue.offer(i);

                System.out.println(
                        Thread.currentThread().getName()
                                + " Produced : " + i);

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        };


        /*
         * ==========================================================
         * Consumer Thread
         * ==========================================================
         *
         * Continuously removes elements.
         *
         * poll()
         *
         * Removes head node.
         *
         * Returns null if queue is empty.
         */

        Runnable consumer = () -> {

            for (int i = 1; i <= 10; i++) {

                Integer value = queue.poll();

                System.out.println(
                        Thread.currentThread().getName()
                                + " Consumed : " + value);

                try {
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        };


        /*
         * Creating Threads
         */

        Thread producer1 = new Thread(producer, "Producer-1");

        Thread producer2 = new Thread(producer, "Producer-2");

        Thread consumer1 = new Thread(consumer, "Consumer-1");

        Thread consumer2 = new Thread(consumer, "Consumer-2");


        /*
         * Starting all threads together.
         */

        producer1.start();
        producer2.start();

        consumer1.start();
        consumer2.start();


        /*
         * Wait until every thread finishes.
         */

        producer1.join();
        producer2.join();

        consumer1.join();
        consumer2.join();


        /*
         * Queue after all operations.
         */

        System.out.println();

        System.out.println("Remaining Queue : " + queue);

        System.out.println("Remaining Size  : " + queue.size());

    }
}