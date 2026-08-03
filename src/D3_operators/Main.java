package D3_operators;
public class Main{
    public static void main(String[] args) {
        // ============================================================
        // LOCAL VARIABLES
        // These primitive variables are stored inside the
        // Local Variable Table of the main() stack frame.
        // ============================================================

        int a = 20;
        int b = 7;
        int c = 5;
        boolean x = true;
        boolean y = false;

        System.out.println("a = " + a);
        System.out.println("b = " + b);


        // ============================================================
        // 1. ARITHMETIC OPERATORS
        // ============================================================

        System.out.println("\n===== Arithmetic Operators =====");

        System.out.println("Addition       : " + (a + b));
        System.out.println("Subtraction    : " + (a - b));
        System.out.println("Multiplication : " + (a * b));
        System.out.println("Division       : " + (a / b));
        System.out.println("Modulus        : " + (a % b));


        // ------------------------------------------------------------
        // INTERNAL JVM EVALUATION OF:
        //
        // int result = a + b;
        //
        // Local Variable Table
        // --------------------
        // Slot0 : args
        // Slot1 : a = 20
        // Slot2 : b = 7
        // Slot3 : result
        //
        // Operand Stack Evaluation
        //
        // Step 1:
        // iload_1
        // Operand Stack:
        // 20
        //
        // Step 2:
        // iload_2
        // Operand Stack:
        // 20
        // 7
        //
        // Step 3:
        // iadd
        // JVM pops 20 and 7,
        // adds them using CPU integer ALU,
        // pushes 27.
        //
        // Operand Stack:
        // 27
        //
        // Step 4:
        // istore_3
        //
        // Local Variable Table
        // result = 27
        //
        // Operand Stack becomes empty.
        // ------------------------------------------------------------

        int result = a + b;

        System.out.println("Result = " + result);


        // ============================================================
        // 2. UNARY OPERATORS
        // ============================================================

        System.out.println("\n===== Unary Operators =====");

        int p = 10;

        System.out.println(+p);
        System.out.println(-p);

        System.out.println(++p);
        System.out.println(--p);

        System.out.println(p++);
        System.out.println(p);

        System.out.println(p--);
        System.out.println(p);


        // ============================================================
        // PRE vs POST INCREMENT
        // ============================================================

        int m = 5;

        int pre = ++m;

        // Internal
        //
        // m = 5
        // increment first
        // m = 6
        // copy into pre
        //
        // pre = 6
        // m = 6

        m = 5;

        int post = m++;

        // Internal
        //
        // m = 5
        // copy old value
        // post = 5
        // increment m
        // m = 6


        // ============================================================
        // 3. ASSIGNMENT OPERATORS
        // ============================================================

        System.out.println("\n===== Assignment Operators =====");

        int value = 10;

        value += 5;
        value -= 2;
        value *= 3;
        value /= 2;
        value %= 4;

        System.out.println(value);

        // value += 5
        //
        // Compiler treats it approximately as:
        //
        // value = value + 5
        //
        // JVM
        //
        // load value
        // push constant 5
        // add
        // store value


        // ============================================================
        // 4. RELATIONAL OPERATORS
        // ============================================================

        System.out.println("\n===== Relational Operators =====");

        System.out.println(a > b);
        System.out.println(a < b);
        System.out.println(a >= b);
        System.out.println(a <= b);
        System.out.println(a == b);
        System.out.println(a != b);


        // ============================================================
        // 5. LOGICAL OPERATORS
        // ============================================================

        System.out.println("\n===== Logical Operators =====");

        System.out.println(x && y);
        System.out.println(x || y);
        System.out.println(!x);


        // ============================================================
        // SHORT CIRCUIT
        // ============================================================

        String str = null;

        if (str != null && str.length() > 0) {

            System.out.println("Valid");

        }

        // Evaluation
        //
        // Step 1
        // str != null
        //
        // false
        //
        // JVM immediately concludes
        // entire expression is false.
        //
        // str.length()
        //
        // is NEVER executed.
        //
        // Prevents NullPointerException.


        // ============================================================
        // 6. BITWISE OPERATORS
        // ============================================================

        System.out.println("\n===== Bitwise Operators =====");

        int bit1 = 5;
        int bit2 = 3;

        System.out.println(bit1 & bit2);
        System.out.println(bit1 | bit2);
        System.out.println(bit1 ^ bit2);
        System.out.println(~bit1);

        // 5
        // 0101
        //
        // 3
        // 0011
        //
        // &
        //
        // 0001
        //
        // =1


        // ============================================================
        // 7. SHIFT OPERATORS
        // ============================================================

        System.out.println("\n===== Shift Operators =====");

        System.out.println(5 << 1);

        System.out.println(20 >> 2);

        System.out.println(-20 >>> 2);

        // Left Shift
        //
        // 00000101
        //
        // <<
        //
        // 00001010
        //
        // =10


        // ============================================================
        // 8. TERNARY OPERATOR
        // ============================================================

        System.out.println("\n===== Ternary Operator =====");

        int max = (a > b) ? a : b;

        System.out.println(max);

        // JVM evaluates
        //
        // if_icmpgt
        //
        // if true
        // push a
        //
        // else
        // push b
        //
        // store into max


        // ============================================================
        // 9. instanceof
        // ============================================================

        System.out.println("\n===== instanceof =====");

        Object obj = "Hello";

        System.out.println(obj instanceof String);
        System.out.println(obj instanceof Object);

        // Heap
        //
        // "Hello" object
        //
        // Reference stored in obj
        //
        // JVM checks runtime class metadata
        // stored in Metaspace.
        //
        // Returns true if object belongs
        // to requested type.


        // ============================================================
        // 10. EQUALITY OF OBJECTS
        // ============================================================

        System.out.println("\n===== Object Equality =====");

        String s1 = new String("Java");
        String s2 = new String("Java");

        System.out.println(s1 == s2);

        System.out.println(s1.equals(s2));

        // ==
        //
        // compares references
        //
        // equals()
        //
        // compares contents


        // ============================================================
        // 11. TYPE CASTING
        // ============================================================

        System.out.println("\n===== Type Casting =====");

        byte small = 100;

        int big = small;

        System.out.println(big);

        double d = 9.87;

        int integer = (int) d;

        System.out.println(integer);


        // ============================================================
        // 12. OPERATOR PRECEDENCE
        // ============================================================

        System.out.println("\n===== Operator Precedence =====");

        int expression = a + b * c - 10 / 2;

        System.out.println(expression);

        // Expression
        //
        // a + b * c - 10 / 2
        //
        // Java NEVER evaluates left to right blindly.
        //
        // It follows precedence.
        //
        // Step 1
        // b * c
        //
        // 7 * 5
        //
        // =35
        //
        // Step 2
        // 10 / 2
        //
        // =5
        //
        // Step 3
        // a + 35
        //
        // =55
        //
        // Step 4
        // 55 - 5
        //
        // =50
        //
        // Compiler generates bytecode approximately like
        //
        // iload a
        // iload b
        // iload c
        // imul
        // iadd
        // iconst_10
        // iconst_2
        // idiv
        // isub
        // istore expression


        // ============================================================
        // 13. PARENTHESES OVERRIDE PRECEDENCE
        // ============================================================

        int expression2 = (a + b) * (c - 2);

        System.out.println(expression2);

        // Parentheses are always evaluated first.
        //
        // (20 + 7) = 27
        //
        // (5 - 2) = 3
        //
        // 27 * 3 = 81


        // ============================================================
        // COMPLETE PRECEDENCE ORDER
        // ============================================================

        // Highest
        //
        // ()
        //
        // postfix
        // expr++, expr--
        //
        // unary
        // ++ -- + - ! ~
        //
        // *, /, %
        //
        // +, -
        //
        // << >> >>>
        //
        // < <= > >= instanceof
        //
        // == !=
        //
        // &
        //
        // ^
        //
        // |
        //
        // &&
        //
        // ||
        //
        // ?:
        //
        // = += -= *= /= %= ...
        //
        // Lowest


        // ============================================================
        // MEMORY SUMMARY
        // ============================================================

        //
        // Method Area (Metaspace)
        // -----------------------
        // Class metadata
        // Bytecode
        // Constant Pool
        //
        //
        // Heap
        // ----
        // String objects
        // Object instances
        //
        //
        // Java Stack
        // ----------
        // Local Variable Table
        // Operand Stack
        //
        // Every operator works primarily by:
        //
        // 1. Loading operands from Local Variable Table
        // 2. Pushing them onto Operand Stack
        // 3. Executing JVM instruction
        // 4. Pushing result back
        // 5. Storing result into Local Variable Table
        //
        // Primitive arithmetic happens on values.
        //
        // Object operators mostly work on references.
        //
        // ============================================================

    }
}

