package D10_Collections.QueueInterface.BlockingQueues.LinkedTransferQueue;
import java.util.concurrent.LinkedTransferQueue;
public class Demo2 {
    // Shared queue used by restaurants and riders.
    private static final LinkedTransferQueue<String> queue =
            new LinkedTransferQueue<>();
    public static void main(String[] args) {

        // Two delivery riders.
        Thread rider1 = new Thread(new Rider("Rider-1"));
        Thread rider2 = new Thread(new Rider("Rider-2"));

        rider1.start();
        rider2.start();

        sleep(1000);

        // Two restaurants.
        Thread restaurant1 =
                new Thread(new Restaurant("Restaurant-1",101));

        Thread restaurant2 =
                new Thread(new Restaurant("Restaurant-2",201));

        restaurant1.start();
        restaurant2.start();
    }

    //====================================================
    // Restaurant (Producer)
    //====================================================
    static class Restaurant implements Runnable {

        private final String name;
        private final int start;

        Restaurant(String name,int start){

            this.name=name;
            this.start=start;
        }

        @Override
        public void run() {

            try {

                // First 2 orders are stored normally.
                for(int i=0;i<2;i++){

                    String order="Order-"+(start+i);

                    System.out.println("\n"+name+
                            " prepared "+order);

                    queue.offer(order);

                    System.out.println(name+
                            " stored "+order+
                            " inside queue.");

                    printQueue();

                    Thread.sleep(1000);
                }

                // VIP order uses direct transfer.
                String vip="VIP-"+start;

                System.out.println("\n"+name+
                        " prepared "+vip);

                System.out.println(name+
                        " checking for waiting rider...");

                System.out.println(
                        "Waiting Riders : "
                                +queue.getWaitingConsumerCount());

                System.out.println(
                        name+" calling transfer("+vip+")");

                queue.transfer(vip);

                System.out.println(name+
                        " VIP order handed directly to rider.");

                printQueue();

            }
            catch(Exception e){
                e.printStackTrace();
            }

        }
    }

    //====================================================
    // Delivery Rider (Consumer)
    //====================================================
    static class Rider implements Runnable{

        private final String name;

        Rider(String name){

            this.name=name;
        }

        @Override
        public void run() {

            while(true){

                try{

                    System.out.println("\n"+name+
                            " waiting for order...");

                    System.out.println(
                            "Waiting Riders : "
                                    +queue.getWaitingConsumerCount());

                    String order=queue.take();

                    System.out.println(name+
                            " accepted "+order);

                    System.out.println(name+
                            " delivering "+order+"...");

                    Thread.sleep(3000);

                    System.out.println(name+
                            " delivered "+order);

                }
                catch(Exception e){
                    break;
                }

            }

        }

    }

    private static void printQueue(){

        System.out.println("Queue : "+queue);

        System.out.println("Queue Size : "
                +queue.size());

        System.out.println(
                "Waiting Riders : "
                        +queue.getWaitingConsumerCount());

        System.out.println(
                "Has Waiting Rider : "
                        +queue.hasWaitingConsumer());

    }

    private static void sleep(long ms){

        try{

            Thread.sleep(ms);

        }
        catch(Exception e){}
    }

}
