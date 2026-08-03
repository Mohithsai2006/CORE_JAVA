package D9_annotations.metaannotations.retention;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// Stored in .class file
// Loaded by JVM
// Reflection CAN read it

@Retention(RetentionPolicy.RUNTIME)
public @interface RuntimeAnnotation {

}