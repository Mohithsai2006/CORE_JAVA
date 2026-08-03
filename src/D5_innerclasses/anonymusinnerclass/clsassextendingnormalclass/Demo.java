package D5_innerclasses.anonymusinnerclass.clsassextendingnormalclass;

public class Demo {
    public static void main(String[] args) {
        // Parent reference variable stored in Stack
        Animal a =
                // Creates an anonymous subclass of Animal
                //Demo$1 extends Animal      is created by jvm
                new Animal() {
                    // Overriding the parent method
                    @Override
                    public void sound() {
                        System.out.println("Dog Barks");
                    }

                };   // <-- Anonymous class object created here, the ref a is in stack

        // Runtime polymorphism
        // JVM calls overridden method of anonymous class
        a.sound();

    }
}