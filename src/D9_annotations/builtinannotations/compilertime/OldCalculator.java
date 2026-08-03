package D9_annotations.builtinannotations.compilertime;


// Demonstrates @Deprecated
public class OldCalculator {

    // ---------------------------------------------
    // This method should no longer be used.
    // Compiler will show a warning whenever
    // another class calls this method.
    // ---------------------------------------------

    @Deprecated
    public void addOld(int a, int b) {

        System.out.println("Old Addition : " + (a + b));

    }

    // Preferred method

    public void addNew(int a, int b) {

        System.out.println("New Addition : " + (a + b));

    }

}
