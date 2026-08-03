package D12_Multithreadinginjava.fSynchronized;
/*
===============================================================================
 Demo 2 : Object Lock vs Class Lock
===============================================================================
Topics Covered
--------------
✔ Object Lock
✔ Class Lock
✔ synchronized Instance Method
✔ static synchronized Method
✔ Different Object Monitors
✔ Single Class Monitor
===============================================================================
Theory
===============================================================================
Every Java Object has its own Monitor.
Example
Account account1 = new Account();
↓
Monitor-A
--------------------------------------------------------------
Account account2 = new Account();
↓
Monitor-B
---------------------------------------------------------------
Since monitors are DIFFERENT,
two threads can execute synchronized instance methods
simultaneously on different objects.
===============================================================
Static synchronized methods are different.
There is only ONE Class Object.
Account.class
↓
Single Monitor
↓
Every static synchronized method acquires this monitor.

Regardless of how many objects exist,

only ONE thread can execute static synchronized methods
at a time.

===============================================================================
*/


class Printer {

    /*
     * Instance synchronized Method
     *
     * Lock Owner
     * ----------
     * Current Object (this)
     *
     * Every object owns an independent monitor.
     */

    public synchronized void printObject(String msg) {

        System.out.println(
                Thread.currentThread().getName()
                        + " acquired OBJECT LOCK -> "
                        + this);

        for (int i = 1; i <= 5; i++) {

            System.out.println(
                    Thread.currentThread().getName()
                            + " : "
                            + msg
                            + " Page "
                            + i);

            try {

                Thread.sleep(500);

            }

            catch (InterruptedException e) {

                e.printStackTrace();

            }

        }

        System.out.println(
                Thread.currentThread().getName()
                        + " released OBJECT LOCK\n");

    }


    /*
     * Static synchronized Method
     *
     * Lock Owner
     * ----------
     * Printer.class
     *
     * JVM acquires Class Monitor.
     *
     * Every object shares this SAME lock.
     */

    public static synchronized void printClass(String msg) {

        System.out.println(
                Thread.currentThread().getName()
                        + " acquired CLASS LOCK");

        for (int i = 1; i <= 5; i++) {

            System.out.println(
                    Thread.currentThread().getName()
                            + " : "
                            + msg
                            + " Page "
                            + i);

            try {

                Thread.sleep(500);

            }

            catch (InterruptedException e) {

                e.printStackTrace();

            }

        }

        System.out.println(
                Thread.currentThread().getName()
                        + " released CLASS LOCK\n");

    }

}


public class Demo2 {

    public static void main(String[] args)
            throws Exception {

        /*
         * ===========================================================
         * CASE 1
         * OBJECT LOCK
         * ===========================================================
         *
         * Two different objects.
         *
         * printer1 owns Monitor-1
         *
         * printer2 owns Monitor-2
         *
         * Therefore
         *
         * Thread-A locks printer1
         *
         * Thread-B locks printer2
         *
         * Both execute simultaneously.
         */

        System.out.println(
                "\n================================================");

        System.out.println(
                "CASE 1 : OBJECT LOCK");

        System.out.println(
                "================================================");

        Printer printer1 = new Printer();

        Printer printer2 = new Printer();

        Thread t1 =
                new Thread(
                        () -> printer1.printObject("Invoice"),
                        "Thread-A");

        Thread t2 =
                new Thread(
                        () -> printer2.printObject("Receipt"),
                        "Thread-B");

        t1.start();

        t2.start();

        t1.join();

        t2.join();



        /*
         * ===========================================================
         * CASE 2
         * CLASS LOCK
         * ===========================================================
         *
         * Even though two objects exist,
         *
         * static synchronized
         *
         * locks
         *
         * Printer.class
         *
         * NOT printer1
         * NOT printer2
         *
         * Hence Thread-B waits until
         * Thread-A completes.
         */

        System.out.println(
                "\n================================================");

        System.out.println(
                "CASE 2 : CLASS LOCK");

        System.out.println(
                "================================================");

        Thread t3 =
                new Thread(
                        () -> printer1.printClass("Invoice"),
                        "Thread-A");

        Thread t4 =
                new Thread(
                        () -> printer2.printClass("Receipt"),
                        "Thread-B");

        t3.start();

        t4.start();

        t3.join();

        t4.join();



        /*
         * ===========================================================
         * CASE 3
         * OBJECT LOCK + CLASS LOCK
         * ===========================================================
         *
         * Instance Lock
         *
         * locks
         *
         * printer1 Monitor
         *
         * Static Lock
         *
         * locks
         *
         * Printer.class Monitor
         *
         * These are DIFFERENT monitors.
         *
         * Therefore
         *
         * Both threads execute together.
         */

        System.out.println(
                "\n================================================");

        System.out.println(
                "CASE 3 : OBJECT LOCK + CLASS LOCK");

        System.out.println(
                "================================================");

        Thread t5 =
                new Thread(
                        () -> printer1.printObject("Invoice"),
                        "Thread-A");

        Thread t6 =
                new Thread(
                        () -> Printer.printClass("Report"),
                        "Thread-B");

        t5.start();

        t6.start();

        t5.join();

        t6.join();



        System.out.println("\nDemo Completed.");

    }

}