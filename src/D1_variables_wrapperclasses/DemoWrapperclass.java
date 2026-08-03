package D1_variables_wrapperclasses;
public class DemoWrapperclass {

    public static void main(String[] args) {

        // =====================================================
        // Primitive Variable (stored directly in stack)
        // =====================================================
        int primitiveInt = 100;

        // =====================================================
        // Boxing (Primitive -> Wrapper Object)
        // Creates an Integer object
        // =====================================================
        Integer boxedInt = Integer.valueOf(primitiveInt);

        // =====================================================
        // Auto-boxing
        // Compiler converts:
        // Integer autoBoxed = Integer.valueOf(200);
        // =====================================================
        Integer autoBoxed = 200;

        // =====================================================
        // Unboxing
        // Wrapper -> Primitive
        // =====================================================
        int unboxed = boxedInt.intValue();

        // =====================================================
        // Auto-unboxing
        // Compiler converts:
        // int autoUnboxed = autoBoxed.intValue();
        // =====================================================
        int autoUnboxed = autoBoxed;

        // =====================================================
        // Wrapper methods
        // =====================================================
        System.out.println("Primitive : " + primitiveInt);

        System.out.println("Boxed     : " + boxedInt);

        System.out.println("AutoBoxed : " + autoBoxed);

        System.out.println("Unboxed   : " + unboxed);

        System.out.println("AutoUnbox : " + autoUnboxed);

        System.out.println();

        System.out.println("Maximum Integer : " + Integer.MAX_VALUE);

        System.out.println("Minimum Integer : " + Integer.MIN_VALUE);

        System.out.println("Binary of 10 : " + Integer.toBinaryString(10));

        System.out.println("Parse String : " + Integer.parseInt("500"));

    }
}
