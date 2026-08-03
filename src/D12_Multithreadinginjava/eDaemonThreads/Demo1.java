package D12_Multithreadinginjava.eDaemonThreads;
/*
===============================================================================
 Demo 1 : User Thread vs Daemon Thread
===============================================================================

Topics Covered
--------------
✔ User Thread
✔ Daemon Thread
✔ setDaemon(true)
✔ isDaemon()
✔ Parent Thread
✔ Child Thread
✔ Daemon Inheritance
Important Concepts
------------------
1. Every thread is USER by default.
2. setDaemon(true) changes daemon flag BEFORE start().
3. Daemon status is stored inside Thread Object.
4. Scheduler treats User & Daemon threads equally.
5. Difference comes ONLY during JVM shutdown.
6. Child thread inherits daemon status from parent.
===============================================================================
*/
class UserWorker extends Thread {
    public UserWorker() {
        setName("User-Worker");
        // By default every newly created thread is a USER thread.
        // This line is optional because daemon=false by default.
        setDaemon(false);
    }
    @Override
    public void run() {
        System.out.println("\n========== USER THREAD ==========");
        /*
         * isDaemon()
         *
         * Reads daemon flag from Thread Object.
         *
         * Returns:
         * false
         */
        System.out.println(getName() + " -> isDaemon : " + isDaemon());
        for (int i = 1; i <= 5; i++) {

            System.out.println(getName() + " Processing Order : " + i);

            try {

                /*
                 * sleep()
                 *
                 * Thread enters TIMED_WAITING.
                 * JVM DOES NOT release locks while sleeping.
                 */
                Thread.sleep(500);

            } catch (InterruptedException e) {

                e.printStackTrace();

            }

        }

        System.out.println(getName() + " Finished.");

    }

}

class DaemonWorker extends Thread {

    public DaemonWorker() {

        setName("Daemon-Worker");

        /*
         * Changes daemon flag.
         *
         * Internally only one field changes
         *
         * daemon=false
         *
         * becomes
         *
         * daemon=true
         *
         * Must be called BEFORE start().
         */
        setDaemon(true);
    }
    @Override
    public void run() {
        System.out.println("\n========== DAEMON THREAD ==========");
        System.out.println(getName() + " -> isDaemon : " + isDaemon());
        /*
         * Child Thread
         * This child is created by a DAEMON thread.
         * JVM automatically copies parent's daemon flag.
         * Therefore this child also becomes a daemon thread
         * without calling setDaemon(true).
         */
        Thread child = new Thread(() -> {
            System.out.println(
                    Thread.currentThread().getName()
                            + " -> inherited daemon : "
                            + Thread.currentThread().isDaemon());
        });
        child.setName("Daemon-Child");
        child.start();
        for (int i = 1; i <= 5; i++) {
            System.out.println(getName() + " Cleaning Cache : " + i);
            try {
                Thread.sleep(500);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(getName() + " Finished.");
    }
}
public class Demo1 {
    public static void main(String[] args)
            throws Exception {
        /*
         * Main Thread
         *
         * JVM creates this thread automatically.
         *
         * Main Thread is always a USER thread.
         */
        System.out.println("Main Thread isDaemon : "
                + Thread.currentThread().isDaemon());
        UserWorker user = new UserWorker();
        DaemonWorker daemon = new DaemonWorker();
        user.start();
        daemon.start();
        /*
         * join()
         *
         * Main waits until both complete.
         *
         * Since we are waiting,
         * JVM will not exit early.
         */
        user.join();
        daemon.join();
        System.out.println("\nMain Finished.");
    }

}
