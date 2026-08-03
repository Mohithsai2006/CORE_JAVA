package D9_annotations.builtinannotations.compilertime;

// Child class
public class Dog extends Animal {
    // --------------------------------------------------
    // @Override
    //
    // Tells the compiler:
    // "This method MUST override a parent method."
    //
    // If the method name or parameters are wrong,
    // the compiler immediately reports an error.
    // --------------------------------------------------
    @Override
    public void sound() {
        System.out.println("Dog barks");
    }
    /*
    // ================= WRONG EXAMPLE 1 =================
    @Override
    public void sounds() {        // Method name is wrong
        System.out.println("Dog barks");
    }
    Compile-Time Error:
    Method does not override or implement a method
    from a supertype
    */
}