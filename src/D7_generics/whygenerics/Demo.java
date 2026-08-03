package D7_generics.whygenerics;
public class Demo{
    public static void main(String[] args) {
        /*
         * ======================================================
         * PROBLEM 1 : Code Duplication
         * ======================================================
         *
         * Before Generics we had to create
         *
         * AlmondBox
         * CashewBox
         * StudentBox
         * EmployeeBox
         *
         * Same code...
         * Only datatype changes.
         *
         * Generics solve this by creating ONE Box<T>.
         */
        /*
         * ======================================================
         * PROBLEM 2 : Explicit Type Casting
         * ======================================================
         *
         * Before Generics everything was stored as Object.
         */
        Object[] objects = new Object[3];
        objects[0] = new Almond("California Almond");
        objects[1] = new Cashew("India Cashew");
        /*
         * Compiler only knows Object.
         *
         * So explicit casting is required.
         */
        Almond almond1 = (Almond) objects[0];
        System.out.println(almond1);
        /*
         * Wrong casting.
         *
         * Compiler allows this because
         * every object can be referred using Object.
         *
         * Runtime throws ClassCastException.
         */
        // Almond almond2 = (Almond) objects[1];
        /*
         * ======================================================
         * PROBLEM 3 : No Compile-Time Type Safety
         * ======================================================
         *
         * Compiler allows storing different object types.
         */
        objects[2] = "Hello";
        /*
         * Later someone may cast it incorrectly.
         */
        // Almond almond3 = (Almond) objects[2];
        /*
         * ======================================================
         * GENERICS SOLUTION
         * ======================================================
         *
         * Compiler replaces
         *
         * T ---> Almond
         */
        Box<Almond> almondBox = new Box<>(5);
        almondBox.add(new Almond("California Almond"));
        almondBox.add(new Almond("India Almond"));
        almondBox.add(new Almond("NZ Almond"));
        /*
         * No explicit casting required.
         *
         * Compiler already knows
         * get() returns Almond.
         */
        Almond almond = almondBox.get(1);
        System.out.println(almond);
        /*
         * Compiler replaces
         *
         * T ---> Cashew
         */
        Box<Cashew> cashewBox = new Box<>(5);
        cashewBox.add(new Cashew("Australia Cashew"));
        cashewBox.add(new Cashew("India Cashew"));
        cashewBox.add(new Cashew("NZ Cashew"));
        System.out.println(cashewBox.get(2));
        /*
         * Compile-Time Type Safety
         *
         * Compiler stops us immediately.
         */
        // almondBox.add(new Cashew("Wrong Object"));
        /*
         * Because compiler knows
         *
         * Box<Almond>
         *
         * can store ONLY Almond objects.
         */
    }
}