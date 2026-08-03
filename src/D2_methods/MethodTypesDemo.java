package D2_methods;
public class MethodTypesDemo {

    // STATIC VARIABLE
    // Stored in the Method Area (Metaspace) as part of the loaded class.
    // Only one copy exists regardless of how many objects are created.
    // Created when the class is initialized (<clinit>()).
    // Destroyed only when the class is unloaded.
    static int totalObjects = 0;

    // INSTANCE VARIABLES
    // These are NOT stored with the method.
    // They are stored inside every object on the Heap.
    // Every object gets its own copy.
    int id;
    String name;

    // STATIC INITIALIZER
    // JVM internally converts this into a special method named <clinit>().
    // Bytecode for <clinit>() is stored once in the Method Area.
    // Invoked automatically only once when the class is first initialized.
    static {
        System.out.println("Static Block Executed");
    }

    // CONSTRUCTOR
    // Constructors are stored in the Method Area as special methods
    // named <init>().
    // Invoked automatically whenever "new" creates an object.
    // The object itself is created in the Heap BEFORE the constructor
    // starts executing.
    MethodTypesDemo(int id, String name) {

        this.id = id;
        this.name = name;
        totalObjects++;
    }

    // INSTANCE METHOD
    // Bytecode is stored only once in the Method Area.
    // Never copied into every object.
    // Requires an object reference.
    // Each invocation creates a new Stack Frame in the current thread's Stack.
    // Local variables below are stored inside that Stack Frame.
    // When the method returns, the Stack Frame is destroyed.
    void display() {

        int localVariable = 100;

        System.out.println(id);
        System.out.println(name);
        System.out.println(localVariable);
    }

    // STATIC METHOD
    // Bytecode stored once in Method Area.
    // Can be invoked without creating an object.
    // Each call creates a new Stack Frame.
    static void showTotalObjects() {

        System.out.println("Objects : " + totalObjects);
    }

    // FINAL METHOD
    // Stored exactly like a normal method.
    // Method metadata contains ACC_FINAL flag.
    // Cannot be overridden by subclasses.
    final void finalMethod() {

        System.out.println("Final Method");
    }

    // SYNCHRONIZED METHOD
    // Bytecode stored once in Method Area.
    // Method metadata contains ACC_SYNCHRONIZED flag.
    // JVM automatically acquires this object's monitor before executing.
    synchronized void synchronizedMethod() {

        System.out.println("Synchronized Method");
    }

    // RECURSIVE METHOD
    // Only ONE copy of this method exists in Method Area.
    // Every recursive call creates another Stack Frame.
    // The method itself is never duplicated.
    void recursiveMethod(int n) {

        if (n == 0)
            return;

        System.out.println("Level : " + n);

        recursiveMethod(n - 1);
    }

    // OVERLOADED METHODS
    // JVM stores each overloaded method separately in Method Area.
    // Compiler chooses which one to invoke based on parameter types.
    void add() {

        System.out.println("No Parameters");
    }

    void add(int a) {

        System.out.println(a);
    }

    void add(int a, int b) {

        System.out.println(a + b);
    }

    // MAIN METHOD
    // JVM starts execution here.
    // A Stack Frame for main() is created first.
    // Local variables below exist only inside main()'s Stack Frame.
    // When main() finishes, its Stack Frame is destroyed.
    public static void main(String[] args) {

        // Heap
        // Object created in Heap.
        // Constructor <init>() executes immediately after allocation.
        MethodTypesDemo obj = new MethodTypesDemo(101, "Alice");

        // Instance Method Invocation
        // JVM uses object's class information to locate display()
        // in Method Area.
        // New Stack Frame is created for display().
        obj.display();

        // Static Method Invocation
        // No object required.
        // JVM directly locates showTotalObjects() in Method Area.
        MethodTypesDemo.showTotalObjects();

        // Static method can also be invoked using an object.
        // Compiler allows it.
        // JVM still invokes the static method associated with the class,
        // not with the object.
        obj.showTotalObjects();

        // Final Method
        obj.finalMethod();

        // Synchronized Method
        obj.synchronizedMethod();

        // Recursive Method
        obj.recursiveMethod(3);

        // Overloaded Methods
        obj.add();
        obj.add(10);
        obj.add(10, 20);

        // Dynamic Method Dispatch (Overriding)
        // Parent reference stored in Stack.
        // Child object stored in Heap.
        // JVM decides at runtime which overridden method to execute.
        Parent p = new Child();
        p.overriddenMethod();

        // Interface Default Method
        // Object in Heap.
        // Method bytecode stored in interface metadata in Method Area.
        Printer printer = new PrinterImpl();
        printer.defaultMethod();

        // Interface Static Method
        // Stored once in Method Area.
        // Invoked using interface name.
        Printer.staticMethod();

        // Abstract Method
        // Parent reference stored in Stack.
        // Child implementation bytecode executed.
        Animal animal = new Dog();
        animal.sound();

        // Native Method
        // Method metadata stored in Method Area.
        // Actual implementation exists in JVM native libraries.
        System.out.println("Current Thread : " + Thread.currentThread().getName());

        // When main() returns:
        // All local variables disappear.
        // Objects remain in Heap until no references exist.
        // Methods remain in Method Area until the class is unloaded.
    }
}

// ABSTRACT CLASS
// Abstract method stores only metadata.
// No executable bytecode exists for sound() here.
abstract class Animal {

    abstract void sound();
}

// IMPLEMENTATION OF ABSTRACT METHOD
// Bytecode for sound() exists only here.
class Dog extends Animal {

    @Override
    void sound() {

        System.out.println("Dog Barking");
    }
}

// PARENT CLASS
// Bytecode stored once in Method Area.
class Parent {

    void overriddenMethod() {

        System.out.println("Parent Method");
    }
}

// CHILD CLASS
// Own copy of overriddenMethod() stored in Method Area.
// JVM performs Dynamic Method Dispatch at runtime.
class Child extends Parent {

    @Override
    void overriddenMethod() {

        System.out.println("Child Method");
    }
}

// INTERFACE
// Abstract methods store only metadata.
// Default and static methods store executable bytecode.
interface Printer {

    // Metadata only.
    void print();

    // Bytecode stored in Method Area.
    default void defaultMethod() {

        // Private interface method can only be called here.
        helper();

        System.out.println("Default Method");
    }

    // Bytecode stored once in Method Area.
    static void staticMethod() {

        System.out.println("Static Interface Method");
    }

    // Java 9+
    // Bytecode stored in Method Area.
    // Can only be invoked inside this interface.
    private void helper() {

        System.out.println("Private Interface Method");
    }
}

// INTERFACE IMPLEMENTATION
// Bytecode stored in Method Area.
class PrinterImpl implements Printer {

    @Override
    public void print() {

        System.out.println("Printing...");
    }
}

