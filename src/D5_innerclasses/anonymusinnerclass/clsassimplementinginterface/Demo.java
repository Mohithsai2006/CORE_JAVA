package D5_innerclasses.anonymusinnerclass.clsassimplementinginterface;
public class Demo {
    public static void main(String[] args) {
        // Interface reference stored in Stack
        Worker w =
                // Anonymous class implementing Worker interface

                new Worker()
                 {
                    // Mandatory implementation of interface method
                    @Override
                    public void work() {
                        System.out.println("Employee is Working...");
                    }

                };
        // Calls overridden implementation
        w.work();
    }
}