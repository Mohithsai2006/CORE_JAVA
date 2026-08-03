package D8_streams.FunctionalInterfacesinStreams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class bFunction {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("John", "Alex", "David");

        // =====================================================
        // Anonymous Class
        // Function -> Converts one type into another
        // Used by map()
        // =====================================================

        Function<String, Integer> length = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        };

        System.out.println("Anonymous Class:");
        names.stream()
                .map(length)
                .forEach(System.out::println);

        // =====================================================
        // Lambda Expression
        // =====================================================

        Function<String, Integer> lengthLambda = s -> s.length();

        System.out.println("\nLambda:");
        names.stream()
                .map(lengthLambda)
                .forEach(System.out::println);
    }
}
