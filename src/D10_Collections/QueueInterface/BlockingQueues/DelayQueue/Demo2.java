package D10_Collections.QueueInterface.BlockingQueues.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;
/*
    OTP object
    Every object stored in DelayQueue
    must implement Delayed.
*/
class OTP implements Delayed {
    private String otp;
    // Absolute expiration time
    private long expiryTime;
    public OTP(String otp, long validSeconds) {
        this.otp = otp;
        /*
            Current Time
                    +
            Validity Period
                    =
            Expiration Time
         */
        this.expiryTime =
                System.currentTimeMillis()
                        + TimeUnit.SECONDS.toMillis(validSeconds);
    }
    /*
        Remaining delay
        DelayQueue repeatedly calls this
        to know whether OTP is expired.
     */
    @Override
    public long getDelay(TimeUnit unit) {
        long remaining =
                expiryTime - System.currentTimeMillis();
        return unit.convert(
                remaining,
                TimeUnit.MILLISECONDS);
    }
    /*
        Smaller delay
        Higher Priority
     */
    @Override
    public int compareTo(Delayed other) {
        return Long.compare(
                this.getDelay(TimeUnit.MILLISECONDS),
                other.getDelay(TimeUnit.MILLISECONDS));
    }
    @Override
    public String toString() {
        return otp;
    }
}
public class Demo2 {
    public static void main(String[] args)
            throws InterruptedException {
        /*
            DelayQueue
            Internally
            PriorityQueue
                    +
            ReentrantLock
                    +
            Leader Thread
         */
        DelayQueue<OTP> queue =
                new DelayQueue<>();
        //----------------------------------------------------
        // Producer - Bank Server
        //----------------------------------------------------
        Thread producer = new Thread(() -> {
            try {
                System.out.println("Generating OTPs...\n");
                queue.put(new OTP("OTP-101", 5));
                System.out.println("Generated OTP-101 (5 sec)");
                Thread.sleep(1000);
                queue.put(new OTP("OTP-102", 10));
                System.out.println("Generated OTP-102 (10 sec)");
                Thread.sleep(1000);
                queue.put(new OTP("OTP-103", 7));
                System.out.println("Generated OTP-103 (7 sec)");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        //----------------------------------------------------
        // Consumer - Expiration Service
        //----------------------------------------------------

        Thread consumer = new Thread(() -> {

            try {

                while (true) {

                    /*
                        take()

                        Blocks until

                        earliest OTP expires.

                        No busy waiting.
                     */

                    OTP expiredOTP =
                            queue.take();

                    System.out.println(

                            "\nExpired -> "

                                    + expiredOTP

                                    + "  Time : "

                                    + System.currentTimeMillis());

                }

            } catch (InterruptedException e) {

                System.out.println("\nExpiration Service Stopped.");
            }

        });

        producer.start();
        consumer.start();

        producer.join();

        /*
            Wait enough time
            for all OTPs to expire.
         */

        Thread.sleep(13000);

        consumer.interrupt();

        System.out.println("\nMain Thread Finished.");
    }
}