//ExecutorService + submit() + Future + shutdown() + awaitTermination()
package D13_ConcurrentPackageInjava.bExecutorFramework;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Demo1 {

    public static void main(String[] args) throws Exception {

        // ============================================================
        // STEP-1 : Create an ExecutorService
        // ============================================================
        //
        // Executors.newFixedThreadPool(2)
        //
        // Internally
        //
        //          ThreadPoolExecutor
        //                  │
        //        Worker-1 (Idle)
        //        Worker-2 (Idle)
        //
        // Queue
        // -----
        // Empty
        //
        // Pool State : RUNNING
        //
        // ============================================================

        ExecutorService executor = Executors.newFixedThreadPool(2);



        // Future stores task status/result.
        List<Future<String>> futures = new ArrayList<>();



        // ============================================================
        // STEP-2 : Submit Tasks
        // ============================================================
        //
        // submit()
        //
        // DOES NOT execute task directly.
        //
        // Internally
        //
        // Callable
        //      │
        // FutureTask Created
        //      │
        // execute(FutureTask)
        //      │
        // BlockingQueue
        //      │
        // Worker Thread executes FutureTask.run()
        //
        // ============================================================

        for (int i = 1; i <= 5; i++) {

            int taskId = i;

            Future<String> future = executor.submit(() -> {

                String thread = Thread.currentThread().getName();

                System.out.println(thread + " started Task-" + taskId);

                // Simulate some work.
                Thread.sleep(2000);

                System.out.println(thread + " completed Task-" + taskId);

                return "Result of Task-" + taskId;

            });

            futures.add(future);
        }

        System.out.println("\nMain : All Tasks Submitted\n");



        // ============================================================
        // STEP-3 : Graceful Shutdown
        // ============================================================
        //
        // Pool State
        //
        // RUNNING
        //      │
        // shutdown()
        //      │
        // SHUTDOWN
        //
        //
        // Internally
        //
        // ✔ No new tasks accepted.
        //
        // ✔ Running workers continue.
        //
        // ✔ Waiting tasks inside BlockingQueue
        //   will also execute.
        //
        // ✔ Idle workers are interrupted only so
        //   they wake up and check pool state.
        //
        // ============================================================

        executor.shutdown();



        // ============================================================
        // STEP-4 : Main Thread Waits
        // ============================================================
        //
        // Main Thread
        //
        //        WAITING
        //
        // Worker-1 ---------->
        // Worker-2 ---------->
        //
        // Queue
        //
        // Task3
        // Task4
        // Task5
        //
        // Workers continue executing.
        //
        // Queue Empty
        //      │
        // Worker Count = 0
        //      │
        // TIDYING
        //      │
        // TERMINATED
        //
        // awaitTermination()
        // returns TRUE
        //
        // ============================================================

        executor.awaitTermination(1, TimeUnit.MINUTES);



        // ============================================================
        // STEP-5 : Read Results
        // ============================================================
        //
        // Every Future already contains
        //
        // State
        // Result
        // Exception (if any)
        //
        // ============================================================

        System.out.println();

        for (Future<String> future : futures) {

            System.out.println(future.get());

        }

        System.out.println("\nMain Thread Ends");
    }
}