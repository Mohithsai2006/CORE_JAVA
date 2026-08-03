package D12_Multithreadinginjava.cThreadClass;
/*
===============================================================================
Demo 2 : Main Thread vs Child Thread
===============================================================================

Topics Covered
--------------
1. Creating a child thread
2. start()
3. currentThread()
4. getName()
5. setName()
6. getId()
7. getPriority()
8. setPriority()
9. isAlive()

Purpose
-------
Until now we worked only with the Main Thread.

Now we'll create another Thread object and observe:

    • Main Thread
    • Child Thread

Both execute inside the SAME Java Process.

IMPORTANT

Thread t = new MyThread();

Only creates a Thread OBJECT in Heap.

It DOES NOT create

❌ Java Stack
❌ PC Register
❌ Native OS Thread

Only after

    t.start();

does JVM request the Operating System to create an actual execution thread.

===============================================================================
*/

class MyThread extends Thread {

    @Override
    public void run() {

        /*
        currentThread() returns the thread that is
        ACTUALLY executing this run() method.

        Here it returns Child Thread,
        NOT Main Thread.
        */

        Thread current = Thread.currentThread();

        System.out.println("\n========= CHILD THREAD =========");

        System.out.println("Name      : " + current.getName());
        System.out.println("ID        : " + current.getId());
        System.out.println("Priority  : " + current.getPriority());
        System.out.println("Alive     : " + current.isAlive());

        System.out.println("Executing Child Thread Work...");
    }
}

public class Demo2 {

    public static void main(String[] args) {

        /*
        -------------------------------------------------------
        MAIN THREAD
        -------------------------------------------------------
        */

        Thread mainThread = Thread.currentThread();

        mainThread.setName("Application-Main");
        mainThread.setPriority(Thread.MAX_PRIORITY);

        System.out.println("========= MAIN THREAD =========");

        System.out.println("Name      : " + mainThread.getName());
        System.out.println("ID        : " + mainThread.getId());
        System.out.println("Priority  : " + mainThread.getPriority());
        System.out.println("Alive     : " + mainThread.isAlive());


        /*
        -------------------------------------------------------
        Creating Thread Object

        Heap

        +-------------------------+
        | MyThread Object         |
        | state = NEW            |
        | nativeThread = null    |
        +-------------------------+

        Still NO execution thread.
        -------------------------------------------------------
        */

        MyThread child = new MyThread();



        /*
        Default values assigned by JVM.
        */

        System.out.println("\nBefore Changes");

        System.out.println("Child Name     : " + child.getName());
        System.out.println("Child Priority : " + child.getPriority());
        System.out.println("Child Alive    : " + child.isAlive());



        /*
        Modify metadata.

        Still thread state = NEW.
        */

        child.setName("Payment-Service");

        child.setPriority(Thread.MIN_PRIORITY);

        System.out.println("\nAfter Metadata Changes");

        System.out.println("Child Name     : " + child.getName());
        System.out.println("Child Priority : " + child.getPriority());



        /*
        =======================================================

        THIS IS THE IMPORTANT LINE.

        JVM internally performs:

        start()
             |
             ▼
        start0()   (Native Method)
             |
             ▼
        Operating System
             |
             ▼
        Creates Native Thread
             |
             ▼
        Allocates Java Stack
             |
             ▼
        Allocates PC Register
             |
             ▼
        Scheduler
             |
             ▼
        Eventually invokes run()

        =======================================================
        */

        child.start();



        /*
        Main thread continues independently.

        We have NOT used join(),
        so execution order is NOT guaranteed.
        */

        System.out.println("\nMain Thread Continues...");



        /*
        Child has been started.

        Usually true here.

        (May become false quickly if child already finishes.)
        */

        System.out.println("Child Alive : " + child.isAlive());

        System.out.println("Main Thread Finished.");
    }
}