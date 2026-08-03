package D8_streams.pipelineofdifferentsourcesintermetermina;

import java.util.Arrays;
import java.util.List;

public class Demo3 {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(
                10,20,30,40,50,60,70,80
        );

        /*
         * Pipeline
         *
         * List
         *  ↓
         * stream()
         *  ↓
         * skip()
         *  ↓
         * limit()
         *  ↓
         * filter()
         *  ↓
         * count()
         */

        long count = numbers.stream()
                // Source:
                // Converts List into Stream

                .skip(2)
                // Intermediate:
                // Skips first 2 elements
                //
                // Before:
                // 10 20 30 40 50 60 70 80
                //
                // After:
                // 30 40 50 60 70 80
                .limit(4)
                // Intermediate:
                // Takes only first 4 elements
                //
                // 30 40 50 60
                .filter(n -> n > 35)
                // Intermediate:
                // Keeps elements greater than 35
                //
                // 40 50 60
                .count();
        // Terminal:
        // Counts remaining elements
        System.out.println("Count = " + count);
        System.out.println("\n=====================\n");
        Integer first = numbers.stream()
                .filter(n -> n > 30)
                // Keeps numbers greater than 30

                .findFirst()
                // Terminal:
                // Returns first matching element as Optional<Integer>

                .orElse(null);
        // Returns the value if present, otherwise null
        // Terminal:
        // Returns first matching element
        System.out.println("First : " + first);
        System.out.println();
        Integer any = numbers.stream()
                .filter(n -> n > 30)

                .findAny()
                // Terminal:
                // Returns any matching element as Optional<Integer>

                .orElse(null);

        // Sequential Stream -> Usually first element
        // Parallel Stream -> Can return any matching element
        System.out.println("Any   : " + any);
    }
}