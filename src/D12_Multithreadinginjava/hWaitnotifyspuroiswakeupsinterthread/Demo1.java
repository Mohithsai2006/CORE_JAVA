package D12_Multithreadinginjava.hWaitnotifyspuroiswakeupsinterthread;
/*
===============================================================================
 Demo 1 : wait() and notify()
===============================================================================
Topics Covered
--------------
✔ wait()
✔ notify()
✔ Monitor Ownership
✔ Wait Set
✔ Entry Set
✔ Lock Release
✔ Lock Reacquisition

===============================================================================

JVM Internals

Initially

Monitor
---------
Owner = NULL

===============================================================================

Step 1

Consumer enters synchronized(lock)

Owner

↓

Consumer Thread

===============================================================================

Step 2

Consumer executes

lock.wait()

JVM internally performs

Release Monitor
↓

Owner = NULL
↓

Move Consumer into Wait Set
↓

Consumer State = WAITING

===============================================================================

Step 3

Producer acquires same Monitor

Owner

↓

Producer Thread

===============================================================================

Step 4

Producer executes

lock.notify()

Consumer moves

Wait Set

↓

Entry Set

IMPORTANT

Consumer is NOT running yet.

Producer STILL owns Monitor.

===============================================================================

Step 5

Producer exits synchronized block.

Monitor Released.

===============================================================================

Step 6

Consumer competes again.

Acquires Monitor.

Execution resumes AFTER wait().

===============================================================================
*/


class SharedResource {

    /*
     * Shared Lock Object.
     *
     * This object owns ONE monitor.
     *
     * Both Producer and Consumer
     * synchronize using this monitor.
     */

    private final Object lock = new Object();


    //=========================================================================
    // Consumer
    //=========================================================================

    public void consumer() {

        synchronized (lock) {

            System.out.println(
                    Thread.currentThread().getName()
                            + " acquired Monitor.");

            System.out.println(
                    Thread.currentThread().getName()
                            + " waiting for Producer...");


            try {

                /*
                 * Internally JVM performs
                 *
                 * 1) Release Monitor
                 * 2) Move Thread to Wait Set
                 * 3) Thread State = WAITING
                 *
                 * Producer can now acquire monitor.
                 */

                lock.wait();

            }

            catch (InterruptedException e) {

                e.printStackTrace();

            }

            /*
             * This line executes ONLY AFTER
             *
             * Producer calls notify()
             *
             * AND
             *
             * Producer releases monitor.
             */

            System.out.println(
                    Thread.currentThread().getName()
                            + " resumed after wait().");

            System.out.println(
                    Thread.currentThread().getName()
                            + " processing data...");

        }

        System.out.println(
                Thread.currentThread().getName()
                        + " released Monitor.");

    }



    //=========================================================================
    // Producer
    //=========================================================================

    public void producer() {

        synchronized (lock) {

            System.out.println(
                    Thread.currentThread().getName()
                            + " acquired Monitor.");

            System.out.println(
                    Thread.currentThread().getName()
                            + " preparing data...");

            try {

                Thread.sleep(2000);

            }

            catch (InterruptedException e) {

                e.printStackTrace();

            }

            /*
             * notify()
             *
             * DOES NOT release monitor.
             *
             * Consumer simply moves
             *
             * Wait Set
             *
             * ↓
             *
             * Entry Set
             */

            System.out.println(
                    Thread.currentThread().getName()
                            + " notifying waiting thread...");

            lock.notify();

            System.out.println(
                    "Consumer moved from Wait Set to Entry Set.");

            System.out.println(
                    Thread.currentThread().getName()
                            + " still owns Monitor.");

        }

        /*
         * Only here
         *
         * Monitor gets released.
         */

        System.out.println(
                Thread.currentThread().getName()
                        + " released Monitor.");

    }

}



public class Demo1 {

    public static void main(String[] args)
            throws Exception {

        SharedResource resource =
                new SharedResource();


        Thread consumer =
                new Thread(
                        resource::consumer,
                        "Consumer");


        Thread producer =
                new Thread(
                        resource::producer,
                        "Producer");


        /*
         * Start Consumer first.
         *
         * Consumer enters WAITING state.
         */

        consumer.start();

        Thread.sleep(1000);


        /*
         * Producer starts later.
         */

        producer.start();

    }

}