package D12_Multithreadinginjava.virtualthreads.pinning;

import java.util.concurrent.locks.ReentrantLock;

public class Demo3 {

    private static final Object monitor = new Object();

    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws Exception {

        System.out.println("\n========== synchronized (Pinning) ==========\n");

        Thread vt1 = Thread.startVirtualThread(() -> {

            synchronized (monitor) {

                System.out.println("VT-1 acquired synchronized monitor");

                try {

                    // ---------------- IMPORTANT ----------------
                    //
                    // Virtual Thread owns JVM Monitor.
                    //
                    // JVM CANNOT unmount it while monitor is held.
                    //
                    // Carrier Thread becomes PINNED.
                    //
                    // Carrier waits for entire sleep duration.
                    //
                    Thread.sleep(4000);

                } catch (InterruptedException e) {
                }

                System.out.println("VT-1 exits synchronized block");

            }

        });

        Thread vt2 = Thread.startVirtualThread(() -> {

            synchronized (monitor) {

                System.out.println("VT-2 entered synchronized block");

            }

        });

        vt1.join();
        vt2.join();

        System.out.println("\n========== ReentrantLock ==========\n");

        Thread vt3 = Thread.startVirtualThread(() -> {

            lock.lock();

            try {

                System.out.println("VT-3 acquired ReentrantLock");

                // Blocking call.
                //
                // JVM can usually unmount this Virtual Thread
                // while it is parked, allowing the Carrier Thread
                // to execute another Virtual Thread.

                Thread.sleep(4000);

                System.out.println("VT-3 Finished");

            } catch (InterruptedException e) {

            } finally {

                lock.unlock();

            }

        });

        Thread vt4 = Thread.startVirtualThread(() -> {

            lock.lock();

            try {

                System.out.println("VT-4 acquired ReentrantLock");

            } finally {

                lock.unlock();

            }

        });

        vt3.join();
        vt4.join();

        System.out.println("\nProgram Finished");
    }
}
