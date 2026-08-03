package D9_annotations.metaannotations.retention;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// Stored in .class file
// JVM ignores it
// Reflection CANNOT read it

@Retention(RetentionPolicy.CLASS)
public @interface ClassAnnotation {

}