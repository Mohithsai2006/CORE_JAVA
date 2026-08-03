package D9_annotations.metaannotations.retention;
public class Demo {

    public static void main(String[] args) {

        Class<Student> cls = Student.class;

        System.out.println(
                cls.isAnnotationPresent(RuntimeAnnotation.class));

        System.out.println(
                cls.isAnnotationPresent(ClassAnnotation.class));

        System.out.println(
                cls.isAnnotationPresent(SourceAnnotation.class));

    }

}