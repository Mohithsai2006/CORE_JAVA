package D9_annotations.builtinannotations.functionalannotations;

import java.util.List;

public class Utility {

    // ---------------------------------------------------
    // @SafeVarargs
    //
    // Generic varargs may produce a warning because
    // arrays and generics don't work perfectly together.
    //
    // By writing @SafeVarargs, we promise the compiler
    // that this method does NOT perform unsafe operations
    // on the varargs array.
    //
    // It can be applied only to:
    // ✔ static methods
    // ✔ final methods
    // ✔ private methods (Java 9+)
    // ✔ constructors
    // ---------------------------------------------------

    @SafeVarargs
    public static void printLists(List<String>... lists) {

        System.out.println("Printing Lists");

        for (List<String> list : lists) {

            System.out.println(list);

        }

    }

    /*
    // ---------------- UNSAFE EXAMPLE ----------------

    public static void wrong(List<String>... lists){

        Object[] obj = lists;

        obj[0] = List.of(100);

        String s = lists[0].get(0);

        Runtime:

        ClassCastException

    }

    This is called Heap Pollution.

    Therefore compiler normally shows a warning.

    @SafeVarargs tells compiler:

    "Trust me.
    I am NOT doing such unsafe operations."

    */

}