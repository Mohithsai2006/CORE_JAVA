package D9_annotations.customannotations.singlevaluedannotation;
public class Demo {

    public static void main(String[] args) {

        Class<Student> cls = Student.class;

        // Get annotation object using Reflection.
        Author author = cls.getAnnotation(Author.class);

        // Read stored value.
        System.out.println("Author : " + author.value());

    }

}
