package D11_comparable;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        Student[] students={
                new Student(101,"a",500),
                new Student(102,"b",500),
                new Student(105,"c",600),
                new Student(100,"d",999),
        };
//        Arrays.sort(students); // we will get classCast exception because Student doesnt implement Comparable
          Arrays.sort(students);
          System.out.println(Arrays.toString(students));
    }
}
