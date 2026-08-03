package D9_annotations.customannotations.markerannotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// Marker Annotation
// Marker means it contains NO members.
// It simply marks something.

@Retention(RetentionPolicy.RUNTIME)
public @interface Important {

}