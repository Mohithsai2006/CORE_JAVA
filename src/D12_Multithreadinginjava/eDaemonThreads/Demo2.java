package D12_Multithreadinginjava.eDaemonThreads;
/*
===============================================================================
 Demo 2 : JVM Exit Rule
===============================================================================

Topics Covered
--------------
✔ Daemon Thread
✔ Infinite Loop
✔ JVM Shutdown Rule

Important Rule
--------------
JVM checks only USER threads.

If NO user thread is alive

↓

JVM immediately terminates

↓

ALL daemon threads are stopped immediately.

Even if daemon thread is inside an infinite loop.

This is why daemon threads should NEVER perform
critical business operations like

- Saving Bank Transactions
- Writing Orders
- Updating Database

because JVM may terminate them abruptly.

===============================================================================
*/

class BackgroundCleaner extends Thread {

    public BackgroundCleaner() {

        setName("Background-Cleaner");

        setDaemon(true);

    }

    @Override
    public void run() {

        int count = 1;

        while (true) {

            System.out.println(getName()
                    + " Cleaning Memory... "
                    + count++);

            try {

                /*
                 * sleep()
                 *
                 * Simulates periodic background work.
                 */
                Thread.sleep(1000);

            }

            catch (InterruptedException e) {

                e.printStackTrace();

            }

        }

    }

}

public class Demo2 {

    public static void main(String[] args)
            throws Exception {

        BackgroundCleaner cleaner =
                new BackgroundCleaner();

        cleaner.start();

        /*
         * Main Thread sleeps for few seconds.
         *
         * During this time
         * daemon thread keeps running.
         */
        Thread.sleep(4000);

        System.out.println("\nMain Thread Finished.");

        /*
         * main() returns.
         *
         * No USER threads remain.
         *
         * JVM checks:
         *
         * Any User Thread Alive?
         *
         * Answer:
         * NO
         *
         * JVM immediately shuts down.
         *
         * Daemon thread NEVER prints
         * "Finished".
         *
         * It is terminated abruptly by JVM.
         */

    }

}