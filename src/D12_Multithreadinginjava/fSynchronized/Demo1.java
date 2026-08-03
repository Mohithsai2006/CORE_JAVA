package D12_Multithreadinginjava.fSynchronized;
/*
===============================================================================
 Demo 1 : synchronized Method vs synchronized Block
===============================================================================
Topics Covered
--------------
✔ Race Condition
✔ Shared Resource
✔ Critical Section
✔ synchronized Method
✔ synchronized Block
✔ Object Monitor
✔ Mutual Exclusion
==============================================================================
What this demo shows
===============================================================================
Case 1
-------
Without synchronization
Thread-A
Thread-B
Both modify same Account object simultaneously.
Result:
Race Condition
===============================================================
Case 2
-------
synchronized Method
Entire method acquires object's monitor.
Only one thread executes method at a time.
===============================================================
Case 3
------
synchronized Block
Only critical section acquires monitor.
Non-critical code executes without lock.
Better concurrency.
===============================================================================
*/
class BankAccount {
    /*
     * Shared Heap Variable.
     * Both threads access this variable.
     *
     * Since Heap is shared,
     * race condition is possible.
     */
    private int balance = 1000;


    //=========================================================================
    // CASE 1 : WITHOUT SYNCHRONIZATION
    //=========================================================================

    public void withdrawWithoutSync(int amount) {

        /*
         * Both threads can enter simultaneously.
         *
         * Internally
         *
         * Read balance
         * ↓
         * Modify
         * ↓
         * Write balance
         *
         * Since these operations are NOT atomic,
         * another thread may interfere.
         */

        System.out.println(Thread.currentThread().getName()
                + " entered withdrawWithoutSync()");

        if (balance >= amount) {

            try {

                /*
                 * Artificial delay.
                 *
                 * Gives another thread enough time
                 * to read same balance.
                 */

                Thread.sleep(500);

            }

            catch (InterruptedException e) {

                e.printStackTrace();

            }

            balance -= amount;

            System.out.println(Thread.currentThread().getName()
                    + " Withdraw Success.");

            System.out.println("Balance : " + balance);

        }

        else {

            System.out.println("Insufficient Balance.");

        }

    }


    //=========================================================================
    // CASE 2 : SYNCHRONIZED METHOD
    //=========================================================================

    /*
     * synchronized Method
     *
     * JVM internally behaves approximately like:
     *
     * synchronized(this){
     *
     *      entire method
     *
     * }
     *
     * Lock Owner
     * ----------
     * Current Account Object.
     *
     * Before entering,
     * JVM acquires object's monitor.
     *
     * Other threads trying to execute
     * ANY synchronized instance method
     * on SAME object become BLOCKED.
     */

    public synchronized void withdrawWithMethod(int amount) {

        System.out.println(Thread.currentThread().getName()
                + " entered synchronized Method.");

        if (balance >= amount) {

            try {

                Thread.sleep(500);

            }

            catch (InterruptedException e) {

                e.printStackTrace();

            }

            balance -= amount;

            System.out.println(Thread.currentThread().getName()
                    + " Withdraw Success.");

            System.out.println("Balance : " + balance);

        }

        else {

            System.out.println("Insufficient Balance.");

        }

    }



    //=========================================================================
    // CASE 3 : SYNCHRONIZED BLOCK
    //=========================================================================

    public void withdrawWithBlock(int amount) {

        /*
         * Everything before synchronized
         * executes WITHOUT lock.
         *
         * Multiple threads can execute
         * this portion simultaneously.
         */

        System.out.println(Thread.currentThread().getName()
                + " Validating Request...");


        /*
         * Only this critical section
         * requires synchronization.
         *
         * JVM acquires monitor
         * of current object.
         */

        synchronized (this) {

            System.out.println(Thread.currentThread().getName()
                    + " entered synchronized Block.");

            if (balance >= amount) {

                try {

                    Thread.sleep(500);

                }

                catch (InterruptedException e) {

                    e.printStackTrace();

                }

                balance -= amount;

                System.out.println(Thread.currentThread().getName()
                        + " Withdraw Success.");

                System.out.println("Balance : " + balance);

            }

            else {

                System.out.println("Insufficient Balance.");

            }

        }

        /*
         * Lock released.
         *
         * Threads execute remaining code
         * simultaneously.
         */

        System.out.println(Thread.currentThread().getName()
                + " Printing Receipt...");

    }

}



public class Demo1 {

    public static void main(String[] args)
            throws Exception {

        //---------------------------------------------------------------------
        // CASE 1
        //---------------------------------------------------------------------

        System.out.println(
                "\n==============================");

        System.out.println("CASE 1 : WITHOUT SYNCHRONIZATION");

        System.out.println(
                "==============================");

        BankAccount account1 =
                new BankAccount();

        Thread t1 = new Thread(() ->
                account1.withdrawWithoutSync(700),
                "Thread-A");

        Thread t2 = new Thread(() ->
                account1.withdrawWithoutSync(700),
                "Thread-B");

        t1.start();

        t2.start();

        t1.join();

        t2.join();


        //---------------------------------------------------------------------
        // CASE 2
        //---------------------------------------------------------------------

        System.out.println(
                "\n==============================");

        System.out.println("CASE 2 : SYNCHRONIZED METHOD");

        System.out.println(
                "==============================");

        BankAccount account2 =
                new BankAccount();

        Thread t3 = new Thread(() ->
                account2.withdrawWithMethod(700),
                "Thread-A");

        Thread t4 = new Thread(() ->
                account2.withdrawWithMethod(700),
                "Thread-B");

        t3.start();

        t4.start();

        t3.join();

        t4.join();


        //---------------------------------------------------------------------
        // CASE 3
        //---------------------------------------------------------------------

        System.out.println(
                "\n==============================");

        System.out.println("CASE 3 : SYNCHRONIZED BLOCK");

        System.out.println(
                "==============================");

        BankAccount account3 =
                new BankAccount();

        Thread t5 = new Thread(() ->
                account3.withdrawWithBlock(700),
                "Thread-A");

        Thread t6 = new Thread(() ->
                account3.withdrawWithBlock(700),
                "Thread-B");

        t5.start();

        t6.start();

        t5.join();

        t6.join();

    }

}
