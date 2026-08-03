package D10_Collections.QueueInterface.BlockingQueues.PrioirityBlockingQueue;
import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;
/*
    Represents a task submitted to the scheduler.
*/
class Task {
    int priority;
    String taskName;
    public Task(int priority, String taskName) {
        this.priority = priority;
        this.taskName = taskName;
    }
    @Override
    public String toString() {
        return "[Priority=" + priority + ", Task=" + taskName + "]";
    }
}
public class Demo2 {
    public static void main(String[] args) {
        /*
            Comparator
            Smaller priority value means
            HIGHER priority.
            Priority 1  -> Highest
            Priority 10 -> Lowest
         */
        Comparator<Task> comparator =
                Comparator.comparingInt(task -> task.priority);
        /*
            PriorityBlockingQueue
            Initial Capacity = 11
            Queue is still UNBOUNDED.
            Internally
                  Binary Heap
                      +
               ReentrantLock
                      +
                 Condition(notEmpty)
         */
        PriorityBlockingQueue<Task> queue =
                new PriorityBlockingQueue<>(11, comparator);
        //----------------------------------------------------------
        // Producer - 1
        //----------------------------------------------------------
        Thread producer1 = new Thread(() -> {
            try {
                System.out.println("Producer-1 Started\n");
                queue.put(new Task(5, "Generate Report"));
                Thread.sleep(500);
                queue.put(new Task(2, "Process Payment"));
                Thread.sleep(500);
                queue.put(new Task(8, "Backup Database"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        //----------------------------------------------------------
        // Producer - 2
        //---------------------------------------------------------
        Thread producer2 = new Thread(() -> {
            try {
                Thread.sleep(300);
                System.out.println("Producer-2 Started\n");
                queue.put(new Task(1, "Emergency Security Patch"));
                Thread.sleep(700);
                queue.put(new Task(4, "Send Email"));
                Thread.sleep(500);
                queue.put(new Task(3, "Generate Invoice"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        //----------------------------------------------------------
        // Consumer
        //----------------------------------------------------------
        Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    /*
                        take()
                        If queue becomes empty
                        Consumer automatically waits.
                        When producer inserts
                        signal(notEmpty)
                        Consumer resumes.
                    */
                    Task task = queue.take();
                    System.out.println(
                            Thread.currentThread().getName()
                                    + " Executing -> " + task);
                    Thread.sleep(1000);
                }

            } catch (InterruptedException e) {
                System.out.println("\nConsumer Stopped.");
            }
        });
        consumer.setName("Worker-Thread");
        //----------------------------------------------------------
        producer1.start();
        producer2.start();
        consumer.start();
        //----------------------------------------------------------

        try {
            producer1.join();
            producer2.join();
            /*
                Allow consumer to finish remaining tasks.
             */
            Thread.sleep(8000);
            consumer.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\nMain Thread Finished.");
    }
}