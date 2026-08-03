package D8_streams.pipelineofdifferentsourcesintermetermina;



import java.util.Arrays;
import java.util.List;

public class Demo1 {

    public static void main(String[] args) {

        List<String> names = Arrays.asList(
                "John",
                "Alex",
                "Bob",
                "David",
                "Amy"
        );

        /*
         * Pipeline
         *
         * List
         *  ↓
         * stream()
         *  ↓
         * filter()
         *  ↓
         * map()
         *  ↓
         * forEach()
         */
        names.stream()                              // Source: Converts List into Stream
                .filter(name -> name.startsWith("A"))
                // Intermediate:
                // Keeps only names starting with 'A'
                // Alex, Amy

                .map(String::toUpperCase)
                // Intermediate:
                // Converts each name into uppercase
                // Alex -> ALEX
                // Amy  -> AMY

                .forEach(System.out::println);
        // Terminal:
        // Consumes each element and prints it
    }
}
