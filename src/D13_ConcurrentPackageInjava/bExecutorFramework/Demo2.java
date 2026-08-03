//shutdownNow() Complete Internal Working
package D13_ConcurrentPackageInjava.bExecutorFramework;
import java.util.List;
import java.util.concurrent.*;
public class Demo2 {
    public static void main(String[] args) throws Exception {
        // ============================================================
        // STEP-1 : Create Pool
        // ============================================================
        ExecutorService executor = Executors.newFixedThreadPool(2);
        // ============================================================
        // STEP-2 : Submit 5 Tasks
        //
        // Worker-1 ---> Task1
        // Worker-2 ---> Task2
        //
        // Queue
        // -----
        // Task3
        // Task4
        // Task5
        //
        // ============================================================
        for (int i = 1; i <= 5; i++) {
            int taskId = i;
            executor.submit(() -> {
                String thread = Thread.currentThread().getName();
                System.out.println(thread +
                        " picked Task-" + taskId);
                try {
                    // Long running task
                    for (int j = 1; j <= 10; j++) {
                        Thread.sleep(1000);
                        System.out.println(thread +
                                " Task-" + taskId + " Working..." + j);
                    }
                    System.out.println(thread +
                            " finished Task-" + taskId);
                }
                catch (InterruptedException e) {
                    // ====================================================
                    // shutdownNow()
                    //
                    // internally calls
                    //
                    // Thread.interrupt()
                    //
                    // InterruptedException is thrown because
                    // Thread.sleep() is interruptible.
                    //
                    // ====================================================
                    System.out.println(thread +
                            " interrupted while executing Task-" + taskId);
                }
            });
        }
        // Allow workers to start.
        Thread.sleep(3000);
        System.out.println("\n==============================");
        System.out.println("Calling shutdownNow()");
        System.out.println("==============================\n");
        // ============================================================
        // shutdownNow()
        //
        // Pool State
        //
        // RUNNING
        //      │
        // shutdownNow()
        //      │
        // STOP
        //
        //
        // Internally
        //
        // 1. Reject New Tasks
        //
        // 2. Interrupt ALL Workers
        //
        // 3. Remove Waiting Tasks
        //
        // 4. Return Waiting Tasks
        //
        // ===========================================================
        List<Runnable> pendingTasks = executor.shutdownNow();



        System.out.println();

        System.out.println("Pending Tasks Returned : "
                + pendingTasks.size());



        // ============================================================
        // Main waits until
        //
        // Worker Count = 0
        //
        // Pool
        //
        // TERMINATED
        //
        // ============================================================
        executor.awaitTermination(1, TimeUnit.MINUTES);
        System.out.println("\nExecutorService Terminated");
    }

}