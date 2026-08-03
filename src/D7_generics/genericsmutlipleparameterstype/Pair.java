package D7_generics.genericsmutlipleparameterstype;
/*
 * Sometimes one datatype is not enough.
 * Example:
 * Map<Key, Value>
 * Key and Value may be different datatypes.
 * So Java allows multiple type parameters.
 */
public class Pair<K, V> {
    // K -> Key type
    private K key;
    // V -> Value type
    private V value;
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
    public K getKey() {
        return key;
    }
    public V getValue() {
        return value;
    }
}