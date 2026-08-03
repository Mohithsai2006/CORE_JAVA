package D8_streams.pipelineofdifferentsourcesintermetermina;
import java.util.stream.IntStream;
public class Demo4 {
    public static void main(String[] args) {
        /*
         * Pipeline
         *
         * IntStream.range()
         *      ↓
         * filter()
         *      ↓
         * map()
         *      ↓
         * sum()
         */
        int sum = IntStream.range(1, 11)
                // Source:
                // Creates numbers from 1 to 10

                .filter(n -> n % 2 == 0)
                // Intermediate:
                // Keeps only even numbers
                //
                // 2 4 6 8 10
                .map(n -> n * 10)
                // Intermediate:
                // Multiplies each element by 10
                //
                // 20 40 60 80 100

                .sum();
        // Terminal:
        // Adds all elements
        System.out.println("Sum = " + sum);
        System.out.println("\n=====================\n");
        double average = IntStream.of(10,20,30,40,50)
                // Source:
                // Creates IntStream from values
                .average()
                // Terminal:
                // Calculates average
                .orElse(0);
        System.out.println("Average = " + average);
        System.out.println();
        int min = IntStream.of(10,20,30,40,50)
                .min()
                // Terminal:
                // Returns minimum element
                .orElse(0);
        System.out.println("Min = " + min);
        System.out.println();
        int max = IntStream.of(10,20,30,40,50)
                .max()
                // Terminal:
                // Returns maximum element
                .orElse(0);
        System.out.println("Max = " + max);
        System.out.println();
        int total = IntStream.of(10,20,30,40,50)
                .reduce(0, (a, b) -> a + b);
        // Terminal:
        // Performs reduction
        //
        // 0+10=10
        // 10+20=30
        // 30+30=60
        // 60+40=100
        // 100+50=150
        System.out.println("Reduce = " + total);
        System.out.println();
        IntStream.range(1, 6)
                .boxed()
                // Intermediate:
                // Converts primitive int
                // into Integer objects
                .forEach(System.out::println);
        // Terminal:
        // Prints each Integer object
    }
}
