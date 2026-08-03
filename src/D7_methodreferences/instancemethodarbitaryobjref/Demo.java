package D7_methodreferences.instancemethodarbitaryobjref;
import java.util.Arrays;
import java.util.List;

public class Demo {

    public static void main(String[] args) {

        List<String> names =
                Arrays.asList("Mohith", "Ravi", "Kiran");

        // Lambda
//        names.forEach(name -> System.out.println(name));

        // Method Reference
        // Java automatically uses each String object
        // as the receiver of println().
        names.forEach(System.out::println);
    }
}