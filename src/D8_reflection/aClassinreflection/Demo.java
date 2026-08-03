package D8_reflection.aClassinreflection;

public class Demo {

    public static void main(String[] args) throws Exception {

        System.out.println("============== WAY 1 : Student.class ==============");

        /*
         * Student.class
         *
         * This is called a Class Literal.
         *
         * It DOES NOT create a Student object.
         *
         * It simply returns the Class object
         * representing Student class.
         */

        Class<Student> classObj1 = Student.class;

        System.out.println("Class Name : " + classObj1.getName());



        System.out.println("\n============== WAY 2 : obj.getClass() ==============");

        /*
         * Here an actual Student object is created.
         */

        Student s = new Student();

        /*
         * getClass() method is inherited from Object class.
         *
         * Every Java object automatically has this method.
         *
         * It returns the runtime class of the object.
         */

        Class<? extends Student> classObj2 =s.getClass();

        System.out.println("Class Name : " + classObj2.getName());



        System.out.println("\n============== WAY 3 : Class.forName() ==============");

        /*
         * Class.forName()
         *
         * Used when class name is available
         * only during runtime.
         *
         * This method asks JVM:
         *
         * "Please find this class and return its Class object."
         *
         * This is heavily used in:
         * Spring
         * Hibernate
         * JDBC
         * Custom Frameworks
         */

        Class<?> classObj3 =
                Class.forName(
                        "D8_reflection.aClassinreflection.Student"
                );

        System.out.println("Class Name : " + classObj3.getName());



        System.out.println("\n============== Comparing All Three ==============");

        /*
         * There is ONLY ONE Class object
         * for every loaded class.
         *
         * Therefore,
         * all three references should point
         * to exactly the same object.
         */

        System.out.println(classObj1 == classObj2);

        System.out.println(classObj2 == classObj3);

        System.out.println(classObj1 == classObj3);



        System.out.println("\n============== Hash Codes ==============");

        /*
         * Same hash code proves
         * all references are pointing
         * to the same Class object.
         */
        System.out.println(classObj1.hashCode());
        System.out.println(classObj2.hashCode());
        System.out.println(classObj3.hashCode());
    }
}
