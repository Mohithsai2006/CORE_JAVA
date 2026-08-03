package D12_Multithreadinginjava.jThreadLocal;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class ThreadLocalMemoryLeakDemo {
    // ------------------------------------------------------
    // ThreadPool reuses Worker Threads.
    //
    // Worker-1
    //
    // Task-1
    //      ↓
    // ThreadLocal = Alice
    //
    // Task Finished
    //
    // Worker returned to pool
    //
    // Task-2
    //      ↓
    // Same Worker executes again
    //
    // ThreadLocal STILL contains Alice !!
    //
    // This demonstrates why remove()
    // must always be called.
    // ------------------------------------------------------

    private static final ThreadLocal<String> currentUser =
            new ThreadLocal<>();

    public static void main(String[] args)
            throws Exception {

        ExecutorService executor =
                Executors.newFixedThreadPool(1);

        // -------------------------------------------------
        // TASK-1
        // -------------------------------------------------

        executor.submit(() -> {

            System.out.println("\n========== TASK-1 ==========");

            currentUser.set("Alice");

            System.out.println(
                    "Current User : "
                            + currentUser.get());

            // remove() intentionally skipped.

            System.out.println(
                    "Task-1 Finished");
        }).get();

        // -------------------------------------------------
        // TASK-2
        // -------------------------------------------------

        executor.submit(() -> {

            System.out.println("\n========== TASK-2 ==========");

            // Nobody set value here.

            System.out.println(
                    "Unexpected Value : "
                            + currentUser.get());

            System.out.println(
                    "\nOops!!");

            System.out.println(
                    "Worker Thread reused.");

            System.out.println(
                    "Old ThreadLocal value leaked.");

            // Correct cleanup.

            currentUser.remove();

        }).get();

        // -------------------------------------------------
        // TASK-3
        // -------------------------------------------------

        executor.submit(() -> {

            System.out.println("\n========== TASK-3 ==========");

            System.out.println(
                    "After remove() : "
                            + currentUser.get());

        }).get();

        executor.shutdown();
    }
}