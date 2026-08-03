package D7_generics.genericsinterface;
/*
 * Compiler replaces
 *
 * T ---> String
 */
public class StringPrinter implements Printer<String> {
    @Override
    public String print() {
        return "Learning Generics";
    }
}