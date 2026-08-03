package D12_Multithreadinginjava.bthreadscreation;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class dCallableFuture {

    public static void main(String[] args) throws Exception {

        System.out.println("Main Thread Started");

        // Create a Thread Pool with one worker thread.
        ExecutorService executor =
                Executors.newSingleThreadExecutor();

        // Create Callable Task.
        Callable<Integer> task = () -> {

            System.out.println("Current Thread : "
                    + Thread.currentThread().getName());

            System.out.println("Performing Calculation...");

            Thread.sleep(3000);

            return 100;
        };

        // Submit task to ExecutorService.
        Future<Integer> future = executor.submit(task);

        System.out.println("Main Thread continues...");

        // Wait until task completes.
        Integer result = future.get();

        System.out.println("Returned Value = " + result);

        // Shutdown Thread Pool.
        executor.shutdown();

        System.out.println("Program Finished");
    }
}
