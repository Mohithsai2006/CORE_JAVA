package D6_sealed_packagejava17.package1_basic_sealed;
/*
 * sealed
 * ------
 * Only the classes listed in permits
 * are allowed to inherit Animal.
 */
public sealed class Animal permits Dog, Cat {
    public void eat() {
        System.out.println("Animal is Eating");
    }
}
