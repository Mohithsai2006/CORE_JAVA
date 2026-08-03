package D8_reflection.binspecting_classmetadata;
import java.lang.reflect.Modifier;

public class Demo {

    public static void main(String[] args) {

        /*
         * First obtain the Class object.
         *
         * Everything in Reflection starts
         * from this object.
         */

        Class<Student> cls = Student.class;

        System.out.println("=========== CLASS NAME INFORMATION ===========");

        /*
         * Returns Fully Qualified Name
         * (Package + Class Name)
         */

        System.out.println("getName() : "
                + cls.getName());

        /*
         * Returns only the class name.
         */

        System.out.println("getSimpleName() : "
                + cls.getSimpleName());

        /*
         * Returns canonical name.
         *
         * Mostly same as getName()
         * for normal classes.
         */

        System.out.println("getCanonicalName() : "
                + cls.getCanonicalName());



        System.out.println("\n=========== PACKAGE INFORMATION ===========");

        /*
         * Returns package object.
         */

        System.out.println(cls.getPackage());



        System.out.println("\n=========== SUPER CLASS ===========");

        /*
         * Every class except Object
         * has one superclass.
         */

        System.out.println(cls.getSuperclass());



        System.out.println("\n=========== IMPLEMENTED INTERFACES ===========");

        /*
         * Returns array because
         * one class can implement
         * multiple interfaces.
         */

        Class<?>[] interfaces =
                cls.getInterfaces();

        for (Class<?> i : interfaces) {

            System.out.println(i.getName());

        }



        System.out.println("\n=========== MODIFIERS ===========");

        /*
         * getModifiers()
         * returns an integer.
         *
         * That integer internally
         * stores modifier bits.
         */

        int modifier = cls.getModifiers();

        System.out.println("Modifier Value : "
                + modifier);

        /*
         * Converts integer modifier
         * into readable text.
         */

        System.out.println("Modifier : "
                + Modifier.toString(modifier));



        System.out.println("\n=========== TYPE CHECKING ===========");

        /*
         * Is this class an Interface?
         */

        System.out.println("isInterface() : "
                + cls.isInterface());

        /*
         * Is this an Enum?
         */

        System.out.println("isEnum() : "
                + cls.isEnum());

        /*
         * Is this an Array?
         */

        System.out.println("isArray() : "
                + cls.isArray());

        /*
         * Is this primitive?
         *
         * int.class returns true.
         * Student.class returns false.
         */
        System.out.println("isPrimitive() : "
                + cls.isPrimitive());
        System.out.println("\n=========== CLASS LOADER ===========");
        /*
         * Returns the ClassLoader
         * responsible for loading
         * this class.
         *
         * Our own classes are usually
         * loaded by Application ClassLoader.
         */
        System.out.println(cls.getClassLoader());
    }

}