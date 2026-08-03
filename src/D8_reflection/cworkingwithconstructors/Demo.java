package D8_reflection.cworkingwithconstructors;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

public class Demo {

    public static void main(String[] args) throws Exception {

        // Obtain Class object
        Class<Student> cls = Student.class;

        System.out.println("=========== getConstructors() ===========");

        /*
         * Returns ONLY PUBLIC constructors.
         *
         * Inherited public constructors are also considered
         * (although constructors are not inherited in Java,
         * this method follows the public-member lookup rules).
         */

        Constructor<?>[] publicConstructors = cls.getConstructors();

        for (Constructor<?> c : publicConstructors) {

            System.out.println("--------------------------------");

            System.out.println("Name : " + c.getName());

            System.out.println("Modifier : "
                    + Modifier.toString(c.getModifiers()));
            System.out.println("Parameter Count : "
                    + c.getParameterCount());
            Class<?>[] parameters = c.getParameterTypes();
            System.out.print("Parameter Types : ");
            for (Class<?> p : parameters) {
                System.out.print(p.getSimpleName() + " ");
            }
            System.out.println();
        }
        System.out.println("\n=========== getDeclaredConstructors() ===========");
        /*
         * Returns ALL constructors declared
         * inside Student class.
         *
         * public
         * protected
         * default
         * private
         */
        Constructor<?>[] allConstructors =
                cls.getDeclaredConstructors();
        for (Constructor<?> c : allConstructors) {
            System.out.println("--------------------------------");
            System.out.println("Name : " + c.getName());
            System.out.println("Modifier : "
                    + Modifier.toString(c.getModifiers()));
            System.out.println("Parameter Count : "
                    + c.getParameterCount());
        }
        System.out.println("\n=========== getConstructor() ===========");
        /*
         * Searches ONLY PUBLIC constructors.
         */
        Constructor<Student> c1 =
                cls.getConstructor(int.class);
        System.out.println(c1);
        System.out.println("\n=========== getDeclaredConstructor() ===========");
        /*
         * Searches any constructor
         * declared inside the class,
         * including private.
         */
        Constructor<Student> c2 =
                cls.getDeclaredConstructor(int.class,
                        String.class);
        System.out.println(c2);
    }
}
