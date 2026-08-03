package D12_Multithreadinginjava.bthreadscreation;

public class cLambdaExp {
    public static void main(String[] args) throws Exception {
        Runnable task=()->{

            System.out.println(Thread.currentThread().getName());

        };
        Thread t1=new Thread(task);
        t1.start();
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(2000);

        Thread t2=new Thread(()->{

            System.out.println(Thread.currentThread().getName());
        });
        t2.start();

    }
}
