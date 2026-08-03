package D9_annotations.customannotations.multivaluedannot;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// Multiple-value annotation.
//
// It contains several members.

@Retention(RetentionPolicy.RUNTIME)
public @interface EmployeeInfo {

    String name();

    int age();

    double salary();

    String department();

}
