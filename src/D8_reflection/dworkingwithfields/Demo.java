package D8_reflection.dworkingwithfields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Demo {

    public static void main(String[] args) throws Exception {

        // Create normal object
        Student student = new Student();

        // Reflection starts with Class object
        Class<Student> cls = Student.class;

        System.out.println("========== getFields() ==========");

        /*
         * Returns ONLY public fields.
         *
         * Includes inherited public fields also.
         */

        Field[] publicFields = cls.getFields();

        for (Field field : publicFields) {

            System.out.println("---------------------------");

            System.out.println("Field Name : "
                    + field.getName());

            System.out.println("Data Type : "
                    + field.getType().getSimpleName());

            System.out.println("Modifier : "
                    + Modifier.toString(field.getModifiers()));

        }

        System.out.println("\n========== getDeclaredFields() ==========");

        /*
         * Returns ALL fields declared
         * inside Student class.
         *
         * public
         * private
         * protected
         * default
         */

        Field[] allFields = cls.getDeclaredFields();

        for (Field field : allFields) {

            System.out.println("---------------------------");

            System.out.println("Field Name : "
                    + field.getName());

            System.out.println("Data Type : "
                    + field.getType().getSimpleName());

            System.out.println("Modifier : "
                    + Modifier.toString(field.getModifiers()));

        }

        System.out.println("\n========== getField() ==========");

        /*
         * Searches ONLY public field.
         */

        Field publicField = cls.getField("id");

        System.out.println(publicField);

        System.out.println("\n========== getDeclaredField() ==========");

        /*
         * Searches any field declared
         * inside Student class.
         *
         * Even private field can be found.
         */

        Field privateField =
                cls.getDeclaredField("name");

        System.out.println(privateField);

        System.out.println("\n========== Reading Public Field ==========");

        /*
         * Read value of public field.
         *
         * get() requires object reference
         * because id is an instance variable.
         */

        Object value = publicField.get(student);

        System.out.println("Current id : " + value);

        System.out.println("\n========== Updating Public Field ==========");

        /*
         * Modify public field.
         */

        publicField.set(student, 999);

        System.out.println("Updated id : " + student.id);

    }

}
