
package D1_javamemory_basics;
import java.util.ArrayList;
import java.util.List;

public class HeapTest {
    public static void main(String[] args) {

        List<byte[]> list = new ArrayList<>();

        while (true) {
            // Allocate 1 MB chunks repeatedly
            byte[] block = new byte[1024 * 1024];
            list.add(block);

            System.out.println("Allocated Memory Blocks: " + list.size());
        }
    }
}