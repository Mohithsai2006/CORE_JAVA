package D9_annotations.metaannotations.retention;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// Removed after compilation
// Not present in .class file

@Retention(RetentionPolicy.SOURCE)
public @interface SourceAnnotation {

}