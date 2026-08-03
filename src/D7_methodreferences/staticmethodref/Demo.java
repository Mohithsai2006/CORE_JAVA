package D7_methodreferences.staticmethodref;

import java.util.Arrays;
import java.util.List;

import static D7_methodreferences.staticmethodref.Person.hello;

public class Demo {
    public static void main(String[] args) {
        List<String> ls=Arrays.asList("mohith","sai","pranav");
        ls.forEach(name->hello(name)); //lambda method

        ls.forEach(Person::hello);//static reference
    }
}
