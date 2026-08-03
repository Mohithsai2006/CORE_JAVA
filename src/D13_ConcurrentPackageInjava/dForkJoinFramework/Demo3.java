//Work-Stealing Algorithm (Understanding How Workers Share Tasks)
package D13_ConcurrentPackageInjava.dForkJoinFramework;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class Demo3 {

    public static void main(String[] args) {

        /*
         * ==========================================================
         *              ForkJoinPool
         * ==========================================================
         *
         * Creates worker threads.
         *
         * Every worker owns
         * its own Deque (Double Ended Queue).
         *
         * Unlike ThreadPoolExecutor,
         * there is NO single shared queue.
         */

        ForkJoinPool pool = new ForkJoinPool(4);

        System.out.println("----------------------------------");
        System.out.println("Parallelism : " + pool.getParallelism());
        System.out.println("----------------------------------");

        /*
         * Submit one BIG task.
         *
         * The task itself
         * recursively creates
         * more child tasks.
         */

        pool.invoke(new WorkStealingTask(1,16));

        System.out.println("\n============== Statistics ==============");

        /*
         * Number of completed steals.
         *
         * Whenever one worker
         * steals work from another
         * this counter increases.
         */

        System.out.println("Steal Count : "
                + pool.getStealCount());

        pool.shutdown();

    }

}


/*
 * RecursiveAction
 *
 * No return value.
 */

class WorkStealingTask extends RecursiveAction {

    private final int start;

    private final int end;

    /*
     * Small threshold.
     *
     * Generates many tasks
     * so work stealing
     * becomes easier to observe.
     */

    private static final int THRESHOLD = 2;

    public WorkStealingTask(int start,int end){

        this.start=start;
        this.end=end;

    }

    @Override
    protected void compute() {

        int size = end-start+1;

        /*
         * Small enough?
         *
         * Process directly.
         */

        if(size<=THRESHOLD){

            System.out.println(

                    Thread.currentThread().getName()

                            +" processing "

                            +start

                            +" -> "

                            +end);

            try {

                /*
                 * Artificial delay.
                 *
                 * Gives other workers
                 * enough time
                 * to steal tasks.
                 */

                Thread.sleep(1000);

            }

            catch (InterruptedException e){

                Thread.currentThread().interrupt();

            }

            return;

        }

        /*
         * Divide current problem.
         */

        int mid=(start+end)/2;

        WorkStealingTask left=

                new WorkStealingTask(start,mid);

        WorkStealingTask right=

                new WorkStealingTask(mid+1,end);

        /*
         * invokeAll()
         *
         * Internally
         *
         * left.fork()
         *
         * right.fork()
         *
         * join both
         *
         * Child tasks
         * enter worker deque.
         *
         * Idle workers
         * may steal them.
         */

        invokeAll(left,right);

    }

}