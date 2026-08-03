package D6_enum_practice.basicenum;


/*
 * ===========================================================
 * DEMO 1 : BASIC ENUM
 * ===========================================================
 *
 * Topics Covered
 * --------------
 * ✔ Why Enum?
 * ✔ enum keyword
 * ✔ Enum is a special class
 * ✔ Enum constants
 * ✔ Type Safety
 * ✔ Why cannot create object using new
 * ✔ Why constants are public static final
 * ✔ JVM Memory
 *
 * ===========================================================
 */
// enum is a special class used to represent a fixed set of constants.
enum Day {

    // Compiler internally creates these as:
    // public static final Day MONDAY = new Day();
    // public static final Day TUESDAY = new Day();
    // public static final Day WEDNESDAY = new Day();

    MONDAY,
    TUESDAY,
    WEDNESDAY

}

public class Demo1_BasicEnum {

    public static void main(String[] args) {

        // Access enum constant using ClassName.CONSTANT
        Day today = Day.MONDAY;

        System.out.println("Today : " + today);

        // Another reference pointing to same object
        Day another = Day.MONDAY;

        System.out.println(today == another);
        /*
         * Compile Time Errors
         */

        // Day d = new Day();   // Cannot instantiate enum

        // Day d = 100;         // Type mismatch

        // today = "MONDAY";    // Type mismatch
    }
}