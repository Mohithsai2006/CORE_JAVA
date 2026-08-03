package D10_Collections.ListInterface.Vector.Stack;
import java.util.Stack;

/*
 * ============================================================================
 *                           STACK - DEMO 2
 * ============================================================================
 *
 * Definition
 * ----------
 * This demo covers the methods that make Stack different from Vector.
 *
 * Stack follows
 *
 * LIFO
 *
 * Last In First Out
 *
 * Meaning:
 *
 * The last element inserted becomes the first element removed.
 *
 *
 * ============================================================================
 * STACK SPECIFIC METHODS
 * ============================================================================
 *
 * push()
 * -------
 * Inserts an element at the top of the stack.
 *
 *
 * pop()
 * ------
 * Removes and returns the top element.
 *
 *
 * peek()
 * -------
 * Returns the top element without removing it.
 *
 *
 * empty()
 * --------
 * Checks whether stack is empty.
 *
 *
 * search()
 * ---------
 * Returns position of an element from the top.
 *
 *
 * ============================================================================
 * LIFO REPRESENTATION
 * ============================================================================
 *
 * push(A)
 *
 * Top
 *  │
 *  ▼
 * [A]
 *
 *
 * push(B)
 *
 * Top
 *  │
 *  ▼
 * [B]
 * [A]
 *
 *
 * push(C)
 *
 * Top
 *  │
 *  ▼
 * [C]
 * [B]
 * [A]
 *
 *
 * pop()
 *
 * Removes C
 *
 * Top
 *  │
 *  ▼
 * [B]
 * [A]
 *
 * ============================================================================
 */

public class Demo2 {

    public static void main(String[] args) {

        Stack<Student> students = new Stack<>();


        /*
         * =====================================================
         * empty()
         * =====================================================
         */

        System.out.println("Is Stack Empty ? "
                + students.empty());


        /*
         * =====================================================
         * push()
         * =====================================================
         *
         * Adds element at TOP.
         */

        students.push(
                new Student(
                        101,
                        "Mohith",
                        91));

        students.push(
                new Student(
                        102,
                        "Rahul",
                        82));

        students.push(
                new Student(
                        103,
                        "Sai",
                        88));

        students.push(
                new Student(
                        104,
                        "Ajay",
                        95));



        System.out.println("\n========== AFTER PUSH ==========");

        System.out.println(students);



        /*
         * Internal View
         *
         * Top
         *  |
         *  V
         * Ajay
         * Sai
         * Rahul
         * Mohith
         */


        /*
         * =====================================================
         * peek()
         * =====================================================
         *
         * Returns top element
         * without removing it.
         */

        System.out.println("\nTop Element Using peek()");

        System.out.println(students.peek());



        System.out.println("\nStack After peek()");

        System.out.println(students);

        /*
         * Observe:
         *
         * No element removed.
         */


        /*
         * =====================================================
         * search()
         * =====================================================
         *
         * Returns position from TOP.
         *
         * Top element = position 1
         */

        System.out.println("\n========== SEARCH ==========");

        System.out.println(
                "Position Of Ajay : "
                        + students.search(
                        students.get(3)));



        System.out.println(
                "Position Of Mohith : "
                        + students.search(
                        students.get(0)));



        /*
         * Current Stack
         *
         * Position 1 -> Ajay
         * Position 2 -> Sai
         * Position 3 -> Rahul
         * Position 4 -> Mohith
         */


        /*
         * =====================================================
         * pop()
         * =====================================================
         *
         * Removes TOP element.
         */

        System.out.println("\n========== POP ==========");

        Student removed =
                students.pop();

        System.out.println(
                "Removed Student : "
                        + removed);
        System.out.println(
                "\nStack After pop()");
        System.out.println(students);
        /*
         * Another pop
         */
        removed = students.pop();
        System.out.println(
                "\nRemoved Student : "
                        + removed);
        System.out.println(
                "\nStack After Second pop()");
        System.out.println(students);

        /*
         * Current Stack
         *
         * Top
         *  |
         *  V
         * Rahul
         * Mohith
         */

        /*
         * =====================================================
         * peek() Again
         * =====================================================
         */
        System.out.println(
                "\nCurrent Top Element");
        System.out.println(
                students.peek());
        /*
         * =====================================================
         * empty()
         * =====================================================
         */
        System.out.println(
                "\nIs Empty ? "
                        + students.empty());
        /*
         * Remove all elements
         */
        while (!students.empty()) {

            System.out.println(
                    "\nPopped : "
                            + students.pop());

        }
        System.out.println(
                "\nIs Empty After Removing All ? "
                        + students.empty());


        /*
         * =====================================================
         * EXCEPTION DEMO
         * =====================================================
         *
         * Uncomment to observe:
         *
         * EmptyStackException
         */

        // students.pop();

        // students.peek();

    }

}