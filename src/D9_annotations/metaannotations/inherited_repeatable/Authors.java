package D9_annotations.metaannotations.inherited_repeatable;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// Container annotation required by @Repeatable
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Authors {

    Author[] value();

}