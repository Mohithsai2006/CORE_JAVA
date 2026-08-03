package D12_Multithreadinginjava.dLifecycleofthread;


/*
===============================================================================
Demo 1 : Complete Thread Life Cycle
===============================================================================

States Covered
--------------

✔ NEW
✔ RUNNABLE
✔ BLOCKED
✔ WAITING
✔ TIMED_WAITING
✔ TERMINATED

Methods Used
------------

start()
sleep()
join()
synchronized
getState()

===============================================================================
*/

class WorkerThread extends Thread {

    private final Object lock;

    public WorkerThread(Object lock) {

        this.lock = lock;

        setName("Worker-Thread");

    }

    @Override
    public void run() {

        /*
         * Thread enters synchronized block.
         *
         * It acquires monitor lock.
         *
         * Any other thread trying to enter this
         * synchronized block will become BLOCKED.
         */

        synchronized (lock) {

            try {

                System.out.println(getName()
                        + " acquired monitor lock.");

                /*
                 * sleep()
                 *
                 * Current thread enters
                 *
                 * TIMED_WAITING
                 */

                Thread.sleep(3000);

                System.out.println(getName()
                        + " woke up.");

            }

            catch (InterruptedException e) {

                e.printStackTrace();

            }

        }

        System.out.println(getName()
                + " completed run().");

    }

}


/*
 * Second thread
 *
 * Purpose
 * -------
 * Become BLOCKED
 */

class BlockedThread extends Thread {

    private final Object lock;

    public BlockedThread(Object lock) {

        this.lock = lock;

        setName("Blocked-Thread");

    }

    @Override
    public void run() {

        /*
         * WorkerThread already owns this lock.
         *
         * Hence this thread becomes
         *
         * BLOCKED
         */

        synchronized (lock) {

            System.out.println(getName()
                    + " finally acquired lock.");

        }

    }

}


/*
 * Observer Thread
 *
 * Keeps printing states.
 */

class StateObserver extends Thread {

    private final Thread t1;

    private final Thread t2;

    public StateObserver(Thread t1,
                         Thread t2) {

        this.t1 = t1;

        this.t2 = t2;

        setName("State-Observer");

    }

    @Override
    public void run() {

        try {

            while (true) {

                System.out.println("\n==============================");

                System.out.println(
                        t1.getName()
                                + " : "
                                + t1.getState());

                System.out.println(
                        t2.getName()
                                + " : "
                                + t2.getState());

                System.out.println(
                        Thread.currentThread().getName()
                                + " : "
                                + getState());

                System.out.println("==============================");

                /*
                 * Observer sleeps.
                 *
                 * It also enters TIMED_WAITING.
                 */

                Thread.sleep(500);

                /*
                 * Stop observing after both terminate.
                 */

                if (t1.getState() == State.TERMINATED
                        &&
                        t2.getState() == State.TERMINATED) {

                    break;

                }

            }

        }

        catch (InterruptedException e) {

            e.printStackTrace();

        }

    }

}

public class Demo {

    public static void main(String[] args)
            throws Exception {

        Object monitor = new Object();

        WorkerThread worker =
                new WorkerThread(monitor);

        BlockedThread blocked =
                new BlockedThread(monitor);

        StateObserver observer =
                new StateObserver(worker,
                        blocked);

        /*
         * =====================================================
         * NEW STATE
         * =====================================================
         *
         * Thread Objects created.
         *
         * Native Thread NOT created.
         */

        System.out.println("Before start()");

        System.out.println(worker.getName()
                + " : "
                + worker.getState());

        System.out.println(blocked.getName()
                + " : "
                + blocked.getState());

        /*
         * =====================================================
         * RUNNABLE
         * =====================================================
         *
         * JVM creates native thread.
         *
         * Scheduler decides execution.
         */

        worker.start();

        /*
         * Small delay so worker acquires monitor.
         */

        Thread.sleep(100);

        /*
         * This thread immediately tries
         * entering same synchronized block.
         *
         * Hence BLOCKED.
         */

        blocked.start();

        /*
         * Observer prints states continuously.
         */

        observer.start();

        /*
         * =====================================================
         * WAITING
         * =====================================================
         *
         * Main thread waits for worker.
         *
         * Current thread becomes
         *
         * WAITING
         */

        worker.join();

        /*
         * Wait for blocked thread also.
         */

        blocked.join();

        observer.join();

        /*
         * =====================================================
         * TERMINATED
         * =====================================================
         */

        System.out.println("\nMain Thread Finished.");

    }

}