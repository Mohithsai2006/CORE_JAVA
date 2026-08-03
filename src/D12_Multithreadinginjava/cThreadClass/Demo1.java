package D12_Multithreadinginjava.cThreadClass;
/*
===============================================================================
Demo 1 : Thread Metadata Methods
===============================================================================

Topics Covered
--------------
1. Thread.currentThread()
2. getName()
3. setName()
4. getId()
5. getPriority()
6. setPriority()
7. isAlive()

Goal
----
Understand how the JVM represents the currently executing thread and how
thread metadata can be inspected and modified.

Important
---------
Only the Main Thread exists initially.

When JVM starts your Java application:

Operating System
      │
      ▼
Creates Java Process
      │
      ▼
Starts JVM
      │
      ▼
Creates Runtime Memory
      │
      ▼
Creates Main Thread
      │
      ▼
Calls main()

The main() method always executes on the Main Thread.

Thread.currentThread() returns the Thread object representing
the thread currently executing this code.

It DOES NOT create a new thread.

It simply returns a reference to an already existing Thread object.

===============================================================================
*/

public class Demo1 {

    public static void main(String[] args) {

        /*
        -----------------------------------------------------------
        currentThread()

        Internally

        Main Thread Stack
                │
                ▼
        JVM knows which thread is executing
                │
                ▼
        Returns reference to Thread object in Heap

        No new object is created.
        -----------------------------------------------------------
        */

        Thread t = Thread.currentThread();



        /*
        -----------------------------------------------------------
        getName()

        Every thread has a name.

        Main thread default name:

            main

        Child threads:

            Thread-0
            Thread-1
            Thread-2

        Names are mainly useful for debugging.
        -----------------------------------------------------------
        */

        System.out.println("Thread Name : " + t.getName());



        /*
        -----------------------------------------------------------
        getId()

        Every thread has a unique ID assigned by JVM.

        IDs are never reused while JVM is running.

        Main thread generally has ID = 1
        (implementation detail, don't depend on it)

        Used for

        ✔ Debugging
        ✔ Thread dumps
        ✔ Monitoring
        -----------------------------------------------------------
        */

        System.out.println("Thread ID   : " + t.getId());



        /*
        -----------------------------------------------------------
        getPriority()

        Default Priority = 5

        Constants

        MIN_PRIORITY  = 1
        NORM_PRIORITY = 5
        MAX_PRIORITY  = 10

        Priority is only a scheduling HINT.

        Operating System scheduler may ignore it.
        -----------------------------------------------------------
        */

        System.out.println("Priority    : " + t.getPriority());



        /*
        -----------------------------------------------------------
        isAlive()

        Returns true if thread has started
        and has not yet terminated.

        Main thread is currently executing,
        therefore it is alive.
        -----------------------------------------------------------
        */

        System.out.println("Alive       : " + t.isAlive());



        /*
        -----------------------------------------------------------
        setName()

        Changes only thread metadata.

        It DOES NOT create a new thread.

        It DOES NOT restart thread.

        It simply updates the 'name' field
        inside Thread object.
        -----------------------------------------------------------
        */

        t.setName("Application-Main-Thread");

        System.out.println("\nAfter Renaming");

        System.out.println("Thread Name : " + t.getName());



        /*
        -----------------------------------------------------------
        setPriority()

        Updates priority field inside Thread object.

        JVM may notify underlying OS scheduler.

        Actual execution order is NOT guaranteed.
        -----------------------------------------------------------
        */

        t.setPriority(Thread.MAX_PRIORITY);

        System.out.println("Priority    : " + t.getPriority());



        /*
        Again checking alive status.

        Thread still running.
        */

        System.out.println("Alive       : " + t.isAlive());

    }
}