package D6_sealed_packagejava17.package2_sealed_subclass_andfinal;

public class Main {
    public static void main(String[] args) {
        Dog d= new Dog();
        d.eat();//from animal
        d.walk();// from mammal
        d.bark();//from dog
    }
}
