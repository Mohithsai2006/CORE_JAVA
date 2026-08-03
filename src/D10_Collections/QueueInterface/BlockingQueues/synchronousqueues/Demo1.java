package D10_Collections.QueueInterface.BlockingQueues.synchronousqueues;
import java.util.concurrent.SynchronousQueue;
public class Demo1 {
    public static void main(String[] args) throws InterruptedException {
        /*
            SynchronousQueue
            Capacity = 0
            It never stores elements.
            Every put() must wait
            for a matching take().
            Default Constructor
            Uses TransferStack (LIFO)
        */
        SynchronousQueue<String> queue =
                new SynchronousQueue<>();
        System.out.println("============== Queue Properties ==============");
        /*
            Since queue has zero capacity,
            size() is always ZERO.
         */
        System.out.println("Queue Size : " + queue.size());
        /*
            Remaining Capacity
            Also ZERO.
            Because queue
            cannot store anything.
         */
        System.out.println("Remaining Capacity : "
                + queue.remainingCapacity());
        /*
            peek()
            Always returns NULL.
            Nothing is stored.
         */
        System.out.println("Peek : " + queue.peek());
        System.out.println("\n============== offer() =================");
        /*
            offer()
            Does NOT wait.
            It succeeds ONLY IF
            some consumer thread
            is already waiting.

            Right now

            No Consumer

            Therefore

            returns FALSE.
         */

        boolean status = queue.offer("Java");

        System.out.println("offer(Java) : " + status);

        System.out.println("Queue Size : " + queue.size());


        System.out.println("\n============== poll() =================");

        /*
            poll()

            Returns immediately.

            Since

            No Producer

            waiting

            returns NULL.
         */

        System.out.println("poll() : " + queue.poll());


        System.out.println("\n============== put() / take() =================");

        /*
            Consumer Thread

            Sleeps first.

            Producer will block
            until consumer becomes ready.
         */

        Thread consumer = new Thread(() -> {

            try {

                /*
                    Simulate Busy Consumer.

                    Consumer is NOT ready.

                    Producer has to wait.
                 */

                Thread.sleep(4000);

                System.out.println("\nConsumer Ready...");

                /*
                    take()

                    Immediately receives

                    producer's element.

                    Queue never stores it.
                 */

                String data = queue.take();

                System.out.println("Consumer Received : " + data);

            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }

        });


        consumer.start();

        /*
            Give consumer thread
            time to start sleeping.
         */

        Thread.sleep(1000);

        System.out.println("\nProducer calling put(Java)...");

        long start = System.currentTimeMillis();

        /*
            Producer blocks here.

            Queue does NOT store Java.

            Producer simply waits.

            After consumer calls take()

            direct handoff happens.
         */

        queue.put("Java");

        long end = System.currentTimeMillis();

        System.out.println("\nProducer Continued.");

        System.out.println("Blocked for : "
                + (end - start)
                + " ms");


        System.out.println("\n============== Queue Status After Transfer ==============");

        /*
            Even after successful transfer

            Queue remains EMPTY.
         */

        System.out.println("Queue Size : " + queue.size());

        System.out.println("Remaining Capacity : "
                + queue.remainingCapacity());

        System.out.println("Peek : " + queue.peek());

        System.out.println("\nDemo Completed.");
    }
}
