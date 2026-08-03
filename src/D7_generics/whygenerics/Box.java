package D7_generics.whygenerics;
// Generic Class
// T is called a Type Parameter.
// Instead of creating
// AlmondBox
// CashewBox
// StudentBox
// EmployeeBox
// We create only ONE reusable Box<T>.
public class Box<T> {
    // Stores objects of type T
    private T[] items;
    //Next insertion position
    private int index;
    public Box(int size) {
        /*
         * We cannot create
         *
         * new T[size]
         *
         * because T does not exist at runtime
         * (Type Erasure).
         *
         * So we create an Object array
         * and cast it to T[].
         */
        items = (T[]) new Object[size];
        index = 0;
    }
    // Accepts only T objects
    public void add(T item) {
        items[index] = item;
        index++;
    }
    // Returns T object
    public T get(int index) {
        return items[index];
    }
}