package D7_methodreferences.instancemethodarbitaryobjref.eg;

public class Main {
    public static void main(String[] args) {
        //impl of functional interface using lambda expression
        Stringoperations s1= (str)->{
            return str.length(); //we called the method using argument obj thats why it is arbitary
        };
        System.out.println(s1.len("hello"));

        //implementation of functional interface using instancearbitarymethodinterface means the class name
        //should be the argument class name
        Stringoperations s2=String::length;
        System.out.println(s2.len("hello"));



    }
}
