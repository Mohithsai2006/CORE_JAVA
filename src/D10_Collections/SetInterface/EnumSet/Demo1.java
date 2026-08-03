package D10_Collections.SetInterface.EnumSet;
import java.util.EnumSet;
import java.util.Iterator;
/*
 * EnumSet works ONLY with enums.
 */
enum Day {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
}
public class Demo1 {
    public static void main(String[] args) {
        /*
         * EnumSet is an abstract class.
         *
         * We CANNOT create object using
         *
         * new EnumSet<>();
         *
         * Instead, Java provides static
         * factory methods.
         */

        //--------------------------------------------------
        // noneOf()
        //--------------------------------------------------

        /*
         * Creates an EMPTY EnumSet.
         *
         * Internally
         *
         * If enum constants <=64
         *      RegularEnumSet
         *
         * else
         *      JumboEnumSet
         */

        EnumSet<Day> days =
                EnumSet.noneOf(Day.class);

        System.out.println(days);

        System.out.println("--------------------------------");

        //--------------------------------------------------
        // add()
        //--------------------------------------------------

        /*
         * Internally
         *
         * Bit corresponding to ordinal()
         * becomes 1.
         *
         * Example
         *
         * MONDAY ordinal = 0
         * WEDNESDAY = 2
         * FRIDAY = 4
         */

        days.add(Day.MONDAY);

        days.add(Day.WEDNESDAY);

        days.add(Day.FRIDAY);

        /*
         * Duplicate
         *
         * Bit already set.
         *
         * Nothing changes.
         */

        System.out.println(
                days.add(Day.MONDAY)
        );

        System.out.println(days);

        System.out.println("--------------------------------");

        //--------------------------------------------------
        // contains()
        //--------------------------------------------------

        /*
         * Internally
         *
         * Bit check
         */

        System.out.println(
                days.contains(Day.FRIDAY)
        );

        System.out.println(
                days.contains(Day.SUNDAY)
        );

        System.out.println("--------------------------------");

        //--------------------------------------------------
        // allOf()
        //--------------------------------------------------

        /*
         * Creates EnumSet containing
         * ALL enum constants.
         */

        EnumSet<Day> allDays =
                EnumSet.allOf(Day.class);

        System.out.println(allDays);

        System.out.println("--------------------------------");

        //--------------------------------------------------
        // of()
        //--------------------------------------------------

        /*
         * Creates EnumSet
         * with specified constants.
         */

        EnumSet<Day> weekend =
                EnumSet.of(

                        Day.SATURDAY,

                        Day.SUNDAY

                );

        System.out.println(weekend);

        System.out.println("--------------------------------");

        //--------------------------------------------------
        // range()
        //--------------------------------------------------

        /*
         * Includes BOTH limits.
         */

        EnumSet<Day> workingDays =
                EnumSet.range(

                        Day.MONDAY,

                        Day.FRIDAY

                );

        System.out.println(workingDays);

        System.out.println("--------------------------------");

        //--------------------------------------------------
        // complementOf()
        //--------------------------------------------------

        /*
         * Returns all enum constants
         * NOT present.
         */

        EnumSet<Day> holidays =
                EnumSet.complementOf(
                        workingDays
                );

        System.out.println(holidays);

        System.out.println("--------------------------------");

        //--------------------------------------------------
        // copyOf()
        //--------------------------------------------------

        EnumSet<Day> copy =
                EnumSet.copyOf(days);

        System.out.println(copy);

        System.out.println("--------------------------------");

        //--------------------------------------------------
        // addAll()
        //--------------------------------------------------

        copy.addAll(weekend);

        System.out.println(copy);

        System.out.println("--------------------------------");

        //--------------------------------------------------
        // remove()
        //--------------------------------------------------

        copy.remove(Day.SATURDAY);

        System.out.println(copy);

        System.out.println("--------------------------------");

        //--------------------------------------------------
        // removeAll()
        //--------------------------------------------------

        copy.removeAll(days);

        System.out.println(copy);

        System.out.println("--------------------------------");

        //--------------------------------------------------
        // retainAll()
        //--------------------------------------------------

        copy.add(Day.MONDAY);

        copy.add(Day.TUESDAY);

        copy.retainAll(workingDays);

        System.out.println(copy);

        System.out.println("--------------------------------");

        //--------------------------------------------------
        // size()
        //--------------------------------------------------

        System.out.println(copy.size());

        //--------------------------------------------------
        // isEmpty()
        //--------------------------------------------------

        System.out.println(copy.isEmpty());

        System.out.println("--------------------------------");

        //--------------------------------------------------
        // Iterator
        //--------------------------------------------------

        /*
         * Iterates according to
         * enum declaration order.
         */

        Iterator<Day> iterator =
                workingDays.iterator();

        while(iterator.hasNext())
        {
            System.out.println(
                    iterator.next()
            );
        }

        System.out.println("--------------------------------");

        //--------------------------------------------------
        // Enhanced for-loop
        //--------------------------------------------------

        for(Day day : workingDays)
        {
            System.out.println(day);
        }

        System.out.println("--------------------------------");

        //--------------------------------------------------
        // forEach()
        //--------------------------------------------------

        workingDays.forEach(System.out::println);

        System.out.println("--------------------------------");

        //--------------------------------------------------
        // clone()
        //--------------------------------------------------

        EnumSet<Day> clone =
                workingDays.clone();

        System.out.println(clone);

        System.out.println("--------------------------------");

        //--------------------------------------------------
        // equals()
        //--------------------------------------------------

        System.out.println(
                workingDays.equals(clone)
        );

        //--------------------------------------------------
        // hashCode()
        //--------------------------------------------------

        System.out.println(
                workingDays.hashCode()
        );

        System.out.println("--------------------------------");

        //--------------------------------------------------
        // clear()
        //--------------------------------------------------

        clone.clear();

        System.out.println(clone);

        System.out.println(
                clone.isEmpty()
        );

    }

}
