package D7_generics.genericsinmethods;
public class Demo {
    /*
     * ========= BEFORE GENERICS =========
     *
     * To swap Integer values
     *      swapInteger()
     *
     * To swap String values
     *      swapString()
     *
     * To swap Double values
     *      swapDouble()
     *
     * Same logic...
     * Only datatype changes.
     */
    // Swap for Integer
    static void swapInteger(Integer a, Integer b) {
        Integer temp = a;
        a = b;
        b = temp;
        System.out.println("After Integer Swap : " + a + " " + b);
    }
    // Swap for String
    static void swapString(String a, String b) {
        String temp = a;
        a = b;
        b = temp;
        System.out.println("After String Swap : " + a + " " + b);
    }
    /*
     * ========= GENERIC METHOD =========
     * Instead of writing
     * swapInteger()
     * swapString()
     * swapDouble()
     * swapStudent()
     * We write ONE method.
     */
    // <T> declares this as a Generic Method.
    // Compiler decides what T is while calling the method.
    static <T> void swap(T a, T b) {
        T temp = a;
        a = b;
        b = temp;
        System.out.println("After Generic Swap : " + a + " " + b);
    }
    public static void main(String[] args) {
        /*
         * Duplicate methods before Generics.
         */
        swapInteger(10, 20);
        swapString("Java", "Python");
        System.out.println();
        /*
         * Compiler replaces
         *
         * T ---> Integer
         */
        swap(100, 200);
        /*
         * Compiler replaces
         *
         * T ---> String
         */
        swap("Hello", "World");
        /*
         * Compiler replaces
         *
         * T ---> Double
         *
        swap(10.5, 20.5);


        /*
         * Compiler replaces
         *
         * T ---> Character
         */

        swap('A', 'Z');
    }
}