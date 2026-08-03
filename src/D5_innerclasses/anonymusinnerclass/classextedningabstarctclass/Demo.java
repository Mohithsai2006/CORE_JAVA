package D5_innerclasses.anonymusinnerclass.classextedningabstarctclass;
public class Demo {
    public static void main(String[] args) {
        Animal a = new Animal() {
            // Mandatory implementation
            @Override
            public void sound() {
                System.out.println("Dog Barks");
            }

        };
        a.sound();
        // Inherited concrete method
        a.eat();
    }
}
