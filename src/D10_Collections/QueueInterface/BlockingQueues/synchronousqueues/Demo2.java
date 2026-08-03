//Demo 2 : Real-World Task Dispatcher (ThreadPool Style)
//        Scenario
//
//        Imagine you have a company where clients continuously submit tasks.
//
//        There is no waiting room (queue).
//
//        Instead:
//
//        If a worker is free → hand the task directly to that worker.
//        If no worker is free → the client (producer) must wait.
//        Similarly, if workers are waiting and no client has submitted a task, the workers wait.
//
//        This is exactly how SynchronousQueue is used by Cached Thread Pools.
//Phase 1 : Workers start first
//Worker-1 ready to accept task...
//Worker-1 calling take()
//
//Worker-2 ready to accept task...
//Worker-2 calling take()
//
//Both workers immediately block because no producer has submitted a task.
//
//Worker-1
//    take()
//      ↓
// WAITING
//
//Worker-2
//    take()
//      ↓
// WAITING
//Phase 2 : Producer creates Task-1
//Producer-1 created Task-1
//
//Queue Size         : 0
//Queue Peek         : null
//Remaining Capacity : 0
//
//Producer-1 calling put(Task-1)
//
//Since Worker-1 is already waiting:
//
//Producer-1
//      put(Task-1)
//            │
//            ▼
//     Direct Handoff
//            │
//            ▼
//      Worker-1 receives Task-1
//
//put() returns immediately after the handoff.
//
//Phase 3 : Workers become busy
//
//Suppose both workers are processing tasks.
//
//Worker-1 -> Busy
//Worker-2 -> Busy
//
//Now Producer creates another task.
//
//Producer-2 calling put(Task-5)
//Producer-2 waiting for an available worker...
//
//There is no queue to store Task-5.
//
//So Producer blocks.
//
//Producer-2
//      │
// put(Task-5)
//      │
//      ▼
// WAITING
//Phase 4 : Worker finishes
//Worker-1 completed Task-1
//
//Worker-1 calling take()
//
//Immediately,
//
//Producer-2
//      │
//WAITING
//      │
//      ▼
//Worker-1 take()
//      │
//      ▼
//Direct Transfer
//      │
//      ▼
//Producer resumes
//
//Again, nothing was ever store in the queue
package D10_Collections.QueueInterface.BlockingQueues.synchronousqueues;
import java.util.concurrent.SynchronousQueue;
public class Demo2 {
    // Shared queue between producers and workers.
    // Capacity = 0 -> nothing is stored.
    private static final SynchronousQueue<String> queue = new SynchronousQueue<>();
    public static void main(String[] args) {
        // Two producers continuously submit tasks.
        Thread producer1 = new Thread(new Producer("Producer-1", 1, 3));
        Thread producer2 = new Thread(new Producer("Producer-2", 4, 6));
        // Two workers continuously wait for tasks.
        Thread worker1 = new Thread(new Worker("Worker-1"));
        Thread worker2 = new Thread(new Worker("Worker-2"));
        worker1.start();
        worker2.start();
        // Delay producers slightly so workers are already waiting.
        sleep(1000);
        producer1.start();
        producer2.start();
    }
    //====================================================
    // PRODUCER
    //====================================================
    static class Producer implements Runnable {
        private final String name;
        private final int start;
        private final int end;
        Producer(String name, int start, int end) {
            this.name = name;
            this.start = start;
            this.end = end;
        }
        @Override
        public void run() {
            for (int i = start; i <= end; i++) {
                String task = "Task-" + i;
                System.out.println("\n------------------------------------------------");
                System.out.println(name + " created " + task);
                // These values prove SynchronousQueue never stores data.
                System.out.println("Queue Size              : " + queue.size());
                System.out.println("Queue Peek              : " + queue.peek());
                System.out.println("Remaining Capacity      : " + queue.remainingCapacity());
                System.out.println(name + " calling put(" + task + ")");
                try {
                    // put() blocks until some worker executes take().
                    System.out.println(name + " waiting for an available worker...");
                    queue.put(task);
                    // Control reaches here ONLY after a worker receives the task.
                    System.out.println(name + " successfully handed over " + task);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                sleep(500);
            }
            System.out.println("\n" + name + " finished producing tasks.");
        }
    }
    //====================================================
    // WORKER (Consumer)
    //====================================================
    static class Worker implements Runnable {
        private final String name;
        Worker(String name) {
            this.name = name;
        }
        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("\n" + name + " ready to accept task...");
                    System.out.println(name + " calling take()");
                    // take() blocks until a producer performs put().
                    String task = queue.take();
                    // Direct handoff happened here.
                    System.out.println(name + " received " + task);
                    // Simulate processing.
                    System.out.println(name + " processing " + task + "...");
                    Thread.sleep(3000);
                    System.out.println(name + " completed " + task);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
    }
    // Small utility method.
    private static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
