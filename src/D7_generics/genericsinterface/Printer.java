package D7_generics.genericsinterface;
/*
 * Before Generics
 * interface Printer{
 *      Object print();
 * }
 * Every implementation returns Object.
 * Explicit casting required.
 * Generic Interface solves this.
 */
public interface Printer<T> {
    // Returns object of type T
    T print();
}
