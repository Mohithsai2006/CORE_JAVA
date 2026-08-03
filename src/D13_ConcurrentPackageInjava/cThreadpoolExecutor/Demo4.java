//ThreadFactory + RejectedExecutionHandler
package D13_ConcurrentPackageInjava.cThreadpoolExecutor;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Demo4 {

    public static void main(String[] args) {

        /*
         * ThreadFactory
         *
         * ThreadPoolExecutor NEVER creates
         * worker threads directly.
         *
         * It always asks ThreadFactory.
         *
         * ThreadFactory allows us to customise
         *
         * Thread Name
         * Daemon Status
         * Priority
         * Thread Group
         */

        ThreadFactory customFactory = new ThreadFactory() {

            /*
             * Used for generating
             * unique worker names.
             */

            private final AtomicInteger count =
                    new AtomicInteger(1);

            @Override
            public Thread newThread(Runnable r) {

                Thread t =
                        new Thread(r);

                /*
                 * Give meaningful names
                 * instead of
                 *
                 * pool-1-thread-1
                 */

                t.setName(
                        "Payment-Worker-"
                                + count.getAndIncrement());

                /*
                 * Normal Priority
                 */

                t.setPriority(Thread.NORM_PRIORITY);

                /*
                 * User Thread
                 */

                t.setDaemon(false);

                return t;

            }

        };



        /*
         * Custom Rejection Policy
         *
         * Invoked whenever
         *
         * Queue Full
         * AND
         * Maximum Workers Reached
         */

        RejectedExecutionHandler handler =
                (task, executor) -> {

                    System.out.println();

                    System.out.println("Task Rejected");

                    System.out.println(
                            "Pool Size : "
                                    + executor.getPoolSize());

                    System.out.println(
                            "Queue Size : "
                                    + executor.getQueue().size());

                };



        ThreadPoolExecutor executor =
                new ThreadPoolExecutor(

                        2,
                        3,
                        10,
                        TimeUnit.SECONDS,

                        /*
                         * Queue Capacity
                         */

                        new ArrayBlockingQueue<>(2),

                        /*
                         * Custom ThreadFactory
                         */

                        customFactory,

                        /*
                         * Custom Reject Policy
                         */

                        handler
                );



        /*
         * Submit more tasks
         * than pool can handle.
         */

        for (int i = 1; i <= 7; i++) {

            final int taskNo = i;

            executor.execute(() -> {

                System.out.println(

                        Thread.currentThread().getName()

                                + " executing Task-"

                                + taskNo);

                try {

                    Thread.sleep(5000);

                }

                catch (InterruptedException e) {

                    Thread.currentThread().interrupt();

                }

            });

        }



        executor.shutdown();

    }

}