package D8_streams.FunctionalInterfacesinStreams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class dComparator {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(40, 10, 30, 20);

        // =====================================================
        // Anonymous Class
        // Comparator -> Compares two objects
        // Used by sorted()
        // =====================================================

        Comparator<Integer> ascending = new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        };

        System.out.println("Anonymous Class:");
        numbers.stream()
                .sorted(ascending)
                .forEach(System.out::println);

        // =====================================================
        // Lambda Expression
        // =====================================================

        Comparator<Integer> ascendingLambda = (a, b) -> a - b;

        System.out.println("\nLambda:");
        numbers.stream()
                .sorted(ascendingLambda)
                .forEach(System.out::println);
    }
}