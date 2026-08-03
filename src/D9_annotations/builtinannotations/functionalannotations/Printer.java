package D9_annotations.builtinannotations.functionalannotations;

// ------------------------------------------------------
// @FunctionalInterface
//
// Tells the compiler that this interface MUST contain
// exactly ONE abstract method.
//
// It may contain:
//
// ✔ One abstract method
// ✔ Any number of default methods
// ✔ Any number of static methods
// ✔ Methods inherited from Object
//
// But NOT two abstract methods.
// ------------------------------------------------------

@FunctionalInterface
public interface Printer {
    // Only abstract method
    void print(String msg);
    // Default methods are allowed
    default void start() {
        System.out.println("Printer Started");
    }
    // Static methods are also allowed
    static void stop() {
        System.out.println("Printer Stopped");
    }
    /*
    // ---------------- WRONG EXAMPLE ----------------

    void show();

    Compiler Error:

    Unexpected @FunctionalInterface annotation

    Printer is not a functional interface

    Multiple non-overriding abstract methods found.

    */
}