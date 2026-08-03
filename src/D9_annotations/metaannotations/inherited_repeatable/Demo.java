package D9_annotations.metaannotations.inherited_repeatable;


public class Demo {

    public static void main(String[] args) {

        // Reads inherited annotations from Parent
        Author[] authors =
                Child.class.getAnnotationsByType(Author.class);

        System.out.println("Authors:");

        for (Author author : authors) {

            System.out.println(author.name());

        }

    }

}