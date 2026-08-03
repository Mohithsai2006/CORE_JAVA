
//execute() Internal Algorithm (Core vs Queue vs Max vs Reject)
package D13_ConcurrentPackageInjava.cThreadpoolExecutor;
import java.util.concurrent.*;

public class Demo2 {

    public static void main(String[] args) {

        /*
         * Configuration
         *
         * Core Threads = 2
         * Maximum Threads = 4
         * Queue Capacity = 2
         *
         * We will submit 7 tasks.
         *
         * Observe carefully how
         * ThreadPoolExecutor behaves.
         */

        ThreadPoolExecutor executor =
                new ThreadPoolExecutor(
                        2,
                        4,
                        30,
                        TimeUnit.SECONDS,
                        new ArrayBlockingQueue<>(2)
                );

        /*
         * Submit more tasks than the pool
         * can immediately execute.
         */

        for (int i = 1; i <= 7; i++) {

            final int taskNo = i;

            try {

                executor.execute(() -> {

                    System.out.println(
                            Thread.currentThread().getName()
                                    + " started Task-" + taskNo);

                    try {

                        /*
                         * Sleep keeps workers busy.
                         *
                         * This allows us to observe
                         * queueing and extra worker creation.
                         */

                        Thread.sleep(5000);

                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

                    System.out.println(
                            Thread.currentThread().getName()
                                    + " completed Task-" + taskNo);

                });

                /*
                 * Print current pool status
                 * after every submission.
                 */

                System.out.println("--------------------------------");

                System.out.println("Submitted Task-" + taskNo);

                System.out.println("Current Pool Size : "
                        + executor.getPoolSize());

                System.out.println("Active Threads    : "
                        + executor.getActiveCount());

                System.out.println("Queue Size        : "
                        + executor.getQueue().size());

            }

            catch (RejectedExecutionException e) {

                /*
                 * Pool reached:
                 *
                 * Maximum workers
                 * +
                 * Queue full
                 *
                 * Therefore task is rejected.
                 */

                System.out.println();

                System.out.println("Task-" + taskNo
                        + " Rejected");

                System.out.println("--------------------------------");

            }

        }

        executor.shutdown();
    }
}
