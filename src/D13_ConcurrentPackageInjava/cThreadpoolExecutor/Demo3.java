//Pool Lifecycle (shutdown(), shutdownNow(), awaitTermination())
package D13_ConcurrentPackageInjava.cThreadpoolExecutor;
import java.util.List;
import java.util.concurrent.*;

public class Demo3 {

    public static void main(String[] args) {

        /*
         * Configuration
         *
         * Core Threads    : 2
         * Maximum Threads : 4
         * Queue           : 3
         *
         * Goal of this demo
         *
         * 1. shutdown()
         * 2. shutdownNow()
         * 3. awaitTermination()
         * 4. isShutdown()
         * 5. isTerminated()
         */

        ThreadPoolExecutor executor =
                new ThreadPoolExecutor(
                        2,
                        4,
                        20,
                        TimeUnit.SECONDS,
                        new ArrayBlockingQueue<>(3)
                );

        /*
         * Submit 5 tasks.
         *
         * First two tasks start immediately.
         * Remaining tasks wait in queue.
         */

        for (int i = 1; i <= 5; i++) {

            final int taskNo = i;

            executor.execute(() -> {

                System.out.println(Thread.currentThread().getName()
                        + " started Task-" + taskNo);

                try {

                    /*
                     * Long running task.
                     * Gives enough time to observe
                     * shutdown behaviour.
                     */

                    Thread.sleep(5000);

                } catch (InterruptedException e) {

                    /*
                     * shutdownNow() interrupts workers.
                     *
                     * If interruption happens while
                     * thread is sleeping, execution
                     * reaches this block.
                     */

                    System.out.println(Thread.currentThread().getName()
                            + " interrupted while executing Task-" + taskNo);

                    Thread.currentThread().interrupt();
                }

                System.out.println(Thread.currentThread().getName()
                        + " finished Task-" + taskNo);

            });

        }

        System.out.println("\n==============================");
        System.out.println("Calling shutdown()");
        System.out.println("==============================");

        /*
         * shutdown()
         *
         * Internal Pool State
         *
         * RUNNING
         *      ↓
         * SHUTDOWN
         *
         * Existing workers continue.
         * Queued tasks continue.
         * New tasks are NOT accepted.
         */

        executor.shutdown();

        System.out.println("Is Shutdown   : " + executor.isShutdown());
        System.out.println("Is Terminated : " + executor.isTerminated());

        /*
         * Trying to submit another task.
         *
         * Since pool is already in
         * SHUTDOWN state,
         * execute() throws
         * RejectedExecutionException.
         */

        try {

            executor.execute(() ->
                    System.out.println("New Task"));

        } catch (RejectedExecutionException e) {

            System.out.println("\nNew Task Rejected");
        }

        try {

            /*
             * awaitTermination()
             *
             * Main thread waits here until
             *
             * 1. Pool terminates
             * OR
             * 2. Timeout expires
             */

            boolean completed =
                    executor.awaitTermination(30, TimeUnit.SECONDS);

            System.out.println();
            System.out.println("Completed Within Time : "
                    + completed);

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();
        }

        System.out.println();

        System.out.println("Is Shutdown   : "
                + executor.isShutdown());

        System.out.println("Is Terminated : "
                + executor.isTerminated());



        /*
         * ===================================================
         * shutdownNow()
         * ===================================================
         */

        System.out.println("\n==============================");
        System.out.println("shutdownNow() Example");
        System.out.println("==============================");

        ThreadPoolExecutor executor2 =
                new ThreadPoolExecutor(
                        2,
                        4,
                        20,
                        TimeUnit.SECONDS,
                        new ArrayBlockingQueue<>(5)
                );

        for (int i = 1; i <= 8; i++) {

            final int taskNo = i;

            executor2.execute(() -> {

                System.out.println(Thread.currentThread().getName()
                        + " executing Task-" + taskNo);

                try {

                    Thread.sleep(10000);

                } catch (InterruptedException e) {

                    /*
                     * Worker receives interrupt.
                     */

                    System.out.println(Thread.currentThread().getName()
                            + " interrupted.");

                    Thread.currentThread().interrupt();
                }

            });

        }

        /*
         * shutdownNow()
         *
         * Pool State
         *
         * RUNNING
         *      ↓
         * STOP
         *
         * Behaviour
         *
         * 1. Interrupt running workers.
         * 2. Remove queued tasks.
         * 3. Return queued tasks.
         */

        List<Runnable> pendingTasks =
                executor2.shutdownNow();

        System.out.println();

        System.out.println("Tasks removed from Queue : "
                + pendingTasks.size());

    }

}