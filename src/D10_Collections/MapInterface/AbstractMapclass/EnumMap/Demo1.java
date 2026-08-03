package D10_Collections.MapInterface.AbstractMapclass.EnumMap;
import java.util.EnumMap;
enum Day {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY
}
public class Demo1 {
    public static void main(String[] args) {
        EnumMap<Day, String> map =
                new EnumMap<>(Day.class);
        map.put(Day.MONDAY, "Java");
        map.put(Day.WEDNESDAY, "Spring");
        map.put(Day.FRIDAY, "Holiday");

        System.out.println(map);

        System.out.println();

        System.out.println("Monday : " +
                map.get(Day.MONDAY));

        System.out.println("Friday : " +
                map.get(Day.FRIDAY));
    }
}