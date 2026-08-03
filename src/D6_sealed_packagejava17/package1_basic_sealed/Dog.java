package D6_sealed_packagejava17.package1_basic_sealed;
/*
 * final
 * -----
 * Dog can inherit Animal,
 * but no class can inherit Dog.
 */
public final class Dog extends Animal {
    public void bark() {
        System.out.println("Dog is Barking");

    }
}