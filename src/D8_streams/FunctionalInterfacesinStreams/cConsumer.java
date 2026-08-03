package D8_streams.FunctionalInterfacesinStreams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class cConsumer {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Java", "Python", "Spring");

        // =====================================================
        // Anonymous Class
        // Consumer -> Consumes object (returns void)
        // Used by forEach()
        // =====================================================

        Consumer<String> print = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        System.out.println("Anonymous Class:");
        names.stream()
                .forEach(print);

        // =====================================================
        // Lambda Expression
        // =====================================================

        Consumer<String> printLambda = s -> System.out.println(s);

        System.out.println("\nLambda:");
        names.stream()
                .forEach(printLambda);
    }
}