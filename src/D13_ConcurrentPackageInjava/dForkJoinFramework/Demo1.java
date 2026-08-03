//ForkJoinPool + RecursiveTask (Finding Sum of Array)
package D13_ConcurrentPackageInjava.dForkJoinFramework;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Demo1 {

    public static void main(String[] args) {

        /*
         * Large problem
         *
         * Find the sum of all elements.
         */

        int[] numbers = {1,2,3,4,5,6,7,8};

        /*
         * Create a ForkJoinPool.
         *
         * It internally creates worker threads.
         *
         * Each worker owns
         * its own double ended queue (Deque).
         *
         * Worker threads are reused
         * just like ThreadPoolExecutor,
         * but here they execute
         * recursive tasks.
         */

        ForkJoinPool pool = new ForkJoinPool();

        /*
         * Create the root task.
         *
         * This task represents
         * the complete problem.
         */

        SumTask task = new SumTask(numbers,0,numbers.length-1);

        /*
         * invoke()
         *
         * Submits the task
         * to ForkJoinPool.
         *
         * Main thread waits
         * until computation finishes.
         */

        int result = pool.invoke(task);

        System.out.println("\nFinal Sum = " + result);

        pool.shutdown();

    }
}


/*
 * RecursiveTask<V>
 *
 * Used whenever
 * computation RETURNS a value.
 *
 * Here
 *
 * Integer
 *
 * is the return type.
 */

class SumTask extends RecursiveTask<Integer>{

    private final int[] array;

    private final int start;

    private final int end;

    /*
     * Threshold
     *
     * Small tasks are solved directly.
     *
     * Large tasks are split.
     */

    private static final int THRESHOLD = 2;

    public SumTask(int[] array,int start,int end){

        this.array=array;

        this.start=start;

        this.end=end;

    }

    @Override
    protected Integer compute() {

        /*
         * Current task size.
         */

        int length = end-start+1;

        /*
         * Base Condition
         *
         * If task becomes small,
         * don't split anymore.
         *
         * Compute directly.
         */

        if(length<=THRESHOLD){

            int sum=0;

            for(int i=start;i<=end;i++){

                sum+=array[i];

            }

            System.out.println(

                    Thread.currentThread().getName()

                            +" directly computed "

                            +start+"-"+end

                            +" = "

                            +sum);

            return sum;

        }

        /*
         * Problem is still large.
         *
         * Divide into
         *
         * Left
         *
         * Right
         */

        int mid=(start+end)/2;

        SumTask leftTask=new SumTask(array,start,mid);

        SumTask rightTask=new SumTask(array,mid+1,end);

        /*
         * fork()
         *
         * This DOES NOT immediately
         * execute the task.
         *
         * Instead
         *
         * Current worker
         * places leftTask
         * into its own deque.
         *
         * Another worker
         * MAY steal it.
         */

        leftTask.fork();

        /*
         * Why compute() directly?
         *
         * Instead of
         *
         * fork()
         * fork()
         *
         * Java usually
         *
         * forks one task
         *
         * computes the other
         *
         * immediately.
         *
         * This reduces
         * task creation overhead.
         */

        int rightResult=rightTask.compute();

        /*
         * join()
         *
         * Wait until
         * leftTask finishes.
         *
         * Returns
         * left result.
         */

        int leftResult=leftTask.join();

        /*
         * Combine both answers.
         */

        int total=leftResult+rightResult;

        System.out.println(

                Thread.currentThread().getName()

                        +" merged "

                        +start+"-"+end

                        +" = "

                        +total);

        return total;

    }

}

