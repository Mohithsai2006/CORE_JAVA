package D10_Collections.Linkedlist;
import java.util.LinkedList;
/*
 * ============================================================================
 *                        LINKEDLIST - DEMO 1
 * ============================================================================
 *
 * Definition
 * ----------
 * LinkedList is a class that implements both
 *
 *      1. List
 *      2. Deque
 *
 * interfaces.
 *
 * Unlike ArrayList and Vector,
 * LinkedList DOES NOT store elements inside
 * a dynamic array.
 *
 * Instead,
 * every inserted element is stored inside
 * an individual Node object.
 *
 *
 * ============================================================================
 * INTERNAL NODE STRUCTURE
 * ============================================================================
 *
 * Java internally maintains a
 * Doubly Linked List.
 *
 * Every inserted element creates one Node.
 *
 * Internal representation of a Node
 *
 *                ┌──────────────────────────────┐
 *                │           Node<E>            │
 *                ├──────────────────────────────┤
 *                │ prev │ element │ next        │
 *                └──────────────────────────────┘
 *
 *
 * Example
 *
 * first
 *   │
 *   ▼
 *
 * null ← [Mohith] ⇄ [Rahul] ⇄ [Sai] ⇄ [Ajay] → null
 *
 *                                           ▲
 *                                           │
 *                                          last
 *
 *
 * Every Node stores
 *
 * ✔ Previous Node Reference
 * ✔ Actual Data
 * ✔ Next Node Reference
 *
 *
 * ============================================================================
 * PURPOSE
 * ============================================================================
 *
 * ✔ Frequent insertion
 * ✔ Frequent deletion
 * ✔ Queue implementation
 * ✔ Deque implementation
 * ✔ Stack implementation
 *
 *
 * ============================================================================
 * IMPORTANT INTERVIEW POINTS
 * ============================================================================
 *
 * 1. Default Capacity : Not Applicable
 *
 * Why?
 * ----
 * LinkedList does not use an internal array.
 *
 * Every insertion creates one new Node.
 *
 *
 * ----------------------------------------------------------------
 *
 * 2. Initial Size : 0
 *
 * Why?
 * ----
 * Initially there are no nodes.
 *
 *
 * ----------------------------------------------------------------
 *
 * 3. Capacity Growth : Not Applicable
 *
 * Why?
 * ----
 * Memory increases node by node.
 *
 * No resizing
 * No copying
 * No reallocation
 *
 *
 * ----------------------------------------------------------------
 *
 * 4. Duplicate Elements : YES
 *
 * Why?
 * ----
 * LinkedList implements List.
 *
 *
 * ----------------------------------------------------------------
 *
 * 5. Null Values : YES
 *
 * Why?
 * ----
 * Node data may store null reference.
 *
 *
 * ----------------------------------------------------------------
 *
 * 6. Insertion Order : YES
 *
 * Why?
 * ----
 * Nodes are linked in the order
 * they are inserted.
 *
 *
 * ----------------------------------------------------------------
 *
 * 7. Sorted Order : NO
 *
 * Why?
 * ----
 * LinkedList never sorts automatically.
 *
 *
 * ----------------------------------------------------------------
 *
 * 8. Random Access : NO
 *
 * Why?
 * ----
 * To reach index 50,
 * Java traverses node by node.
 *
 * first
 *   ↓
 * Node1
 *   ↓
 * Node2
 *   ↓
 * Node3
 *   ↓
 * ....
 *
 * Therefore,
 *
 * get(index)
 *
 * takes O(n)
 *
 *
 * ----------------------------------------------------------------
 *
 * 9. Thread Safe : NO
 *
 * Why?
 * ----
 * Methods are not synchronized.
 *
 *
 * ----------------------------------------------------------------
 *
 * 10. Best Use Case
 *
 * Frequent insertion
 * Frequent deletion
 * Queue
 * Deque
 *
 *
 * ============================================================================
 * DEMO 1 TOPICS
 * ============================================================================
 *
 * ✔ Creation
 * ✔ Addition
 * ✔ Retrieval
 * ✔ Updation
 * ✔ Verification
 * ✔ Deletion
 * ✔ getFirst()
 * ✔ getLast()
 * ✔ removeFirst()
 * ✔ removeLast()
 *
 * ============================================================================
 */

public class Demo1 {

    public static void main(String[] args) {

        /*
         * Creates an empty LinkedList.
         *
         * Initially
         *
         * first = null
         * last = null
         * size = 0
         */

        LinkedList<Student> students = new LinkedList<>();


        System.out.println("========== INITIAL DETAILS ==========");

        System.out.println("Initial Size : "
                + students.size());

        System.out.println("Is Empty : "
                + students.isEmpty());


        /*
         * =====================================================
         * ADD OPERATION
         * =====================================================
         *
         * Every add() creates one new Node.
         */

        students.add(
                new Student(101,
                        "Mohith",
                        91));

        students.add(
                new Student(102,
                        "Rahul",
                        84));

        students.add(
                new Student(103,
                        "Sai",
                        88));

        students.add(
                new Student(104,
                        "Ajay",
                        95));

        /*
         * Insert at a specific index.
         *
         * Java traverses to that position,
         * creates a new Node,
         * updates prev and next references.
         */

        students.add(2,
                new Student(
                        105,
                        "Kiran",
                        86));



        System.out.println("\n========== AFTER INSERTION ==========");

        System.out.println(students);


        /*
         * =====================================================
         * RETRIEVAL
         * =====================================================
         */

        System.out.println("\nFirst Student");

        System.out.println(
                students.getFirst());



        System.out.println("\nLast Student");

        System.out.println(
                students.getLast());



        System.out.println("\nStudent At Index 2");

        System.out.println(
                students.get(2));



        /*
         * =====================================================
         * UPDATE
         * =====================================================
         *
         * Only the data stored inside the Node changes.
         *
         * Node links remain unchanged.
         */

        students.set(1,
                new Student(
                        200,
                        "Updated Rahul",
                        99));



        System.out.println("\n========== AFTER UPDATE ==========");

        System.out.println(students);



        /*
         * =====================================================
         * VERIFICATION
         * =====================================================
         */

        System.out.println("\nCurrent Size : "
                + students.size());



        System.out.println(
                "Contains First Student : "
                        + students.contains(
                        students.getFirst()));



        System.out.println(
                "Index Of First Student : "
                        + students.indexOf(
                        students.getFirst()));



        System.out.println(
                "Is Empty : "
                        + students.isEmpty());



        /*
         * =====================================================
         * DELETE
         * =====================================================
         */

        /*
         * Removes Node at index 2.
         *
         * Previous node is linked
         * directly to the next node.
         */

        students.remove(2);



        /*
         * Removes first Node.
         */

        students.removeFirst();



        /*
         * Removes last Node.
         */

        students.removeLast();



        System.out.println("\n========== AFTER DELETION ==========");

        System.out.println(students);



        /*
         * =====================================================
         * FINAL DETAILS
         * =====================================================
         */

        System.out.println("\nFinal Size : "
                + students.size());



        if (!students.isEmpty()) {

            System.out.println("First Node : "
                    + students.getFirst());

            System.out.println("Last Node : "
                    + students.getLast());

        }

    }

}