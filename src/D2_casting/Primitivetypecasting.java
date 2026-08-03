package D2_casting;
public class Primitivetypecasting {
    public static void main(String[] args) {
        // ==========================================================
        // WIDENING CASTING (Implicit / Automatic)
        // Smaller Data Type  --->  Larger Data Type
        // No Explicit Cast Required
        // ==========================================================
        System.out.println("========== WIDENING CASTING ==========\n");
        byte byteValue = 10;
        // byte -> short
        short shortValue = byteValue;
        // short -> int
        int intValue = shortValue;
        // int -> long
        long longValue = intValue;
        // long -> float
        float floatValue = longValue;
        // float -> double
        double doubleValue = floatValue;
        System.out.println("byte   : " + byteValue);
        System.out.println("short  : " + shortValue);
        System.out.println("int    : " + intValue);
        System.out.println("long   : " + longValue);
        System.out.println("float  : " + floatValue);
        System.out.println("double : " + doubleValue);
        // ==========================================================
        // NARROWING CASTING (Explicit / Manual)
        // Larger Data Type ---> Smaller Data Type
        // Explicit Cast Required
        // ==========================================================
        System.out.println("\n========== NARROWING CASTING ==========\n");
        double originalDouble = 123.987;
        // double -> float
        float narrowedFloat = (float) originalDouble;
        // float -> long
        long narrowedLong = (long) narrowedFloat;
        // long -> int
        int narrowedInt = (int) narrowedLong;
        // int -> short
        short narrowedShort = (short) narrowedInt;
        // short -> byte
        byte narrowedByte = (byte) narrowedShort;
        System.out.println("double : " + originalDouble);
        System.out.println("float  : " + narrowedFloat);
        System.out.println("long   : " + narrowedLong);
        System.out.println("int    : " + narrowedInt);
        System.out.println("short  : " + narrowedShort);
        System.out.println("byte   : " + narrowedByte);
        // ==========================================================
        // DATA LOSS EXAMPLE
        // Decimal part is lost during narrowing
        // ==========================================================
        System.out.println("\n========== DATA LOSS ==========\n");
        double salary = 45678.98;
        int salaryInt = (int) salary;
        System.out.println("Original Double : " + salary);
        System.out.println("After Casting   : " + salaryInt);
        // ==========================================================
        // OVERFLOW EXAMPLE
        // Value exceeds byte range (-128 to 127)
        // ==========================================================
        System.out.println("\n========== OVERFLOW ==========\n");
        int largeNumber = 130;
        byte overflowByte = (byte) largeNumber;
        System.out.println("Original Int : " + largeNumber);
        System.out.println("After Byte Cast : " + overflowByte);
        // ==========================================================
        // CHAR CASTING
        // ==========================================================
        System.out.println("\n========== CHAR CASTING ==========\n");
        char ch = 'A';
        int ascii = ch;          // Widening
        char again = (char) ascii; // Narrowing
        System.out.println("Character : " + ch);
        System.out.println("ASCII     : " + ascii);
        System.out.println("Character Again : " + again);
    }
}
