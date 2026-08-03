package D13_ConcurrentPackageInjava.eFutureCallable;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/*
 * =============================================================================
 * LongTask
 * -----------------------------------------------------------------------------
 * Implements Callable<String>.
 *
 * This task simulates a long-running operation.
 *
 * Instead of completing immediately, it performs 10 steps,
 * sleeping for 1 second after every step.
 *
 * Total execution time ≈ 10 seconds.
 *
 * We will intentionally wait only 3 seconds in the Main Thread
 * and then cancel the task.
 *
 * This demonstrates:
 *      • FutureTask
 *      • get(timeout)
 *      • TimeoutException
 *      • cancel(true)
 *      • Thread interruption
 * =============================================================================
 */
class LongTask implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName()
                + " started LongTask\n");
        /*
         * Processing loop.
         *
         * Every iteration represents some heavy computation.
         */
        for (int i = 1; i <= 10; i++) {
            /*
             * Checks whether someone requested this thread
             * to stop execution.
             *
             * cancel(true)
             *
             * ---------> interrupt()
             *                 |
             *                 |
             *      Interrupt Flag becomes TRUE
             *
             * isInterrupted() simply reads that flag.
             *
             * If TRUE,
             * stop gracefully instead of continuing.
             */
            if (Thread.currentThread().isInterrupted()) {

                System.out.println("\nInterrupt signal received.");
                System.out.println("Cleaning resources...");
                System.out.println("Task terminated safely.\n");

                return "Task Cancelled";
            }

            System.out.println("Processing Step : " + i);

            /*
             * Simulates lengthy work.
             *
             * Current Worker Thread enters
             * TIMED_WAITING state.
             *
             * Important:
             * ----------
             * sleep() is interruptible.
             *
             * If cancel(true) happens during sleep(),
             * JVM immediately throws InterruptedException.
             */
            Thread.sleep(1000);
        }

        /*
         * Returned only if task completes successfully.
         *
         * FutureTask internally stores this String.
         */
        return "Task Completed Successfully";
    }
}

public class Demo2 {

    public static void main(String[] args) {

        /*
         * =========================================================================
         * STEP 1
         * Create Callable object.
         *
         * Heap
         *
         * +------------------+
         * | LongTask Object  |
         * +------------------+
         * =========================================================================
         */
        Callable<String> callable = new LongTask();

        /*
         * =========================================================================
         * STEP 2
         *
         * Wrap Callable inside FutureTask.
         *
         * Why?
         *
         * Thread accepts ONLY Runnable.
         *
         * Callable cannot directly be passed to Thread.
         *
         * FutureTask solves this problem because
         * it implements BOTH
         *
         * Runnable
         * Future
         *
         * Internally
         *
         * Callable
         *      |
         * FutureTask
         *      |
         * Runnable + Future
         * =========================================================================
         */
        FutureTask<String> futureTask =
                new FutureTask<>(callable);

        /*
         * =========================================================================
         * STEP 3
         *
         * Thread can execute FutureTask
         * because FutureTask implements Runnable.
         *
         * Thread
         *      |
         * FutureTask.run()
         *      |
         * call()
         * =========================================================================
         */
        Thread worker =
                new Thread(futureTask, "Worker-Thread");

        /*
         * Starts worker thread.
         *
         * Main Thread immediately continues.
         */
        worker.start();

        try {

            System.out.println("Main Thread waiting only 3 seconds...\n");

            /*
             * =========================================================================
             * get(timeout)
             *
             * Main Thread waits only for
             * 3 seconds.
             *
             * If task finishes before 3 seconds,
             * result is returned.
             *
             * Otherwise
             *
             * TimeoutException is thrown.
             *
             * Worker Thread CONTINUES RUNNING.
             *
             * NOTE:
             * get(timeout) DOES NOT stop the task.
             * It only stops waiting.
             * =========================================================================
             */
            String result =
                    futureTask.get(3, TimeUnit.SECONDS);

            System.out.println(result);

        }
        catch (TimeoutException e) {

            System.out.println("\nTimeout occurred.");
            System.out.println("Task still running.");

            /*
             * =========================================================================
             * cancel(true)
             *
             * TRUE means:
             *
             * "Interrupt the Worker Thread
             * if it is already running."
             *
             * Internally
             *
             * FutureTask
             *       |
             * interrupt(workerThread)
             *       |
             * Interrupt Flag = TRUE
             *
             * If Worker Thread is sleeping,
             * sleep() throws InterruptedException.
             *
             * Future State
             *
             * RUNNING
             *      |
             * CANCELLED
             * =========================================================================
             */
            boolean cancelled =
                    futureTask.cancel(true);

            System.out.println("Cancellation Requested : "
                    + cancelled);
        }

        /*
         * sleep() throws InterruptedException
         * after cancel(true).
         */
        catch (InterruptedException e) {

            System.out.println("Main Thread interrupted.");
        }

        /*
         * FutureTask.get()
         * wraps exceptions inside ExecutionException.
         */
        catch (Exception e) {

            System.out.println(e);
        }

        System.out.println();

        /*
         * Checks whether cancellation succeeded.
         */
        System.out.println("isCancelled() : "
                + futureTask.isCancelled());

        /*
         * Returns TRUE when task reaches
         *
         * COMPLETED
         * FAILED
         * CANCELLED
         *
         * Any terminal state.
         */
        System.out.println("isDone() : "
                + futureTask.isDone());

        /*
         * Wait a little so we can observe
         * worker thread output before JVM exits.
         */
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nMain Thread Finished.");
    }
}