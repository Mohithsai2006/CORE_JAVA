package D12_Multithreadinginjava.hWaitnotifyspuroiswakeupsinterthread;
/*
===============================================================================
 Demo 2 : Producer Consumer using wait() & notifyAll()
===============================================================================

Topics Covered
--------------
✔ Producer Consumer Problem
✔ Shared Buffer
✔ wait()
✔ notifyAll()
✔ Monitor
✔ Wait Set
✔ Entry Set
✔ Guarded Block (while)
✔ Synchronization

===============================================================================

Problem

Producer
↓

Produces Data

↓

Shared Buffer

↓

Consumer

Consumes Data

Rules

1. Producer cannot produce if buffer already contains data.

2. Consumer cannot consume if buffer is empty.

Instead of Busy Waiting

while(true){

}

Both threads use

wait()

to sleep efficiently.

===============================================================================

Monitor Flow

Producer

Acquire Monitor

↓

Buffer Full ?

↓

YES

↓

wait()

↓

Move to Wait Set

↓

Release Monitor

======================================================

Consumer

Acquire Monitor

↓

Consume Data

↓

notifyAll()

↓

Producer moves

Wait Set

↓

Entry Set

↓

Consumer releases Monitor

↓

Producer acquires Monitor again

===============================================================================
*/


class Buffer {

    /*
     * Single Slot Buffer.
     *
     * Only one value can exist
     * at a time.
     */

    private int data;

    /*
     * Indicates whether buffer
     * currently contains data.
     */

    private boolean available = false;


    //=========================================================================
    // Producer
    //=========================================================================

    public synchronized void produce(int value) {

        /*
         * Guarded Block
         *
         * Producer waits
         * while buffer is FULL.
         */

        while (available) {

            System.out.println(
                    Thread.currentThread().getName()
                            + " Buffer Full.");

            System.out.println(
                    Thread.currentThread().getName()
                            + " waiting...");

            try {

                /*
                 * JVM
                 *
                 * Release Monitor
                 *
                 * ↓
                 *
                 * Move Producer
                 * to Wait Set
                 */

                wait();

            }

            catch (InterruptedException e) {

                Thread.currentThread().interrupt();
                return;

            }

        }

        /*
         * Buffer Empty.
         *
         * Safe to Produce.
         */

        data = value;

        available = true;

        System.out.println(
                Thread.currentThread().getName()
                        + " Produced : "
                        + value);

        /*
         * Wake every waiting thread.
         *
         * Consumer becomes eligible
         * to acquire monitor.
         */

        notifyAll();

    }



    //=========================================================================
    // Consumer
    //=========================================================================

    public synchronized int consume() {

        /*
         * Guarded Block
         *
         * Consumer waits
         * while buffer is EMPTY.
         */

        while (!available) {

            System.out.println(
                    Thread.currentThread().getName()
                            + " Buffer Empty.");

            System.out.println(
                    Thread.currentThread().getName()
                            + " waiting...");

            try {

                /*
                 * Release Monitor.
                 *
                 * Consumer enters
                 * Wait Set.
                 */

                wait();

            }

            catch (InterruptedException e) {

                Thread.currentThread().interrupt();
                return -1;

            }

        }

        int value = data;

        available = false;

        System.out.println(
                Thread.currentThread().getName()
                        + " Consumed : "
                        + value);

        /*
         * Wake Producer.
         */

        notifyAll();

        return value;

    }

}



public class Demo2 {

    public static void main(String[] args) {

        Buffer buffer = new Buffer();


        //=====================================================================
        // Producer Thread
        //=====================================================================

        Thread producer = new Thread(() -> {

            for (int i = 1; i <= 5; i++) {

                buffer.produce(i);

                try {

                    Thread.sleep(1000);

                }

                catch (InterruptedException e) {

                    Thread.currentThread().interrupt();

                }

            }

        }, "Producer");



        //=====================================================================
        // Consumer Thread
        //=====================================================================

        Thread consumer = new Thread(() -> {

            for (int i = 1; i <= 5; i++) {

                buffer.consume();

                try {

                    Thread.sleep(1500);

                }

                catch (InterruptedException e) {

                    Thread.currentThread().interrupt();

                }

            }

        }, "Consumer");


        producer.start();

        consumer.start();

    }

}