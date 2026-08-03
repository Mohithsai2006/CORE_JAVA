package D9_annotations.builtinannotations.functionalannotations;

import java.util.List;

public class Demo {

    public static void main(String[] args) {

        System.out.println("========== @FunctionalInterface ==========\n");

        // Lambda Expression

        Printer printer = msg ->
                System.out.println("Message : " + msg);

        printer.start();

        printer.print("Hello Java");

        Printer.stop();

        System.out.println();

        System.out.println("========== @SafeVarargs ==========\n");

        List<String> list1 =
                List.of("Java","Spring");

        List<String> list2 =
                List.of("Hibernate","JPA");

        Utility.printLists(list1,list2);

    }

}
