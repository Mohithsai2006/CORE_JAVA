package D8_reflection.gdynamicobjectcreation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Demo {

    public static void main(String[] args) throws Exception {

        /*
         * Step 1
         * Load class dynamically.
         * JVM searches the class using the fully qualified class name.
         */
        Class<?> cls = Class.forName(
                "D8_reflection.gdynamicobjectcreation.Student"
        );

        /*
         * Step 2
         * Get the public no-argument constructor.
         */
        Constructor<?> constructor = cls.getConstructor();

        /*
         * Step 3
         * Create object dynamically.
         * Reflection internally performs something similar to:
         * new Student();
         */
        Object object = constructor.newInstance();

        /*
         * Step 4
         * Locate methods.
         */
        Method setId = cls.getMethod("setId", int.class);

        Method setName = cls.getMethod("setName", String.class);

        Method display = cls.getMethod("display");

        /*
         * Step 5
         * Invoke methods.
         */
        setId.invoke(object, 101);

        setName.invoke(object, "Mohith");

        /*
         * Step 6
         * Execute display().
         */
        display.invoke(object);
    }
}