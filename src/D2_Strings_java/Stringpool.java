package D2_Strings_java;

public class Stringpool  {

    public static void main(String[] args) {

        System.out.println("=== STRING POOL + == vs equals ===");

        // String Pool case
        String s1 = "Java";
        String s2 = "Java";

        System.out.println("s1 == s2 : " + (s1 == s2));         // true (same pool object)
        System.out.println("s1.equals(s2) : " + s1.equals(s2)); // true (content match)

        // Heap objects (new keyword)
        String s3 = new String("Java");
        String s4 = new String("Java");

        System.out.println("s3 == s4 : " + (s3 == s4));         // false (different objects)
        System.out.println("s3.equals(s4) : " + s3.equals(s4)); // true

        // Pool vs Heap comparison
        System.out.println("s1 == s3 : " + (s1 == s3));         // false

        System.out.println("\n=== IMMUTABILITY DEMO ===");

        String s5 = "Hello";
        s5.concat(" World"); // not assigned back

        System.out.println("s5 after concat: " + s5); // still Hello

        s5 = s5.concat(" World");
        System.out.println("s5 after reassignment: " + s5); // Hello World

        System.out.println("\n=== INTERN() METHOD ===");

        String s6 = new String("Java").intern();
        String s7 = "Java";

        System.out.println("s6 == s7 : " + (s6 == s7)); // true (now from pool)

        System.out.println("\n=== MEMORY IDEA ===");
        System.out.println("String literals → String Pool (Heap)");
        System.out.println("new String → Heap separate object");
        System.out.println("String is IMMUTABLE (cannot change original object)");
    }
}

