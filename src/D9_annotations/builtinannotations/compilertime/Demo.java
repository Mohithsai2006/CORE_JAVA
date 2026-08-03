package D9_annotations.builtinannotations.compilertime;

import java.util.ArrayList;

public class Demo {

    // ------------------------------------------------
    // Suppresses compile-time warnings.
    //
    // It DOES NOT remove runtime exceptions.
    // It ONLY hides selected compiler warnings.
    // ------------------------------------------------

    @SuppressWarnings({"deprecation","rawtypes","unchecked"})
    public static void main(String[] args) {

        System.out.println("========== @Override ==========\n");

        Animal animal = new Dog();

        // Runtime Polymorphism
        animal.sound();

        System.out.println();

        System.out.println("========== @Deprecated ==========\n");

        OldCalculator obj = new OldCalculator();

        // Normally compiler shows:
        //
        // "The method addOld() is deprecated"

        obj.addOld(10,20);

        // Recommended method

        obj.addNew(10,20);

        System.out.println();

        System.out.println("========== @SuppressWarnings ==========\n");

        // -------------------------------
        // Raw type warning
        // -------------------------------

        ArrayList list = new ArrayList();

        list.add("Java");

        // -------------------------------
        // Unchecked warning
        // -------------------------------

        ArrayList<String> names = list;

        System.out.println(names.get(0));

        /*
        Remove @SuppressWarnings

        Compiler shows:

        Raw type warning

        Unchecked conversion warning

        Deprecation warning

        Program still executes.

        */

    }

}