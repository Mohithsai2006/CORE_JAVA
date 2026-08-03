package D10_Collections.QueueInterface.BlockingQueues.LinkedBlockingQueue;
import java.util.TreeSet;
import java.util.concurrent.LinkedBlockingQueue;
class Producer implements Runnable {
    private LinkedBlockingQueue<Integer> queue;
    Producer(LinkedBlockingQueue<Integer> queue){

        this.queue = queue;

    }
    @Override
    public void run(){
        try {
            for(int i=1;i<=10;i++){
                System.out.println(
                        "Produced : "+ i
                );
                /*
                 * put()
                 *
                 * If queue full
                 *
                 * producer waits
                 */
                queue.put(i);
                Thread.sleep(500);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
class Consumer implements Runnable {
    private LinkedBlockingQueue<Integer> queue;
    Consumer(LinkedBlockingQueue<Integer> queue){
        this.queue = queue;
    }
    @Override
    public void run(){
        try {
            while(true){
                /*
                 *
                 * take()
                 *
                 * If queue empty
                 *
                 * consumer waits
                 *
                 */
                Integer value =
                        queue.take();
                System.out.println(
                        "Consumed : "
                                + value
                );
                Thread.sleep(1000);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
public class Demo2 {
    public static void main(String[] args){

        /*
         *
         * Queue capacity = 3
         *
         */

        LinkedBlockingQueue<Integer> queue =
                new LinkedBlockingQueue<>(3);
        Thread producer =
                new Thread(
                        new Producer(queue)
                );
        Thread consumer =
                new Thread(
                        new Consumer(queue)
                );
        producer.start();
        consumer.start();
    }
}