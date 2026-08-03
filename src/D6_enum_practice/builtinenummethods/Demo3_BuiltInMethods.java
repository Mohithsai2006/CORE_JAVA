package D6_enum_practice.builtinenummethods;
/*
 * ==========================================================
 * DEMO 3 : BUILT-IN ENUM METHODS
 * ==========================================================
 *
 * Topics Covered
 * --------------
 * ✔ values()
 * ✔ valueOf()
 * ✔ ordinal()
 * ✔ name()
 * ✔ toString()
 * ✔ compareTo()
 * ✔ equals()
 * ✔ getDeclaringClass()
 *
 * Note:
 * Every enum automatically extends java.lang.Enum,
 * so all these methods are available.
 *
 * ==========================================================
 */
enum Day {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;
}
public class Demo3_BuiltInMethods {
    public static void main(String[] args) {
        /*
         * values()
         * --------
         * Returns all enum constants as an array.
         */
        for (Day d : Day.values()) {
            System.out.println(d);
        }
        System.out.println();
        /*
         * valueOf()
         * ---------
         * Converts String to Enum constant.
         * String must exactly match the constant name.
         */
        Day d1 = Day.valueOf("MONDAY");
        System.out.println("valueOf() : " + d1);
        // Compile OK but Runtime Exception
        // Day.valueOf("ABC");
        System.out.println();
        /*
         * ordinal()
         * ---------
         * Returns index position.
         * Starts from 0.
         *
         * Do NOT use ordinal() as a permanent ID.
         * If enum order changes, ordinal also changes.
         */
        System.out.println("MONDAY Ordinal : " + Day.MONDAY.ordinal());
        System.out.println("FRIDAY Ordinal : " + Day.FRIDAY.ordinal());
        System.out.println();
        /*
         * name()
         * ------
         * Returns exact enum constant name.
         */
        System.out.println("Name : " + Day.SUNDAY.name());
        System.out.println();
        /*
         * toString()
         * ----------
         * By default returns constant name.
         * Can be overridden.
         */
        System.out.println("toString() : " + Day.TUESDAY.toString());
        System.out.println();
        /*
         * compareTo()
         * -----------
         * Compares ordinal positions.
         *
         * Current Ordinal - Given Ordinal
         */
        System.out.println(
                Day.MONDAY.compareTo(Day.THURSDAY));

        System.out.println(
                Day.SATURDAY.compareTo(Day.FRIDAY));
        System.out.println();
        /*
         * equals()
         * --------
         * Checks whether both references point
         * to same enum constant.
         */
        System.out.println(
                Day.MONDAY.equals(Day.MONDAY));
        System.out.println(
                Day.MONDAY.equals(Day.SUNDAY));
        System.out.println();
        /*
         * getDeclaringClass()
         * -------------------
         * Returns enum class object.
         */
        System.out.println(
                Day.MONDAY.getDeclaringClass());

    }
}
