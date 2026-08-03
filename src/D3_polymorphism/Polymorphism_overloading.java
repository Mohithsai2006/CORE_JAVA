package D3_polymorphism;

public class Polymorphism_overloading {
    public static void add(int a,long b){
        System.out.println(a+b);
    }
    public static void add(int a){
        System.out.println(a+5);
    }

    public static void main(String[] args) {
        add(1,4);
        add(5);
    }
}
