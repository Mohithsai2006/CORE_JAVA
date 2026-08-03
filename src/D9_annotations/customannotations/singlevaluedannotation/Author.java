package D9_annotations.customannotations.singlevaluedannotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// Single-value annotation.
//
// When an annotation has ONE member named "value",
// Java allows us to omit "value=" while using it.

@Retention(RetentionPolicy.RUNTIME)
public @interface Author {

    String value();

}