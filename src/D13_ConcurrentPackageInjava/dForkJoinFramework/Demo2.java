package D13_ConcurrentPackageInjava.dForkJoinFramework;
import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class Demo2 {

    public static void main(String[] args) {

        /*
         * Original Array.
         */

        int[] numbers={10,20,30,40,50,60,70,80};

        System.out.println("Before");

        System.out.println(Arrays.toString(numbers));

        /*
         * ForkJoinPool
         *
         * Executes recursive tasks.
         */

        ForkJoinPool pool=new ForkJoinPool();

        /*
         * RecursiveAction
         *
         * Performs work
         *
         * WITHOUT
         * returning any value.
         */

        MultiplyTask task=

                new MultiplyTask(numbers,0,numbers.length-1);

        /*
         * invoke()
         *
         * Waits until
         * complete task finishes.
         */

        pool.invoke(task);

        System.out.println();

        System.out.println("After");

        System.out.println(Arrays.toString(numbers));

        pool.shutdown();

    }

}


/*
 * RecursiveAction
 *
 * Similar to RecursiveTask.
 *
 * Difference
 *
 * No return value.
 */

class MultiplyTask extends RecursiveAction{

    private final int[] array;

    private final int start;

    private final int end;

    private static final int THRESHOLD=2;

    MultiplyTask(int[] array,int start,int end){

        this.array=array;

        this.start=start;

        this.end=end;

    }

    @Override
    protected void compute() {

        int length=end-start+1;

        /*
         * Small task.
         *
         * Directly process.
         */

        if(length<=THRESHOLD){

            for(int i=start;i<=end;i++){

                array[i]*=2;

            }

            System.out.println(

                    Thread.currentThread().getName()

                            +" processed "

                            +start

                            +" - "

                            +end);

            return;

        }

        /*
         * Split task.
         */

        int mid=(start+end)/2;

        MultiplyTask left=

                new MultiplyTask(array,start,mid);

        MultiplyTask right=

                new MultiplyTask(array,mid+1,end);

        /*
         * invokeAll()
         *
         * Internally
         *
         * Forks both tasks.
         *
         * Waits until
         * both complete.
         *
         * Equivalent to
         *
         * left.fork();
         * right.fork();
         * left.join();
         * right.join();
         *
         * but more convenient.
         */

        invokeAll(left,right);

        /*
         * Since RecursiveAction
         * returns nothing,
         * no merge step
         * is required.
         */

    }

}