package D13_ConcurrentPackageInjava.fCompletablefuture;
import java.util.concurrent.CompletableFuture;
/*
 * =============================================================================
 * Demo 1
 * -----------------------------------------------------------------------------
 * This demo explains the basic workflow of CompletableFuture.
 *
 * Methods Covered
 * ----------------
 * 1) supplyAsync()
 * 2) runAsync()
 * 3) thenApply()
 * 4) thenAccept()
 * -----------------------------------------------------------------------------
 * Flow
 *
 * Main Thread
 *      |
 *      |
 * supplyAsync()
 *      |
 * ForkJoinPool Worker Thread
 *      |
 * Reads Employee Name
 *      |
 * thenApply()
 *      |
 * Converts Name -> Uppercase
 *      |
 * thenApply()
 *      |
 * Adds Welcome Message
 *      |
 * thenAccept()
 *      |
 * Prints Final Result
 *
 * Meanwhile...
 *
 * runAsync()
 *
 * Executes another background task that returns nothing.
 *
 * =============================================================================
 */

public class Demo1 {

    public static void main(String[] args) {

        System.out.println("Main Thread Started : "
                + Thread.currentThread().getName());

        /*
         * =========================================================================
         * supplyAsync()
         * =========================================================================
         *
         * Definition
         * ----------
         * Starts an asynchronous computation that RETURNS a value.
         *
         * Internally
         * ----------
         *
         * CompletableFuture
         *         |
         *         |
         * ForkJoinPool.commonPool()
         *         |
         *         |
         * Worker Thread executes Supplier.get()
         *
         * Since we did NOT provide an Executor,
         * Java automatically uses
         *
         * ForkJoinPool.commonPool()
         *
         * This is a shared thread pool available to the JVM.
         *
         * Main Thread DOES NOT WAIT.
         *
         * It immediately receives a CompletableFuture object.
         */

        CompletableFuture<Void> employeeFuture =

                CompletableFuture.supplyAsync(() -> {

                            System.out.println("\nReading Employee Name...");
                            System.out.println("Executed by : "
                                    + Thread.currentThread().getName());

                            /*
                             * Simulating database access.
                             *
                             * Worker Thread enters
                             * TIMED_WAITING state.
                             */

                            try {
                                Thread.sleep(2000);
                            }
                            catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            /*
                             * Supplier.get()
                             *
                             * Returns Employee Name.
                             *
                             * CompletableFuture internally stores
                             * this String as the result of Stage-1.
                             */

                            return "Mohith";

                        })

                        /*
                         * =========================================================================
                         * thenApply()
                         * =========================================================================
                         *
                         * Definition
                         * ----------
                         * Transforms previous result into another value.
                         *
                         * Think of it like
                         *
                         *      map()
                         *
                         * in Streams.
                         *
                         * Previous Result
                         * ----------------
                         * Mohith
                         *
                         * New Result
                         * -----------
                         * MOHITH
                         *
                         * IMPORTANT
                         * ----------
                         * thenApply() executes ONLY AFTER
                         * supplyAsync() completes.
                         *
                         * It automatically receives the previous result.
                         */

                        .thenApply(name -> {

                            System.out.println("\nConverting to Uppercase...");
                            System.out.println("Executed by : "
                                    + Thread.currentThread().getName());

                            return name.toUpperCase();

                        })

                        /*
                         * =========================================================================
                         * Another thenApply()
                         * =========================================================================
                         *
                         * Previous Result
                         *
                         * MOHITH
                         *
                         * New Result
                         *
                         * Welcome MOHITH
                         *
                         * Every thenApply()
                         * creates a NEW CompletableFuture internally.
                         *
                         * Stage-1
                         *      |
                         * Stage-2
                         *      |
                         * Stage-3
                         */

                        .thenApply(name -> {

                            System.out.println("\nPreparing Welcome Message...");
                            System.out.println("Executed by : "
                                    + Thread.currentThread().getName());

                            return "Welcome " + name
                                    + " to CompletableFuture";

                        })

                        /*
                         * =========================================================================
                         * thenAccept()
                         * =========================================================================
                         *
                         * Consumes previous result.
                         *
                         * Difference
                         *
                         * thenApply()
                         *      returns another value
                         *
                         * thenAccept()
                         *      returns NOTHING
                         *
                         * Consumer.accept()
                         * simply performs some action.
                         *
                         * Examples
                         * --------
                         * Printing
                         * Saving
                         * Sending Email
                         * Logging
                         */

                        .thenAccept(message -> {

                            System.out.println("\nPrinting Final Message...");
                            System.out.println("Executed by : "
                                    + Thread.currentThread().getName());

                            System.out.println(message);

                        });

        /*
         * =========================================================================
         * runAsync()
         * =========================================================================
         *
         * Definition
         * ----------
         * Starts an asynchronous task
         * WITHOUT returning any value.
         *
         * It accepts Runnable.
         *
         * Runnable.run()
         *
         * returns
         *
         * void
         *
         * Therefore
         *
         * CompletableFuture<Void>
         *
         * is returned.
         */

        CompletableFuture<Void> logFuture =

                CompletableFuture.runAsync(() -> {

                    System.out.println("\nSaving Log File...");
                    System.out.println("Executed by : "
                            + Thread.currentThread().getName());

                    try {

                        Thread.sleep(1500);

                    }
                    catch (InterruptedException e) {

                        e.printStackTrace();
                    }

                    System.out.println("Log Saved Successfully.");

                });

        /*
         * =========================================================================
         * Observe here...
         *
         * Main Thread is NOT blocked.
         *
         * Both asynchronous tasks
         * are executing in background.
         */

        System.out.println("\nMain Thread continues doing other work...");

        /*
         * =========================================================================
         * join()
         * =========================================================================
         *
         * Why join() ?
         *
         * If main() finishes immediately,
         * JVM may terminate before background tasks complete.
         *
         * join()
         *
         * waits until the CompletableFuture completes.
         *
         * Difference
         *
         * get()
         * -----
         * throws checked exceptions
         *
         * join()
         * -------
         * throws unchecked CompletionException
         *
         * Used more commonly in CompletableFuture pipelines.
         */

        employeeFuture.join();

        logFuture.join();

        System.out.println("\nMain Thread Finished.");
    }
}