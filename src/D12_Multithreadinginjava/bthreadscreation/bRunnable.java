package D12_Multithreadinginjava.bthreadscreation;
// Step 1
// Create a class implementing Runnable.
class MyTask implements Runnable {

    // Work to be executed by Thread.
    @Override
    public void run() {

        System.out.println("Current Thread : " +
                Thread.currentThread().getName());

        for (int i = 1; i <= 5; i++) {
            System.out.println("Runnable Task : " + i);
        }
    }
}

public class bRunnable {

    public static void main(String[] args) {

        System.out.println("Main Thread Started");

        // Step 2
        // Create Runnable object.
        MyTask task = new MyTask();

        // Step 3
        // Pass Runnable to Thread.
        Thread t = new Thread(task);

        // Step 4
        // Start new thread.
        t.start();

        // Main Thread work.
        for (int i = 1; i <= 5; i++) {
            System.out.println("Main Thread : " + i);
        }

        System.out.println("Main Thread Finished");
    }
}