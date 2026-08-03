package D12_Multithreadinginjava.jThreadLocal;
public class PerThreadStorageDemo {
    // ---------------------------------------------------------
    // ThreadLocal creates ONE object,
    // but every thread stores its OWN VALUE.
    //
    // Internally:
    //
    // Thread-1
    //      │
    //      ▼
    // ThreadLocalMap
    //      │
    //      ▼
    // (threadLocal → "Alice")
    //
    //
    // Thread-2
    //      │
    //      ▼
    // ThreadLocalMap
    //      │
    //      ▼
    // (threadLocal → "Bob")
    //
    // Notice:
    // Same ThreadLocal object
    // Different values.
    // ---------------------------------------------------------

    private static final ThreadLocal<String> loggedInUser =
            ThreadLocal.withInitial(() -> "No User");

    static class UserTask implements Runnable {

        private final String userName;

        UserTask(String userName) {
            this.userName = userName;
        }

        @Override
        public void run() {

            System.out.println("\n----------------------------------");
            System.out.println(Thread.currentThread().getName());

            // Every thread initially gets
            // its own default value.
            System.out.println("Initial Value : "
                    + loggedInUser.get());

            // Stores value ONLY inside
            // current thread's ThreadLocalMap.
            loggedInUser.set(userName);

            System.out.println("After set()   : "
                    + loggedInUser.get());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }

            // Still same value because
            // other threads cannot modify it.
            System.out.println("Final Value   : "
                    + loggedInUser.get());

            // VERY IMPORTANT
            //
            // Removes current thread's
            // entry from ThreadLocalMap.
            //
            // Prevents memory leak.
            loggedInUser.remove();

            System.out.println("After remove(): "
                    + loggedInUser.get());
        }
    }
    public static void main(String[] args)
            throws InterruptedException {
        Thread t1 = new Thread(
                new UserTask("Alice"),
                "Thread-1");
        Thread t2 = new Thread(
                new UserTask("Bob"),
                "Thread-2");
        Thread t3 = new Thread(
                new UserTask("Charlie"),
                "Thread-3");
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
    }
}