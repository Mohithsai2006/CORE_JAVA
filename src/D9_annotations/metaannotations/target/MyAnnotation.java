package D9_annotations.metaannotations.target;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

// This annotation can ONLY be applied to classes.
// If we try to use it on methods, fields, constructors, etc.,
// the compiler will report an error.

@Target(ElementType.TYPE)
public @interface MyAnnotation {

}