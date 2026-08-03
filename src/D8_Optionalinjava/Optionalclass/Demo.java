package D8_Optionalinjava.Optionalclass;

import java.util.Optional;

public class Demo {

    public static void main(String[] args) {

        Student student = new Student(101, "Mohith", 92.5);

        Student nullStudent = null;

        /*
         * ==========================================================
         * Optional.of()
         * ==========================================================
         *
         * Creates Optional containing a NON-NULL object.
         *
         * If null is passed,
         * it immediately throws NullPointerException.
         */

        Optional<Student> op1 = Optional.of(student);

        System.out.println("Optional.of()");
        System.out.println(op1);

        System.out.println();


        /*
         * ==========================================================
         * Optional.ofNullable()
         * ==========================================================
         *
         * Creates Optional from an object that
         * may or may not be null.
         *
         * If object is null,
         * it returns Optional.empty()
         * instead of throwing exception.
         */

        Optional<Student> op2 = Optional.ofNullable(student);

        Optional<Student> op3 = Optional.ofNullable(nullStudent);

        System.out.println("Optional.ofNullable()");

        System.out.println(op2);

        System.out.println(op3);

        System.out.println();


        /*
         * ==========================================================
         * Optional.empty()
         * ==========================================================
         *
         * Creates an empty Optional.
         */

        Optional<Student> op4 = Optional.empty();

        System.out.println("Optional.empty()");

        System.out.println(op4);

        System.out.println();


        /*
         * ==========================================================
         * isPresent()
         * ==========================================================
         *
         * Checks whether Optional contains a value.
         *
         * Returns:
         * true  -> value exists
         * false -> empty Optional
         */

        System.out.println("isPresent()");

        System.out.println(op1.isPresent());

        System.out.println(op4.isPresent());

        System.out.println();


        /*
         * ==========================================================
         * get()
         * ==========================================================
         *
         * Returns the object inside Optional.
         *
         * Use only when you are sure
         * value is present.
         *
         * Calling get() on empty Optional
         * throws NoSuchElementException.
         */

        System.out.println("get()");

        Student s = op1.get();

        System.out.println(s);

        System.out.println();


        /*
         * ==========================================================
         * ifPresent()
         * ==========================================================
         *
         * Executes given code only
         * if value exists.
         *
         * Nothing happens if Optional is empty.
         */

        System.out.println("ifPresent()");

        op1.ifPresent(stu -> System.out.println(stu.getName()));

        op4.ifPresent(stu -> System.out.println(stu));

    }
}
