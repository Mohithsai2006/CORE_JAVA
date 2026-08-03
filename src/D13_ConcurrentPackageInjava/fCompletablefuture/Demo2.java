package D13_ConcurrentPackageInjava.fCompletablefuture;
import java.util.concurrent.CompletableFuture;
/*
 * =============================================================================
 * Demo 2
 * -----------------------------------------------------------------------------
 * Methods Covered
 * ----------------
 * 1) thenCompose()
 * 2) thenCombine()
 *
 * =============================================================================
 *
 * PART-1 : thenCompose()
 * ----------------------
 *
 * Employee ID
 *      |
 *      |
 * Read Employee
 *      |
 *      |
 * Employee Object
 *      |
 *      |
 * Read Salary
 *      |
 *      |
 * Salary
 *
 * Notice that...
 *
 * Reading Salary depends on Employee.
 *
 * This is called
 *
 * DEPENDENT ASYNCHRONOUS TASK.
 *
 * =============================================================================
 *
 * PART-2 : thenCombine()
 * ----------------------
 *
 * Read Employee Name
 *
 * AND
 *
 * Read Department
 *
 * Both are completely independent.
 *
 * They execute simultaneously.
 *
 * After BOTH complete,
 *
 * Combine Results.
 *
 * =============================================================================
 */

public class Demo2 {

    public static void main(String[] args) {

        System.out.println("Main Thread : "
                + Thread.currentThread().getName());

        /*
         * =========================================================================
         * PART-1
         *
         * thenCompose()
         *
         * =========================================================================
         *
         * Step-1
         *
         * Read Employee.
         *
         * Imagine this is a Database Call.
         *
         * Result
         *
         * Employee ID
         *
         * 101
         *
         * This task returns a value.
         */

        CompletableFuture<Void> employeePipeline =

                CompletableFuture

                        .supplyAsync(() -> {

                            System.out.println("\nFetching Employee...");
                            System.out.println("Thread : "
                                    + Thread.currentThread().getName());

                            try {

                                Thread.sleep(2000);

                            }
                            catch (InterruptedException e) {

                                e.printStackTrace();
                            }

                            /*
                             * Supplier returns Employee Name.
                             */

                            return "Mohith";
                        })

                        /*
                         * =========================================================================
                         * thenCompose()
                         * =========================================================================
                         *
                         * Why NOT thenApply()?
                         *
                         * Suppose we use
                         *
                         * thenApply(name ->
                         *      CompletableFuture.supplyAsync(...))
                         *
                         * thenApply()
                         * simply returns whatever we return.
                         *
                         * Therefore
                         *
                         * CompletableFuture<
                         *      CompletableFuture<String>>
                         *
                         * becomes nested.
                         *
                         * We DO NOT want nested futures.
                         *
                         * thenCompose()
                         *
                         * automatically FLATTENS them.
                         *
                         * Similar to
                         *
                         * flatMap()
                         *
                         * in Streams.
                         */

                        .thenCompose(employee -> {

                            System.out.println("\nEmployee Found : "
                                    + employee);

                            System.out.println("Now fetching Salary...");

                            /*
                             * Salary depends on Employee.
                             *
                             * Therefore another asynchronous
                             * database call is started.
                             */

                            return CompletableFuture.supplyAsync(() -> {

                                System.out.println("Thread : "
                                        + Thread.currentThread().getName());

                                try {

                                    Thread.sleep(2000);

                                }
                                catch (InterruptedException e) {

                                    e.printStackTrace();
                                }

                                return "₹85,000";

                            });

                        })

                        /*
                         * =========================================================================
                         * thenApply()
                         *
                         * Receives Salary
                         * and prepares report.
                         *
                         * Previous Result
                         *
                         * ₹85,000
                         *
                         * New Result
                         *
                         * Salary Report
                         *
                         * Every thenApply()
                         * creates another CompletableFuture stage.
                         */

                        .thenApply(salary -> {

                            System.out.println("\nPreparing Salary Report...");

                            return "Employee Salary = " + salary;

                        })

                        /*
                         * Consumes final result.
                         */
                        .thenAccept(System.out::println);

        /*
         * =========================================================================
         * PART-2
         *
         * thenCombine()
         * =========================================================================
         *
         * Imagine
         *
         * Employee Table
         *
         * and
         *
         * Department Table
         *
         * They are unrelated.
         *
         * Both can execute simultaneously.
         */

        CompletableFuture<String> employeeName =

                CompletableFuture.supplyAsync(() -> {

                    System.out.println("\nFetching Employee Name...");
                    System.out.println("Thread : "
                            + Thread.currentThread().getName());

                    try {

                        Thread.sleep(3000);

                    }
                    catch (InterruptedException e) {

                        e.printStackTrace();
                    }

                    return "Mohith";

                });

        CompletableFuture<String> department =

                CompletableFuture.supplyAsync(() -> {

                    System.out.println("\nFetching Department...");
                    System.out.println("Thread : "
                            + Thread.currentThread().getName());

                    try {

                        Thread.sleep(2500);

                    }
                    catch (InterruptedException e) {

                        e.printStackTrace();
                    }

                    return "Java Development";

                });

        /*
         * =========================================================================
         * thenCombine()
         *
         * Waits until BOTH CompletableFutures finish.
         *
         * Internally
         *
         * Employee Future
         *          |
         *          |
         * Department Future
         *          |
         *          |
         * Wait for BOTH
         *          |
         * Combine Function Executes
         *
         * Unlike thenCompose(),
         * neither task depends on the other.
         */

        CompletableFuture<Void> combinePipeline =

                employeeName

                        .thenCombine(

                                department,

                                (emp, dept) -> {

                                    System.out.println(
                                            "\nCombining Results...");

                                    return emp
                                            + " works in "
                                            + dept;

                                })

                        /*
                         * Consume combined result.
                         */

                        .thenAccept(System.out::println);

        /*
         * =========================================================================
         * join()
         *
         * Wait for both pipelines.
         *
         * Otherwise JVM may terminate
         * before background threads complete.
         */

        employeePipeline.join();

        combinePipeline.join();

        System.out.println("\nMain Thread Finished.");
    }
}
