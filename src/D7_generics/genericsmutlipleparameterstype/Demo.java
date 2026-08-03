package D7_generics.genericsmutlipleparameterstype;
public class Demo {
    public static void main(String[] args) {
        /*
         * Compiler replaces
         *
         * K ---> Integer
         * V ---> String
         */
        Pair<Integer, String> p1 =
                new Pair<>(101, "Mohith");
        System.out.println(p1.getKey());
        System.out.println(p1.getValue());
        /*
         * Compiler replaces
         *
         * K ---> String
         * V ---> Student
         */
        Pair<String, Student> p2 =
                new Pair<>("S101", new Student("Rahul"));
        System.out.println(p2.getKey());
        System.out.println(p2.getValue());
        /*
         * We can use any datatype combination.
         *
         * Integer,String
         * String,Student
         * Long,Employee
         * Character,Double
         * ...
         */
    }
}
