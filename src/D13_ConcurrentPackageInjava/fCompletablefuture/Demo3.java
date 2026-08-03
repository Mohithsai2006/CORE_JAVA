package D13_ConcurrentPackageInjava.fCompletablefuture;
import java.util.concurrent.CompletableFuture;
/*
 * =============================================================================
 * Demo 3
 * -----------------------------------------------------------------------------
 * Methods Covered
 * -----------------------------------------------------------------------------
 * 1) exceptionally()
 * 2) handle()
 * 3) allOf()
 * 4) anyOf()

 * =============================================================================
 *
 * PART-1
 * Exception Handling
 *
 * Database
 *      |
 *      |
 * Exception Occurred
 *      |
 * ----------------------------
 * |                          |
 * exceptionally()         handle()
 * |                          |
 * Default Value         Success/Failure
 *
 * =============================================================================
 *
 * PART-2
 *
 * allOf()
 *
 * Service-A
 * Service-B
 * Service-C
 *
 * Wait Until ALL Finish
 *
 * =============================================================================
 *
 * PART-3
 *
 * anyOf()
 *
 * Server-A
 * Server-B
 * Server-C
 *
 * Fastest Server Wins
 *
 * =============================================================================
 */
public class Demo3 {
    public static void main(String[] args) {
        System.out.println("Main Thread : "
                + Thread.currentThread().getName());
        /*
         * =====================================================================
         * PART-1
         *
         * exceptionally()
         *
         * =====================================================================
         *
         * Imagine a database query.
         *
         * During execution an exception occurs.
         *
         * Instead of terminating the pipeline,
         * exceptionally() supplies a DEFAULT VALUE.
         */
        CompletableFuture<String> employeeFuture =
                CompletableFuture
                        .supplyAsync(() -> {
                            System.out.println("\nReading Employee...");
                            /*
                             * Simulating Database Failure.
                             */
                            int x = 10 / 0;
                            return "Mohith";
                        })
                        /*
                         * =========================================================
                         * exceptionally()
                         *
                         * Executes ONLY when an exception occurs.
                         *
                         * Receives
                         *
                         * Throwable
                         *
                         * Returns
                         *
                         * Fallback Value.
                         *
                         * If NO exception occurs,
                         * this stage is completely skipped.
                         * =========================================================
                         */
                        .exceptionally(ex -> {

                            System.out.println(
                                    "\nException Handled.");

                            System.out.println(
                                    "Reason : "
                                            + ex.getMessage());

                            return "Default Employee";

                        })
                        /*
                         * Receives either
                         *
                         * Original Result
                         *
                         * OR
                         *
                         * Fallback Result.
                         */
                        .thenApply(name -> {

                            return "Employee = " + name;
                        });
                        /*
         * =====================================================================
         * handle()
         * =====================================================================
         *
         * Unlike exceptionally()
         *
         * handle() ALWAYS executes.
         *
         * It receives BOTH
         *
         * Result
         *
         * Exception
         *
         * Therefore it can process
         *
         * Success
         *
         * and
         *
         * Failure
         */
        CompletableFuture<String> marksFuture =

                CompletableFuture

                        .supplyAsync(() -> {

                            System.out.println(
                                    "\nCalculating Marks...");

                            return 95;

                        })

                        .handle((marks, ex) -> {

                            /*
                             * If exception occurred
                             */

                            if (ex != null) {

                                return "Calculation Failed";

                            }

                            /*
                             * Successful result.
                             */

                            return "Marks = " + marks;

                        });

        /*
         * =====================================================================
         * PART-2
         *
         * allOf()
         *
         * =====================================================================
         *
         * Imagine
         *
         * Three independent microservices.
         *
         * Customer Service
         * Product Service
         * Payment Service
         *
         * Dashboard can be shown ONLY AFTER
         * every service finishes.
         */

        CompletableFuture<String> service1 =

                CompletableFuture.supplyAsync(() -> {

                    System.out.println("\nCustomer Service");

                    sleep(3000);

                    return "Customer Loaded";

                });

        CompletableFuture<String> service2 =

                CompletableFuture.supplyAsync(() -> {

                    System.out.println("Product Service");

                    sleep(2000);

                    return "Products Loaded";

                });

        CompletableFuture<String> service3 =

                CompletableFuture.supplyAsync(() -> {

                    System.out.println("Payment Service");

                    sleep(4000);

                    return "Payments Loaded";

                });

        /*
         * =========================================================
         * allOf()
         *
         * Waits until
         *
         * EVERY CompletableFuture
         *
         * completes.
         *
         * Returns
         *
         * CompletableFuture<Void>
         *
         * because it represents
         *
         * completion
         *
         * not combined results.
         * =========================================================
         */

        CompletableFuture<Void> allServices =

                CompletableFuture

                        .allOf(service1,
                                service2,
                                service3)

                        .thenRun(() -> {

                            System.out.println(
                                    "\nAll Services Completed.");

                        });

        /*
         * =====================================================================
         * PART-3
         *
         * anyOf()
         *
         * =====================================================================
         *
         * Three mirror servers.
         *
         * User only needs
         *
         * FIRST RESPONSE.
         */

        CompletableFuture<String> server1 =

                CompletableFuture.supplyAsync(() -> {

                    sleep(5000);

                    return "Server-1";

                });

        CompletableFuture<String> server2 =

                CompletableFuture.supplyAsync(() -> {

                    sleep(2000);

                    return "Server-2";

                });

        CompletableFuture<String> server3 =

                CompletableFuture.supplyAsync(() -> {

                    sleep(4000);

                    return "Server-3";

                });

        /*
         * =========================================================
         * anyOf()
         *
         * Returns immediately when
         * FIRST future completes.
         *
         * Remaining futures continue running.
         *
         * They are NOT cancelled automatically.
         * =========================================================
         */

        CompletableFuture<Object> fastestServer =

                CompletableFuture

                        .anyOf(server1,
                                server2,
                                server3)

                        .thenApply(server -> {

                            return "Fastest Response : "
                                    + server;

                        });

        /*
         * =========================================================
         * join()
         *
         * Wait for all asynchronous pipelines.
         * =========================================================
         */

        System.out.println("\n"
                + employeeFuture.join());

        System.out.println(
                marksFuture.join());

        allServices.join();

        System.out.println(
                fastestServer.join());

        System.out.println("\nMain Thread Finished.");
    }

    /*
     * Utility Method
     *
     * Simulates long-running operations.
     */

    private static void sleep(int ms) {

        try {

            Thread.sleep(ms);

        }
        catch (InterruptedException e) {

            e.printStackTrace();
        }

    }
}
