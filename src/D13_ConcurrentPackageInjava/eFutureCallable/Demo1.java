package D13_ConcurrentPackageInjava.eFutureCallable;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/*
 * ============================================================================
 * SumTask
 * ----------------------------------------------------------------------------
 * Implements Callable<Integer>.
 *
 * Why Callable?
 * -------------
 * Runnable can execute a task but CANNOT return a value.
 *
 * Callable is introduced for:
 *      1. Returning a result
 *      2. Throwing checked exceptions
 *
 * ExecutorService executes call() internally and stores the returned value
 * inside a Future object.
 * ============================================================================
 */
class SumTask implements Callable<Integer> {

    private final int start;
    private final int end;

    public SumTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public Integer call() throws Exception {

        System.out.println(
                Thread.currentThread().getName()
                        + " started calculating "
                        + start + " to " + end);

        /*
         * Simulating a long-running calculation.
         *
         * During this sleep...
         * --------------------
         * Worker thread enters TIMED_WAITING state.
         *
         * Main thread DOES NOT wait because submit()
         * already returned a Future object.
         */
        Thread.sleep(3000);

        int sum = 0;

        /*
         * Actual computation.
         */
        for (int i = start; i <= end; i++) {
            sum += i;
        }

        System.out.println(
                Thread.currentThread().getName()
                        + " finished calculation.");

        /*
         * Returning result.
         *
         * ExecutorService internally captures this value
         * and stores it inside the corresponding Future object.
         *
         * Future State:
         *      RUNNING  ---> COMPLETED
         */
        return sum;
    }
}

/*
 * ============================================================================
 * DivideTask
 * ----------------------------------------------------------------------------
 * Generates an exception intentionally.
 *
 * ExecutorService catches this exception internally.
 *
 * Instead of directly throwing it to the main thread,
 * Future stores it.
 *
 * Later...
 *
 * future.get()
 *
 * throws
 *
 * ExecutionException
 *
 * whose cause is ArithmeticException.
 * ============================================================================
 */
class DivideTask implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {

        System.out.println(
                Thread.currentThread().getName()
                        + " executing DivideTask");

        Thread.sleep(1000);

        // Generates ArithmeticException
        return 10 / 0;
    }
}

public class Demo1 {

    public static void main(String[] args) {

        /*
         * Creates ThreadPool with 3 permanent worker threads.
         *
         * Internally:
         *
         * Heap
         * -------------------------
         * ExecutorService
         *      |
         * ThreadPoolExecutor
         *      |
         * -------------------------
         * Worker-1
         * Worker-2
         * Worker-3
         *
         * Initially all workers are idle waiting for tasks.
         */
        ExecutorService executor =
                Executors.newFixedThreadPool(3);

        /*
         * submit(task)
         *
         * Internally:
         *
         * 1) Creates Future object
         * 2) Places Callable inside BlockingQueue
         * 3) Worker thread picks task
         * 4) submit() IMMEDIATELY returns Future
         *
         * Main thread DOES NOT wait.
         */

        Future<Integer> future1 =
                executor.submit(new SumTask(1, 100));

        Future<Integer> future2 =
                executor.submit(new SumTask(101, 200));

        Future<Integer> future3 =
                executor.submit(new DivideTask());

        System.out.println("\nMain thread continues doing its own work...\n");

        /*
         * Polling Future objects.
         *
         * Future internally maintains a STATE.
         *
         * NEW
         * RUNNING
         * COMPLETED
         * FAILED
         * CANCELLED
         *
         * isDone() simply checks whether the state
         * reached any terminal state.
         */
        while (!(future1.isDone()
                && future2.isDone()
                && future3.isDone())) {

            System.out.println("Main Thread : Waiting...");

            try {
                Thread.sleep(500);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\nAll tasks finished.\n");

        try {

            /*
             * get()
             *
             * If result is already available,
             * returns immediately.
             *
             * Otherwise...
             *
             * Current thread blocks until
             * worker thread completes execution.
             */
            System.out.println("Sum 1 = "
                    + future1.get());

            System.out.println("Sum 2 = "
                    + future2.get());

            /*
             * DivideTask failed.
             *
             * Future contains:
             *
             * Result      -> null
             * Exception   -> ArithmeticException
             *
             * get()
             *
             * throws ExecutionException.
             */
            System.out.println("Division = "
                    + future3.get());

        }
        catch (ExecutionException e) {

            /*
             * Future wraps every exception inside
             * ExecutionException.
             *
             * getCause() returns the ORIGINAL exception.
             */
            System.out.println("\nTask Failed.");

            System.out.println("Original Exception : "
                    + e.getCause());

        }
        catch (InterruptedException e) {

            e.printStackTrace();
        }

        /*
         * Gracefully shuts down thread pool.
         *
         * No new tasks accepted.
         *
         * Existing tasks are allowed to finish.
         *
         * Worker threads terminate afterwards.
         */
        executor.shutdown();
    }
}