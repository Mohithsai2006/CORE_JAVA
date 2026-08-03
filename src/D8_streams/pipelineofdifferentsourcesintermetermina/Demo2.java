package D8_streams.pipelineofdifferentsourcesintermetermina;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo2 {
    public static void main(String[] args) {
        String[] fruits = {
                "Apple",
                "Orange",
                "Apple",
                "Mango",
                "Banana"
        };
        /*
         * Array
         *  ↓
         * Arrays.stream()
         *  ↓
         * distinct()
         *  ↓
         * sorted()
         *  ↓
         * peek()
         *  ↓
         * collect()
         */
        List<String> result = Arrays.stream(fruits)
                // Source:
                // Creates Stream from Array
                .distinct()
                // Intermediate:
                // Removes duplicate elements
                //
                // Before:
                // Apple Orange Apple Mango Banana
                //
                // After:
                // Apple Orange Mango Banana
                .sorted()
                // Intermediate:
                // Sorts in natural order
                //
                // Apple Banana Mango Orange
                .peek(System.out::println)
                // Intermediate:
                // Performs action on each element
                // Does NOT modify data
                // Mostly used for debugging
                .collect(Collectors.toList());
        // Terminal:
        // Collects Stream elements into List
        System.out.println("\nCollected List:");
        System.out.println(result);
        System.out.println("\n========================");
        /*
         * Stream.of()
         *      ↓
         * distinct()
         *      ↓
         * sorted(Comparator)
         *      ↓
         * forEach()
         */
        Stream.of(40, 10, 30, 20, 10)
                // Source:
                // Creates Stream from values
                .distinct()
                // Removes duplicates
                //
                // 40 10 30 20
                .sorted(Comparator.reverseOrder())
                // Custom sorting using Comparator
                //
                // Descending Order
                // 40 30 20 10
                .forEach(System.out::println);
        // Terminal:
        // Prints every element
    }
}