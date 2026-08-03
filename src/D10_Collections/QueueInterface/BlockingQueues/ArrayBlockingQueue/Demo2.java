package D10_Collections.QueueInterface.BlockingQueues.ArrayBlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;
public class Demo2 {
    public static void main(String[] args) {
        /*
         * ==========================================================
         * Shared Queue
         * ==========================================================
         *
         * Capacity = 3
         *
         * Internally
         *
         * +------+------+------+
         * |      |      |      |
         * +------+------+------+
         *
         * takeIndex = 0
         * putIndex  = 0
         * count     = 0
         *
         * Both Producer and Consumer
         * will access the same queue.
         */

        ArrayBlockingQueue<Integer> queue =
                new ArrayBlockingQueue<>(3);

        /*
         * ==========================================================
         * Producer Thread
         * ==========================================================
         *
         * put()
         *
         * If queue is FULL
         *
         * Producer waits.
         *
         * Internally
         *
         * lock.lock()
         *
         * while(count==capacity)
         *
         *      notFull.await()
         *
         * After Consumer removes one element,
         *
         * Consumer executes
         *
         * notFull.signal()
         *
         * Producer wakes automatically.
         */
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 6; i++) {
                    System.out.println(
                            "Producer trying to insert : " + i);
                    queue.put(i);
                    System.out.println("Producer inserted : " + i);

                    /*
                     * Producer is faster.
                     *
                     * Queue will become FULL.
                     */

                    Thread.sleep(500);

                }

            } catch (Exception e) {

                e.printStackTrace();

            }

        });


        /*
         * ==========================================================
         * Consumer Thread
         * ==========================================================
         *
         * take()
         *
         * If queue is EMPTY
         *
         * Consumer waits.
         *
         * Internally
         *
         * while(count==0)
         *
         *      notEmpty.await()
         *
         * Producer inserts
         *
         * notEmpty.signal()
         *
         * Consumer wakes.
         */

        Thread consumer = new Thread(() -> {

            try {

                /*
                 * Delay Consumer
                 *
                 * So producer fills queue first.
                 */

                Thread.sleep(2500);

                while (true) {

                    System.out.println(
                            "Consumer waiting...");

                    Integer value = queue.take();

                    System.out.println(
                            "Consumer removed : " + value);

                    Thread.sleep(1000);

                }

            } catch (Exception e) {

                e.printStackTrace();

            }

        });

        producer.start();
        consumer.start();

    }
}
