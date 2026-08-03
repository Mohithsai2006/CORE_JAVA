package D8_reflection.eworkingwithmethods;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Demo {

    public static void main(String[] args) throws Exception {

        Student student = new Student();

        Class<Student> cls = Student.class;

        System.out.println("========== getMethods() ==========");

        /*
         * Returns all PUBLIC methods.
         *
         * Includes inherited public methods
         * from Object class also.
         */

        Method[] publicMethods = cls.getMethods();

        for (Method method : publicMethods) {

            System.out.println("--------------------------------");

            System.out.println("Method Name : "
                    + method.getName());

            System.out.println("Return Type : "
                    + method.getReturnType().getSimpleName());

            System.out.println("Parameter Count : "
                    + method.getParameterCount());

            System.out.println("Modifier : "
                    + Modifier.toString(method.getModifiers()));

        }

        System.out.println("\n========== getDeclaredMethods() ==========");

        /*
         * Returns every method declared
         * inside Student class.
         *
         * public
         * protected
         * default
         * private
         */

        Method[] allMethods = cls.getDeclaredMethods();

        for (Method method : allMethods) {

            System.out.println("--------------------------------");

            System.out.println("Method Name : "
                    + method.getName());

            System.out.println("Return Type : "
                    + method.getReturnType().getSimpleName());

            System.out.println("Parameter Count : "
                    + method.getParameterCount());

            System.out.println("Modifier : "
                    + Modifier.toString(method.getModifiers()));

        }

        System.out.println("\n========== getMethod() ==========");

        /*
         * Searches only PUBLIC methods.
         */

        Method m1 = cls.getMethod("study");

        System.out.println(m1);

        System.out.println("\n========== getDeclaredMethod() ==========");

        /*
         * Searches any declared method.
         *
         * Can locate private methods also.
         */

        Method m2 =
                cls.getDeclaredMethod("privateMethod");

        System.out.println(m2);

        System.out.println("\n========== invoke() ==========");

        /*
         * Invoking public method study()
         */

        m1.invoke(student);

        /*
         * Invoking add(int,int)
         */

        Method addMethod =
                cls.getMethod("add",
                        int.class,
                        int.class);

        Object result =
                addMethod.invoke(student,10,20);

        System.out.println("Addition = " + result);

        /*
         * Invoking static method.
         *
         * Static methods don't need object.
         * Pass null as first argument.
         */
        Method staticMethod =
                cls.getMethod("collegeName");

        staticMethod.invoke(null);
    }
}