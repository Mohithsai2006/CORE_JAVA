package D6_interfaces;
// Program: Multiple Interface Implementation
interface Printable {
    void print();
}
interface Scannable {
    void scan();
}
// One class implementing multiple interfaces.
class Printer implements Printable, Scannable {
    @Override
    public void print() {
        System.out.println("Printing...");
    }
    @Override
    public void scan() {
        System.out.println("Scanning...");
    }
}
public class MultipleInterfaceImplementation {
    public static void main(String[] args) {
        Printer printer = new Printer();
        printer.print();
        printer.scan();
    }
}
/*
----------------------------
Output
----------------------------
Printing...
Scanning...
----------------------------
Topics Covered
----------------------------
✔ Multiple interfaces
✔ implements A, B
✔ Method overriding
*/