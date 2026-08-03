package D10_Collections.QueueInterface.BlockingQueues.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;
/*
    Every object stored inside DelayQueue
    MUST implement Delayed interface.
*/
class DelayedTask implements Delayed {
    // Task Name
    private String taskName;
    // Absolute expiration time (Current Time + Delay)
    private long expireTime;
    /*
        Constructor

        delay -> number of seconds after which
                 this task becomes available.
     */
    public DelayedTask(String taskName, long delayInSeconds) {
        this.taskName = taskName;
        /*
            Store the absolute expiry time.
            Example
            Current Time = 1000 ms
            Delay = 5 sec
            expireTime
            = 1000 + 5000
            = 6000 ms
         */
        this.expireTime =
                System.currentTimeMillis()
                        + TimeUnit.SECONDS.toMillis(delayInSeconds);
    }
    /*
        DelayQueue repeatedly calls this method.
        It should return
           Remaining Delay
        If value > 0
            Not yet expired
        If value <= 0
            Ready to remove
     */
    @Override
    public long getDelay(TimeUnit unit) {
        long remaining =
                expireTime - System.currentTimeMillis();
        return unit.convert(remaining, TimeUnit.MILLISECONDS);
    }
    /*
        DelayQueue internally uses PriorityQueue.
        compareTo()
        decides heap ordering.
        Smaller remaining delay
                comes first.
     */
    @Override
    public int compareTo(Delayed other) {
        long difference =
                this.getDelay(TimeUnit.MILLISECONDS)
                        - other.getDelay(TimeUnit.MILLISECONDS);
        if (difference < 0)
            return -1;
        if (difference > 0)
            return 1;
        return 0;
    }
    @Override
    public String toString() {
        return taskName;
    }
}
public class Demo1 {
    public static void main(String[] args)
            throws InterruptedException {
        /*
            DelayQueue
            Thread Safe
            Unbounded
            Internally
            PriorityQueue
                    +
            ReentrantLock
                    +
            Leader Thread
         */
        DelayQueue<DelayedTask> queue =
                new DelayQueue<>();
        System.out.println("Adding Tasks...\n");
        /*
            Insert Tasks
            Task-2 expires first.
            Task-3 expires second.
            Task-1 expires last.
         */
        queue.offer(new DelayedTask("Task-1 (8 sec)", 8));
        queue.offer(new DelayedTask("Task-2 (3 sec)", 3));
        queue.put(new DelayedTask("Task-3 (5 sec)", 5));
        System.out.println("Queue Size : " + queue.size());
        /*
            peek()
            Returns head element.
           Head means
           Smallest Remaining Delay.
            It DOES NOT remove.
         */
        System.out.println("\npeek() : " + queue.peek());

        /*
            poll()

            Immediately checks.

            If head delay

            NOT expired

            returns NULL.
         */

        System.out.println("\npoll() before expiry : "
                + queue.poll());

        /*
            Consumer

            take()

            waits until

            first task expires.
         */

        System.out.println("\nConsumer waiting...\n");

        while (!queue.isEmpty()) {

            DelayedTask task = queue.take();

            System.out.println(
                    "Executed -> "
                            + task
                            + " at "
                            + System.currentTimeMillis());

        }

        System.out.println("\nAll Tasks Executed.");
    }
}