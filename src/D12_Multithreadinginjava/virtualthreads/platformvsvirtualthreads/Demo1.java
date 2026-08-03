package D12_Multithreadinginjava.virtualthreads.platformvsvirtualthreads;

public class Demo1{

    public static void main(String[] args) throws InterruptedException {

        System.out.println("========== PLATFORM THREADS ==========\n");

        // ---------------- PLATFORM THREAD ----------------
        // Every platform thread is mapped 1 : 1 with an OS Thread.
        // JVM requests the Operating System to create a native thread.
        // Native Thread gets:
        //      • Native Stack
        //      • Registers
        //      • Thread Control Block (TCB)
        //      • Scheduler Entry
        //      • Kernel Resources
        //
        // Mapping:
        //
        // Java Thread
        //      │
        //      ▼
        // Native(OS) Thread
        //      │
        //      ▼
        // CPU

        Runnable platformTask = () -> {

            System.out.println("-------------------------------------");
            System.out.println("Current Thread : " + Thread.currentThread());
            System.out.println("Is Virtual     : " + Thread.currentThread().isVirtual());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }

            System.out.println(Thread.currentThread().getName() + " Finished\n");
        };

        Thread p1 = new Thread(platformTask, "Platform-1");
        Thread p2 = new Thread(platformTask, "Platform-2");

        p1.start();
        p2.start();

        p1.join();
        p2.join();

        System.out.println("\n========== VIRTUAL THREADS ==========\n");

        // ---------------- VIRTUAL THREAD ----------------
        //
        // Virtual Thread is NOT permanently mapped to an OS Thread.
        //
        // Virtual Thread
        //        │
        //        ▼
        // JVM Scheduler
        //        │
        //        ▼
        // Carrier Thread (Platform Thread)
        //        │
        //        ▼
        // CPU

        Runnable virtualTask = () -> {

            System.out.println("-------------------------------------");
            System.out.println("Current Thread : " + Thread.currentThread());
            System.out.println("Is Virtual     : " + Thread.currentThread().isVirtual());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }

            System.out.println(Thread.currentThread().getName() + " Finished\n");
        };

        Thread v1 = Thread.ofVirtual().name("Virtual-1").start(virtualTask);
        Thread v2 = Thread.ofVirtual().name("Virtual-2").start(virtualTask);

        v1.join();
        v2.join();

        System.out.println("\nProgram Finished");
    }
}