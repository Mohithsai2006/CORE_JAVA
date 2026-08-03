package D12_Multithreadinginjava.cThreadClass;
/*
===============================================================================
 Demo 3 : Complete Thread Class Methods
===============================================================================

Methods Covered
---------------
✔ start()
✔ run()
✔ currentThread()
✔ getName()
✔ setName()
✔ getPriority()
✔ setPriority()
✔ isAlive()
✔ sleep()
✔ join()
✔ yield()
✔ interrupt()
✔ isInterrupted()
✔ interrupted()

Scenario
--------
Main Thread
      │
      ├── Download Thread
      │       │
      │       ├── sleeps (network delay)
      │       ├── resumes
      │       └── finishes
      │
      └── Logger Thread
              │
              ├── writes logs
              ├── yields CPU
              ├── gets interrupted
              ├── checks interrupt flag
              └── clears interrupt flag

===============================================================================
*/

class DownloadThread extends Thread {

    public DownloadThread() {

        /*
         * Changing thread metadata BEFORE start().
         * This modifies only the Thread Object stored in Heap.
         */

        setName("Download-Thread");

        setPriority(Thread.MAX_PRIORITY);
    }

    @Override
    public void run() {

        Thread current = Thread.currentThread();

        System.out.println("\n========== DOWNLOAD THREAD ==========");

        System.out.println("Name      : " + current.getName());
        System.out.println("ID        : " + current.getId());
        System.out.println("Priority  : " + current.getPriority());

        try {

            for (int i = 1; i <= 5; i++) {

                System.out.println(current.getName()
                        + " downloading... " + (i * 20) + "%");

                /*
                 * Simulating slow network.
                 *
                 * Internally
                 *
                 * RUNNABLE
                 *      ↓
                 * TIMED_WAITING
                 *      ↓
                 * RUNNABLE
                 *
                 * No new thread is created.
                 * No memory allocation happens.
                 */

                Thread.sleep(1000);

            }

        } catch (InterruptedException e) {

            System.out.println(current.getName()
                    + " interrupted while sleeping.");

        }

        System.out.println(current.getName() + " Download Completed.");

    }

}

class LoggerThread extends Thread {

    public LoggerThread() {

        setName("Logger-Thread");

        setPriority(Thread.MIN_PRIORITY);

    }

    @Override
    public void run() {

        Thread current = Thread.currentThread();

        System.out.println("\n========== LOGGER THREAD ==========");

        for (int i = 1; i <= 8; i++) {

            /*
             * If another thread called interrupt(),
             * interrupt flag becomes TRUE.
             *
             * isInterrupted()
             *
             * only READS the flag.
             *
             * It does NOT clear it.
             */

            if (current.isInterrupted()) {

                System.out.println(current.getName()
                        + " : Interrupt Detected");

                /*
                 * Thread.interrupted()
                 *
                 * STATIC METHOD
                 *
                 * Checks CURRENT THREAD
                 * and CLEARS interrupt flag.
                 */

                System.out.println("Flag Before Clear : "
                        + current.isInterrupted());

                System.out.println("Thread.interrupted() returned : "
                        + Thread.interrupted());

                System.out.println("Flag After Clear : "
                        + current.isInterrupted());

                break;

            }

            System.out.println(current.getName()
                    + " Writing Log : " + i);

            /*
             * yield()
             *
             * Merely gives scheduler a chance.
             *
             * Scheduler may
             *
             * switch thread
             *
             * OR
             *
             * continue same thread.
             *
             * No guarantees.
             */

            Thread.yield();

        }

        System.out.println(current.getName() + " Finished.");

    }

}

public class Demo3 {

    public static void main(String[] args) throws Exception {

        /*
         * currentThread()
         *
         * Returns currently executing thread.
         *
         * Here:
         *
         * Main Thread
         */

        Thread main = Thread.currentThread();

        main.setName("Application-Main");

        main.setPriority(Thread.NORM_PRIORITY);

        System.out.println("========== MAIN THREAD ==========");

        System.out.println("Name      : " + main.getName());

        System.out.println("ID        : " + main.getId());

        System.out.println("Priority  : " + main.getPriority());

        System.out.println("Alive     : " + main.isAlive());



        /*
         * Creating Thread Objects.
         *
         * Heap now contains:
         *
         * DownloadThread Object
         * LoggerThread Object
         *
         * BUT
         *
         * No Native Thread yet.
         */

        DownloadThread download = new DownloadThread();

        LoggerThread logger = new LoggerThread();



        System.out.println("\nBefore start()");

        System.out.println(download.getName()
                + " Alive : "
                + download.isAlive());



        /*
         * start()
         *
         * JVM internally:
         *
         * start()
         *      ↓
         * start0()
         *      ↓
         * Native OS Thread
         *      ↓
         * Java Stack
         *      ↓
         * PC Register
         *      ↓
         * Scheduler
         *      ↓
         * run()
         */

        download.start();

        logger.start();



        System.out.println("\nAfter start()");

        System.out.println(download.getName()
                + " Alive : "
                + download.isAlive());



        /*
         * Sleeping Main Thread.
         *
         * Main Thread enters
         *
         * TIMED_WAITING
         */

        Thread.sleep(2500);



        /*
         * interrupt()
         *
         * Only sets interrupt flag.
         *
         * Does NOT kill thread.
         */

        System.out.println("\nMain Interrupting Logger...\n");

        logger.interrupt();



        /*
         * join()
         *
         * Main Thread waits.
         *
         * Main Thread state:
         *
         * WAITING
         *
         * until
         *
         * Download Thread completes.
         */

        download.join();



        System.out.println("\nDownload Completed.");



        /*
         * Waiting for logger also.
         */

        logger.join();



        System.out.println("\nLogger Completed.");



        System.out.println("\n========== MAIN FINISHED ==========");

    }

}
