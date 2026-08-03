package D6_enum_practice.enumvarmethodconstr;



/*
 * ==========================================================
 * DEMO 2 : ENUM VARIABLES, CONSTRUCTORS & METHODS
 * ==========================================================
 *
 * Topics Covered
 * --------------
 * ✔ Enum can have variables
 * ✔ Enum can have constructors
 * ✔ Parameterized constructor
 * ✔ Instance methods
 * ✔ Static methods
 * ✔ Static variables
 * ✔ Why constructor is private
 * ✔ Memory of enum objects
 *
 * ==========================================================
 */

enum Day {
    // -----------------------------
    // Enum Constants
    // -----------------------------
    // Each constant calls the constructor.
    // MONDAY -> new Day(1, false)
    // TUESDAY -> new Day(2, false)
    // SUNDAY -> new Day(7, true)
    MONDAY(1, false),
    TUESDAY(2, false),
    SUNDAY(7, true);
    // -----------------------------
    // Instance Variables
    // -----------------------------
    // Every enum object has its own copy.
    int dayNumber;
    boolean holiday;
    // -----------------------------
    // Static Variable
    // -----------------------------
    // Shared by all enum objects.
    static String country = "India";
    // -----------------------------
    // Constructor
    // -----------------------------
    // Constructor is implicitly PRIVATE.
    // We cannot write public or protected constructor.
    Day(int dayNumber, boolean holiday) {
        System.out.println("Constructor Called : " + dayNumber);
        this.dayNumber = dayNumber;
        this.holiday = holiday;
    }
    // -----------------------------
    // Instance Method
    // -----------------------------
    public void display() {
        System.out.println(name() +
                " Day Number : " + dayNumber +
                " Holiday : " + holiday);
    }
    // -----------------------------
    // Static Method
    // -----------------------------
    public static void info() {
        System.out.println("Country : " + country);
    }
}
public class Demo2_EnumVariablesConstructorsMethods {
    public static void main(String[] args) {
        Day d1 = Day.MONDAY;
        Day d2 = Day.SUNDAY;
        d1.display();
        d2.display();
        Day.info();
    }
}
