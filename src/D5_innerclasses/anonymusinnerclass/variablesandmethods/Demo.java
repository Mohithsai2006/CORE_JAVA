package D5_innerclasses.anonymusinnerclass.variablesandmethods;
public class Demo {
    public static void main(String[] args) {
        Animal a = new Animal() {
            // Instance variable of anonymous class
            int age = 5;
            // Overridden method
            @Override
            public void sound() {
                System.out.println("Dog Barks");
                System.out.println("Age : " + age);

                // Calling another method of anonymous class
                run();
            }
            // New method
            public void run() {
                System.out.println("Dog is Running");
            }

        };
        a.sound();
        // ❌ Compile-time Error
        // a.run();          because the compiler checks the reference variable members so animal doesnt contian run hence compiler raises error
        // ❌ Compile-time Error
        // System.out.println(a.age);
        //so the methods and variables of anonymous class should be used inside that class only not outside the class
    }
}