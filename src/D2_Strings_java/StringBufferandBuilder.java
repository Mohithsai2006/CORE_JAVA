package D2_Strings_java;
public class StringBufferandBuilder{

    public static void main(String[] args) {

        System.out.println("=== STRING PERFORMANCE TEST ===");

        // String is immutable → creates new objects every time (slow)
        long start1 = System.currentTimeMillis();

        String s = "";
        for (int i = 0; i < 10000; i++) {
            s += i; // new object created in each loop iteration
        }

        long end1 = System.currentTimeMillis();
        System.out.println("String time: " + (end1 - start1) + " ms");

        // StringBuilder is mutable → fast, not thread-safe
        long start2 = System.currentTimeMillis();

        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            sb1.append(i); // modifies same object
        }

        long end2 = System.currentTimeMillis();
        System.out.println("StringBuilder time: " + (end2 - start2) + " ms");

        // StringBuffer is mutable → thread-safe, slightly slower
        long start3 = System.currentTimeMillis();

        StringBuffer sb2 = new StringBuffer();
        for (int i = 0; i < 10000; i++) {
            sb2.append(i); // synchronized method ensures thread safety
        }

        long end3 = System.currentTimeMillis();
        System.out.println("StringBuffer time: " + (end3 - start3) + " ms");

        System.out.println("\n=== FINAL RESULTS ===");

        // Summary of behavior differences
        System.out.println("String → slow (immutable, new objects created)");
        System.out.println("StringBuilder → fast (no synchronization)");
        System.out.println("StringBuffer → safe but slower (synchronized methods)");

        System.out.println("\n=== MUTABILITY DEMO ===");

        // StringBuilder example (mutable)
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World"); // modifies same object
        System.out.println("StringBuilder: " + sb);

        // StringBuffer example (mutable + thread-safe)
        StringBuffer buffer = new StringBuffer("Hello");
        buffer.append(" World"); // synchronized modification
        System.out.println("StringBuffer: " + buffer);
    }
}