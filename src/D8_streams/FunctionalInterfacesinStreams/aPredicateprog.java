package D8_streams.FunctionalInterfacesinStreams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class aPredicateprog {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(10, 15, 20, 25, 30);

        // =====================================================
        // Anonymous Class
        // Predicate -> returns boolean
        // Used by filter()
        // =====================================================

        Predicate<Integer> even = new Predicate<Integer>() {
            @Override
            public boolean test(Integer n) {
                return n % 2 == 0;
            }
        };

        System.out.println("Anonymous Class:");
        numbers.stream()
                .filter(even)
                .forEach(System.out::println);

        // =====================================================
        // Lambda Expression
        // =====================================================

        Predicate<Integer> evenLambda = n -> n % 2 == 0;

        System.out.println("\nLambda:");
        numbers.stream()
                .filter(evenLambda)
                .forEach(System.out::println);
    }
}
