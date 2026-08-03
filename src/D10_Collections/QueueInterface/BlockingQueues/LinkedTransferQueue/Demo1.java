package D10_Collections.QueueInterface.BlockingQueues.LinkedTransferQueue;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;
public class Demo1{
    // Shared queue.
    // Internally uses a lock-free linked node structure (CAS based).
    private static final LinkedTransferQueue<String> queue = new LinkedTransferQueue<>();
    public static void main(String[] args) throws Exception {
        System.out.println("\n========== INITIAL STATE ==========");
        printQueueInfo();
        //==============================================================
        // 1. offer()
        //==============================================================
        System.out.println("\n========== offer() ==========");
        // offer() immediately inserts the element.
        // Queue is unbounded, so offer() always returns true.
        queue.offer("Apple");
        System.out.println("offer(\"Apple\") completed.");
        printQueueInfo();
        //==============================================================
        // 2. put()
        //==============================================================
        System.out.println("\n========== put() ==========");
        // Since LinkedTransferQueue is UNBOUNDED,
        // put() behaves exactly like offer().
        // It NEVER blocks.
        queue.put("Orange");
        System.out.println("put(\"Orange\") completed.");
        printQueueInfo();
        //==============================================================
        // 3. peek()
        //==============================================================
        System.out.println("\n========== peek() ==========");
        // Returns the head element without removing it.
        System.out.println("peek() = " + queue.peek());
        printQueueInfo();
        //=============================================================
        // 4. poll()
        //==============================================================
        System.out.println("\n========== poll() ==========");
        // Removes and returns head element immediately.
        System.out.println("poll() = " + queue.poll());
        printQueueInfo();
        //==============================================================
        // 5. take()
        //==============================================================
        System.out.println("\n========== take() ==========");
        // Removes head element.
        // If queue becomes empty it would BLOCK.
        System.out.println("take() = " + queue.take());
        printQueueInfo();
        //==============================================================
        // 6. transfer()
        //==============================================================
        System.out.println("\n========== transfer() ==========");
        // Start consumer after 3 seconds.
        Thread consumer = new Thread(() -> {
            sleep(3000);
            try {
                System.out.println("\nConsumer is now waiting...");
                // Consumer immediately receives the transferred element.
                String item = queue.take();
                System.out.println("Consumer received : " + item);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        consumer.start();
        System.out.println("Producer calling transfer(\"Banana\")");
        // transfer() waits until another thread receives the element.
        queue.transfer("Banana");
        System.out.println("Producer resumed after consumer accepted Banana.");
        printQueueInfo();
        //==============================================================
        // 7. tryTransfer()
        //==============================================================
        System.out.println("\n========== tryTransfer() ==========");
        // No consumer is waiting.
        // Therefore this immediately returns false.
        boolean transferred = queue.tryTransfer("Mango");
        System.out.println("tryTransfer(\"Mango\") = " + transferred);
        printQueueInfo();
        //==============================================================
        // 8. tryTransfer(timeout)
        //==============================================================
        System.out.println("\n========== tryTransfer(timeout) ==========");
        Thread delayedConsumer = new Thread(() -> {
            sleep(2000);
            try {
                System.out.println("\nConsumer waiting for timed transfer...");
                System.out.println("Received : " + queue.take());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        delayedConsumer.start();
        // Waits for at most 5 seconds.
        boolean success =
                queue.tryTransfer("Grapes", 5, TimeUnit.SECONDS);
        System.out.println("Timed transfer success = " + success);
        printQueueInfo();
        //==============================================================
        // 9. Waiting Consumer Information
        //==============================================================
        System.out.println("\n========== Waiting Consumer APIs ==========");
        Thread waitingConsumer = new Thread(() -> {
            try {
                // Queue is empty.
                // Consumer becomes a waiting request node.
                queue.take();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        waitingConsumer.start();
        sleep(1000);
        System.out.println("hasWaitingConsumer() = "
                + queue.hasWaitingConsumer());
        System.out.println("getWaitingConsumerCount() = "
                + queue.getWaitingConsumerCount());

        // Give waiting consumer the element.
        queue.transfer("Pineapple");

        sleep(1000);

        System.out.println("\n========== DEMO FINISHED ==========");
    }

    //==============================================================
    // Utility method to print queue state.
    //==============================================================
    private static void printQueueInfo() {

        System.out.println("Queue : " + queue);

        System.out.println("Size : " + queue.size());

        System.out.println("Waiting Consumers : "
                + queue.getWaitingConsumerCount());

        System.out.println("Has Waiting Consumer : "
                + queue.hasWaitingConsumer());

    }

    private static void sleep(long ms) {

        try {

            Thread.sleep(ms);

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();
        }
    }
}
