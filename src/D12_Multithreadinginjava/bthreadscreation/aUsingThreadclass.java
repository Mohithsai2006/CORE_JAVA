package D12_Multithreadinginjava.bthreadscreation;

// Step 1: Create a class that extends Thread
class MyThread extends Thread {

    // Step 2: Override run()
    // This method contains the work to be executed by the new thread.
    @Override
    public void run() {

        System.out.println("Current Thread : " +
                Thread.currentThread().getName());

        for (int i = 1; i <= 5; i++) {
            System.out.println("Child Thread : " + i);
        }
    }
}

public class aUsingThreadclass {

    public static void main(String[] args) {

        System.out.println("Main Thread Started");

        // Creates only the Thread object in Heap.
        // No new thread is created yet.
        MyThread t = new MyThread();

        // Creates a new thread.
        // JVM internally calls run().
        t.start();

        // Executed by Main Thread.
        for (int i = 1; i <= 5; i++) {
            System.out.println("Main Thread : " + i);
        }

        System.out.println("Main Thread Finished");
    }
}