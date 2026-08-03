package D10_Collections.SetInterface.ConcurrentSkipListSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListSet;
public class Demo2 {
    public static void main(String[] args) throws InterruptedException {
        /*
         * ==========================================================
         * DEMO 1
         * Weakly Consistent Iterator
         * ==========================================================
         */
        ConcurrentSkipListSet<Integer> set =
                new ConcurrentSkipListSet<>();
        set.add(10);
        set.add(20);
        set.add(30);
        set.add(40);
        set.add(50);
        /*
         * Internally Skip List may look like
         *
         * Level 2
         *
         * HEAD ------------------------50
         *
         * Level 1
         *
         * HEAD------20------40---------50
         *
         * Level 0
         *
         * HEAD-10-20-30-40-50
         */

        System.out.println("Original Set : " + set);

        /*
         * Iterator starts.
         *
         * Unlike TreeSet,
         * this iterator is NOT Fail-Fast.
         *
         * It is Weakly Consistent.
         */

        Iterator<Integer> iterator = set.iterator();

        /*
         * Modify collection AFTER iterator creation.
         */

        set.add(60);

        set.remove(20);

        System.out.println("Modified Set : " + set);

        System.out.println();

        System.out.println("Iterator Output");

        /*
         * Depending on timing,
         * iterator MAY
         *
         * or
         *
         * MAY NOT
         *
         * see 60.
         *
         * It will NEVER throw
         * ConcurrentModificationException.
         */

        while(iterator.hasNext())
        {
            System.out.println(iterator.next());
        }

        System.out.println();

        /*
         * ==========================================================
         * DEMO 2
         * Sorted Order
         * ==========================================================
         */

        ConcurrentSkipListSet<Integer> numbers =
                new ConcurrentSkipListSet<>();

        numbers.add(90);
        numbers.add(10);
        numbers.add(70);
        numbers.add(40);
        numbers.add(30);

        /*
         * Even though inserted randomly,
         * Skip List always maintains
         * sorted order.
         */

        System.out.println(numbers);

        System.out.println();

        /*
         * ==========================================================
         * DEMO 3
         * Duplicate Detection
         * ==========================================================
         */

        /*
         * compareTo()==0
         *
         * Duplicate.
         */

        System.out.println(
                numbers.add(40)
        );

        System.out.println(numbers);

        System.out.println();

        /*
         * ==========================================================
         * DEMO 4
         * Null Handling
         * ==========================================================
         */

        /*
         * Skip List requires comparison.
         *
         * compareTo(null)
         * is impossible.
         */

        try
        {
            numbers.add(null);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        System.out.println();

        /*
         * ==========================================================
         * DEMO 5
         * Multiple Threads
         * ==========================================================
         */

        ConcurrentSkipListSet<Integer> concurrent =
                new ConcurrentSkipListSet<>();

        Thread writer =
                new Thread(() -> {

                    /*
                     * Thread continuously inserts.
                     */

                    for(int i=1;i<=10;i++)
                    {
                        concurrent.add(i);

                        System.out.println(
                                "Writer Added : " + i
                        );

                        try
                        {
                            Thread.sleep(100);
                        }
                        catch(Exception ignored){}
                    }

                });

        Thread reader =
                new Thread(() -> {

                    /*
                     * Reader thread.
                     *
                     * Multiple reads
                     * while writer modifies.
                     */

                    for(int i=1;i<=10;i++)
                    {
                        System.out.println(
                                "Reader Sees : "
                                        + concurrent
                        );

                        try
                        {
                            Thread.sleep(120);
                        }
                        catch(Exception ignored){}
                    }

                });

        writer.start();

        reader.start();

        writer.join();

        reader.join();

        System.out.println();

        /*
         * ==========================================================
         * DEMO 6
         * TreeSet Comparison
         * ==========================================================
         */

        TreeSet<Integer> tree =
                new TreeSet<>();

        tree.add(10);
        tree.add(20);
        tree.add(30);
        tree.add(40);

        try
        {
            /*
             * TreeSet Iterator
             * is Fail-Fast.
             */

            Iterator<Integer> itr =
                    tree.iterator();

            tree.add(50);

            while(itr.hasNext())
            {
                System.out.println(
                        itr.next()
                );
            }

        }
        catch(Exception e)
        {
            System.out.println();

            System.out.println(
                    "TreeSet : " + e
            );
        }

        System.out.println();

        /*
         * ==========================================================
         * DEMO 7
         * ConcurrentSkipListSet Comparison
         * ==========================================================
         */

        ConcurrentSkipListSet<Integer> skip =
                new ConcurrentSkipListSet<>();

        skip.add(10);
        skip.add(20);
        skip.add(30);

        Iterator<Integer> skipIterator =
                skip.iterator();

        /*
         * Modify after iterator creation.
         */

        skip.add(40);

        System.out.println(
                "ConcurrentSkipListSet Iterator"
        );

        while(skipIterator.hasNext())
        {
            System.out.println(
                    skipIterator.next()
            );
        }

        /*
         * No exception.
         *
         * Weakly Consistent Iterator.
         */

        System.out.println();

        System.out.println(skip);

    }

}