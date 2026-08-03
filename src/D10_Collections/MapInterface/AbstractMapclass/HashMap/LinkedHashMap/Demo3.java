package D10_Collections.MapInterface.AbstractMapclass.HashMap.LinkedHashMap;
import java.util.LinkedHashMap;
import java.util.Map;
/*
 * Simple LRU Cache
 *
 * Maximum size = 3
 */
class LRUCache<K, V> extends LinkedHashMap<K, V> {
    public LRUCache() {
        /*
         * accessOrder = true
         */
        super(16, 0.75f, true);
    }
    /*
     * Automatically remove the
     * least recently used entry.
     */
    @Override
    protected boolean removeEldestEntry(
            Map.Entry<K, V> eldest) {

        return size() > 3;
    }
}
public class Demo3 {
    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>();
        cache.put(1, "Java");
        cache.put(2, "Python");
        cache.put(3, "Spring");
        System.out.println(cache);
        /*
         * Access key 1
         * It becomes most recently used.
         */
        cache.get(1);
        /*
         * Adding new entry
         * removes least recently used.
         */
        cache.put(4, "React");
        System.out.println(cache);
    }
}