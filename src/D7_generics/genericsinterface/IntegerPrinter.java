package D7_generics.genericsinterface;
/*
 * Compiler replaces
 *
 * T ---> Integer
 */
public class IntegerPrinter implements Printer<Integer> {
    @Override
    public Integer print() {

        return 100;
    }
}
