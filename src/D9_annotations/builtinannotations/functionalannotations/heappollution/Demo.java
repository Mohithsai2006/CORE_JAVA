package D9_annotations.builtinannotations.functionalannotations.heappollution;

import java.util.ArrayList;
import java.util.List;

public class Demo {

    public static void main(String[] args) {

        List<String> names = new ArrayList<>();

        // Raw Type
        List raw = names;

        raw.add(100);

        System.out.println(names);

        // Runtime Error
        String s = names.get(0);
        //jvm internally does String s=(String)names.get(0) it assumes String obj is stored in heap but its Integer this is heap pollution

    }

}