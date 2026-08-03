package D9_annotations.customannotations.markerannotation;

public class Demo {

    public static void main(String[] args) {

        // Reflection obtains metadata of Student class.
        Class<Student> cls = Student.class;

        // Check whether @Important exists.
        if (cls.isAnnotationPresent(Important.class)) {

            System.out.println("Important Annotation Found");

        } else {

            System.out.println("Annotation Not Found");

        }

    }
}
