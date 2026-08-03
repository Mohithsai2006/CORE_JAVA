package D9_annotations.metaannotations.inherited_repeatable;

import java.lang.annotation.Inherited;

// Same annotation used twice because of @Repeatable

@Author(name = "James")
@Author(name = "Scott")
public class Parent {

}
