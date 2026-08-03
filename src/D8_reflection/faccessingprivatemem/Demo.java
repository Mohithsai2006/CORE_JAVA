package D8_reflection.faccessingprivatemem;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Demo {

    public static void main(String[] args) throws Exception {

        Student student = new Student();

        Class<Student> cls = Student.class;

        System.out.println("\n========== PRIVATE FIELD ==========");

        /*
         * Locate private field.
         */
        Field field =
                cls.getDeclaredField("name");

        /*
         * By default Java prevents access
         * to private members.
         *
         * setAccessible(true)
         * disables Java language access checks
         * for this reflective object.
         */
        field.setAccessible(true);
        /*
         * Reading private field.
         */
        Object value = field.get(student);
        System.out.println("Current Value : " + value);
        /*
         * Modifying private field.
         */
        field.set(student, "Rahul");
        System.out.println("After Modification");
        student.display();
        System.out.println("\n========== PRIVATE METHOD ==========");
        Method method =
                cls.getDeclaredMethod("show");
        /*
         * Allow invocation.
         */
        method.setAccessible(true);
        /*
         * Invoking private method.
         */
        method.invoke(student);
        System.out.println("\n========== PRIVATE CONSTRUCTOR ==========");
        Constructor<Student> constructor =
                cls.getDeclaredConstructor(
                        int.class,
                        String.class);

        /*
         * Allow constructor invocation.
         */
        constructor.setAccessible(true);
        /*
         * Creating object using
         * private constructor.
         */
        Student student2 =
                constructor.newInstance(
                        999,
                        "Reflection");

        student2.display();

    }
}