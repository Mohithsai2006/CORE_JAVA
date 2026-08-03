package D10_Collections.QueueInterface.BlockingQueues.LinkedBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
public class Demo1 {
    public static void main(String[] args)
            throws InterruptedException {
        /*
         * LinkedBlockingQueue
         *
         * Internally uses Linked Nodes
         *
         * head
         *  |
         *  v
         *
         * A -> B -> C
         *
         * tail
         *
         *
         * Capacity = 5
         */
        LinkedBlockingQueue<String> queue =
                new LinkedBlockingQueue<>(5);
        /*
         * add()
         *
         * Inserts element
         *
         * Throws IllegalStateException
         * if queue is full
         */

        queue.add("Java");
        queue.add("Python");
        queue.add("Spring");
        System.out.println(
                "After add : "
                        + queue
        );
        /*
         * offer()
         *
         * Inserts element
         *
         * Returns true/false
         *
         * Does not block
         */


        boolean status =
                queue.offer("Hibernate");


        System.out.println(
                "Offer result : "
                        + status
        );


        System.out.println(
                "After offer : "
                        + queue
        );




        /*
         * peek()
         *
         * Returns head element
         *
         * Does not remove
         *
         * FIFO:
         *
         * Java
         *  |
         * Python
         *  |
         * Spring
         */


        System.out.println(
                "Peek : "
                        + queue.peek()
        );


        System.out.println(
                "After peek : "
                        + queue
        );






        /*
         * contains()
         *
         * Searches element
         */


        System.out.println(
                "Contains Java : "
                        + queue.contains("Java")
        );





        /*
         * size()
         */

        System.out.println(
                "Size : "
                        + queue.size()
        );






        /*
         * remainingCapacity()
         *
         *
         * capacity - current size
         *
         *
         * capacity = 5
         *
         * size = 4
         *
         * remaining = 1
         */

        System.out.println(
                "Remaining Capacity : "
                        + queue.remainingCapacity()
        );






        /*
         * poll()
         *
         * Removes head
         *
         * Returns null
         * if queue empty
         */


        String removed =
                queue.poll();


        System.out.println(
                "Poll removed : "
                        + removed
        );


        System.out.println(
                "After poll : "
                        + queue
        );







        /*
         * put()
         *
         * Blocking insertion
         *
         * waits if queue full
         */


        queue.put("Docker");


        System.out.println(
                "After put : "
                        + queue
        );







        /*
         * take()
         *
         * Blocking removal
         *
         * waits if queue empty
         */


        String value =
                queue.take();


        System.out.println(
                "Take removed : "
                        + value
        );



        System.out.println(
                "Final Queue : "
                        + queue
        );







        /*
         * remove()
         *
         * Removes specific object
         */

        queue.remove("Spring");


        System.out.println(
                "After remove(Spring): "
                        + queue
        );


    }

}