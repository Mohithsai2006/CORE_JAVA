//Complete ThreadPoolExecutor Internal Working

package D13_ConcurrentPackageInjava.cThreadpoolExecutor;
import java.util.concurrent.*;
public class Demo5 {
    public static void main(String[] args) throws Exception {

        /*
         * ============================================================
         *              ThreadPoolExecutor Configuration
         * ============================================================
         *
         * corePoolSize    = 2
         * maximumPoolSize = 4
         * keepAliveTime   = 10 Seconds
         * Queue Capacity  = 2
         *
         * ------------------------------------------------------------
         * Initially
         * ------------------------------------------------------------
         *
         * Worker Count = 0
         * Queue = Empty
         * Pool State = RUNNING
         *
         * IMPORTANT
         *
         * Creating ThreadPoolExecutor DOES NOT create workers.
         *
         * Workers are created lazily
         * when execute()/submit() receives tasks.
         */

        ThreadPoolExecutor executor =
                new ThreadPoolExecutor(

                        2,
                        4,
                        10,
                        TimeUnit.SECONDS,

                        new ArrayBlockingQueue<>(2)

                );



        /*
         * ============================================================
         *              Initial Pool Information
         * ============================================================
         */

        System.out.println("\n========== INITIAL STATE ==========");

        printStatus(executor);



        /*
         * ============================================================
         * Submit 8 Tasks
         * ============================================================
         *
         * Configuration
         *
         * Core = 2
         * Max = 4
         * Queue = 2
         *
         * Expected Internal Behaviour
         *
         * Task1
         * -----
         * Worker-1 Created
         *
         * Task2
         * -----
         * Worker-2 Created
         *
         * Task3
         * -----
         * Queue
         *
         * Task4
         * -----
         * Queue
         *
         * Task5
         * -----
         * Queue Full
         *
         * Worker-3 Created
         *
         * Task6
         * -----
         * Worker-4 Created
         *
         * Task7
         * -----
         * Queue Full
         * Max Workers Reached
         *
         * Rejected
         *
         * Task8
         * -----
         * Rejected
         */

        for (int i = 1; i <= 8; i++) {

            final int taskNumber = i;

            try {

                executor.execute(() -> {

                    System.out.println(
                            "\n"
                                    + Thread.currentThread().getName()
                                    + " STARTED Task-"
                                    + taskNumber);

                    try {

                        /*
                         * Sleep keeps worker busy.
                         *
                         * This allows execute()
                         * to create more workers
                         * or queue incoming tasks.
                         */

                        Thread.sleep(5000);

                    }

                    catch (InterruptedException e) {

                        System.out.println(
                                Thread.currentThread().getName()
                                        + " Interrupted");

                        Thread.currentThread().interrupt();
                    }

                    System.out.println(
                            Thread.currentThread().getName()
                                    + " FINISHED Task-"
                                    + taskNumber);

                });

            }

            catch (RejectedExecutionException e) {

                /*
                 * execute() reaches here when
                 *
                 * Queue is FULL
                 *
                 * AND
                 *
                 * Worker Count == maximumPoolSize
                 */

                System.out.println("\nTask-"
                        + taskNumber
                        + " REJECTED");

            }

            /*
             * Wait a little after each submission.
             *
             * Makes output easier to understand.
             */

            Thread.sleep(500);

            System.out.println();

            System.out.println("Submitted Task-" + taskNumber);

            printStatus(executor);

        }



        /*
         * ============================================================
         * Worker Reuse
         * ============================================================
         *
         * Observe console carefully.
         *
         * Example
         *
         * pool-1-thread-1
         *
         * executes
         *
         * Task1
         *
         * Later
         *
         * Same Worker
         *
         * executes
         *
         * Task3
         *
         * Java DOES NOT create
         * a new thread.
         *
         * Existing workers
         * are reused.
         */




        /*
         * ============================================================
         * Wait before shutdown.
         * ============================================================
         */

        Thread.sleep(15000);



        /*
         * ============================================================
         * Current Pool Statistics
         * ============================================================
         */

        System.out.println("\n========== AFTER EXECUTION ==========");

        printStatus(executor);



        /*
         * ============================================================
         * Shutdown
         * ============================================================
         *
         * Pool State
         *
         * RUNNING
         *
         * ↓
         *
         * SHUTDOWN
         *
         * Existing Tasks
         *
         * Continue
         *
         * New Tasks
         *
         * Rejected
         */

        executor.shutdown();



        /*
         * Wait until
         *
         * All workers finish.
         */

        executor.awaitTermination(

                1,

                TimeUnit.MINUTES

        );



        /*
         * ============================================================
         * Final Statistics
         * ============================================================
         */

        System.out.println("\n========== FINAL STATE ==========");

        printStatus(executor);



        /*
         * ============================================================
         * keepAliveTime
         * ============================================================
         *
         * Since
         *
         * Core = 2
         *
         * Max = 4
         *
         * Worker3 and Worker4
         * are NON-CORE workers.
         *
         * After becoming idle
         *
         * Java waits
         *
         * keepAliveTime
         *
         * then removes them.
         *
         * Core workers remain alive
         * until pool terminates.
         */

    }



    /*
     * ==============================================================
     * Utility Method
     * ==============================================================
     *
     * Prints current ThreadPoolExecutor statistics.
     */

    private static void printStatus(ThreadPoolExecutor executor) {

        System.out.println("---------------------------------------");

        System.out.println("Pool Size           : "
                + executor.getPoolSize());

        System.out.println("Core Pool Size      : "
                + executor.getCorePoolSize());

        System.out.println("Maximum Pool Size   : "
                + executor.getMaximumPoolSize());

        System.out.println("Active Threads      : "
                + executor.getActiveCount());

        System.out.println("Queue Size          : "
                + executor.getQueue().size());

        System.out.println("Completed Tasks     : "
                + executor.getCompletedTaskCount());

        System.out.println("Total Submitted     : "
                + executor.getTaskCount());

        System.out.println("Largest Pool Size   : "
                + executor.getLargestPoolSize());

        System.out.println("Shutdown            : "
                + executor.isShutdown());

        System.out.println("Terminated          : "
                + executor.isTerminated());

        System.out.println("---------------------------------------");
    }

}
