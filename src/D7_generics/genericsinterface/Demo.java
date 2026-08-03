package D7_generics.genericsinterface;
public class Demo {
    public static void main(String[] args) {
        /*
         * Before Generics
         *
         * Object value = printer.print();
         *
         * String s = (String)value;
         *
         * Explicit casting required.
         */
        /*
         * Compiler knows
         *
         * print() returns String.
         */
        Printer<String> stringPrinter = new StringPrinter();
        String message = stringPrinter.print();
        System.out.println(message);
        /*
         * Compiler knows
         *
         * print() returns Integer.
         */
        Printer<Integer> integerPrinter = new IntegerPrinter();
        Integer number = integerPrinter.print();
        System.out.println(number);
        /*
         * Wrong assignment.
         */
        // String s = integerPrinter.print();
        // Compile-Time Error
    }
}
