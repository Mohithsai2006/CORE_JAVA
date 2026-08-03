package D9_annotations.metaannotations.inherited_repeatable;
import java.lang.annotation.*;

@Inherited
@Repeatable(Authors.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface Author {

    String name();

}
