package D12_Multithreadinginjava.virtualthreads.mountingvsunmounting;


public class Demo2 {

    public static void main(String[] args) throws Exception {

        // Create multiple Virtual Threads.
        //
        // JVM internally has only a small number of Carrier Threads.
        //
        // Virtual Thread
        //       │
        //       ▼
        // Mounted
        //       │
        //       ▼
        // Carrier Thread
        //       │
        //       ▼
        // CPU

        for (int i = 1; i <= 8; i++) {

            int id = i;

            Thread.startVirtualThread(() -> {

                System.out.println("\nVirtual-" + id + " Started");

                System.out.println("Current Thread : " + Thread.currentThread());

                System.out.println("Doing some work...");

                try {

                    // IMPORTANT
                    //
                    // sleep() causes the Virtual Thread to BLOCK.
                    //
                    // JVM performs:
                    //
                    // Virtual Thread
                    //      │
                    //      ▼
                    // UNMOUNT
                    //      │
                    //      ▼
                    // Carrier becomes FREE
                    //      │
                    //      ▼
                    // Another Virtual Thread executes.

                    Thread.sleep(3000);

                } catch (InterruptedException e) {
                }

                System.out.println("Virtual-" + id + " Resumed");

                System.out.println("Finished\n");

            });

        }

        Thread.sleep(5000);

        System.out.println("\nMain Finished");
    }
}
