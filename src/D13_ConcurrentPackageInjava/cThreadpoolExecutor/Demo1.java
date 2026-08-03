//ThreadPoolExecutor Basics + Constructor + execute() + submit()
package D13_ConcurrentPackageInjava.cThreadpoolExecutor;
import java.util.concurrent.*;

public class Demo1 {

    public static void main(String[] args) throws Exception {

        /*
         * ThreadPoolExecutor Constructor
         *
         * corePoolSize      = 2
         * maximumPoolSize   = 4
         * keepAliveTime     = 10 Seconds
         * Queue             = ArrayBlockingQueue(2)
         *
         * IMPORTANT:
         * ------------
         * Creating ThreadPoolExecutor DOES NOT create any worker threads.
         *
         * Initially:
         *
         * Worker Count = 0
         * Queue = Empty
         * Pool State = RUNNING
         *
         * Worker threads are created lazily
         * only when execute()/submit() receives tasks.
         */

        ThreadPoolExecutor executor =
                new ThreadPoolExecutor(
                        2,
                        4,
                        10,
                        TimeUnit.SECONDS,
                        new ArrayBlockingQueue<>(2)
                );

        System.out.println("Pool Created");
        System.out.println("----------------------------");

        /*
         * Since no task has been submitted,
         * there are NO worker threads.
         */

        System.out.println("Pool Size      : " + executor.getPoolSize());
        System.out.println("Active Threads : " + executor.getActiveCount());
        System.out.println("Queue Size     : " + executor.getQueue().size());

        System.out.println();

        /*
         * execute()
         *
         * Used for Runnable tasks.
         *
         * Returns:
         *      Nothing (void)
         *
         * If worker count < corePoolSize
         *
         * ThreadPoolExecutor creates
         * a NEW CORE WORKER.
         */

        executor.execute(() -> {

            System.out.println(Thread.currentThread().getName()
                    + " executing Task-1");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

        });

        /*
         * Second execute()
         *
         * Worker count = 1
         * Core Pool = 2
         *
         * Therefore another CORE worker
         * is created.
         */

        executor.execute(() -> {

            System.out.println(Thread.currentThread().getName()
                    + " executing Task-2");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

        });

        /*
         * submit()
         *
         * Unlike execute(),
         * submit() returns a Future.
         *
         * submit() can execute
         *
         * Runnable
         * Callable
         *
         * Here we use Callable.
         */

        Future<String> future = executor.submit(() -> {

            Thread.sleep(1000);

            return "Task-3 Completed Successfully";

        });

        /*
         * Since both core workers are busy,
         * Task-3 is NOT executed immediately.
         *
         * It is placed into the BlockingQueue.
         */

        System.out.println();
        System.out.println("After Task Submission");
        System.out.println("----------------------------");

        System.out.println("Pool Size      : " + executor.getPoolSize());
        System.out.println("Active Threads : " + executor.getActiveCount());
        System.out.println("Queue Size     : " + executor.getQueue().size());

        /*
         * future.get()
         *
         * Waits until Callable finishes.
         */

        System.out.println();
        System.out.println(future.get());

        /*
         * shutdown()
         *
         * Pool stops accepting
         * NEW tasks.
         *
         * Existing tasks continue.
         */

        executor.shutdown();

        executor.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println();
        System.out.println("Pool Finished");
    }
}
