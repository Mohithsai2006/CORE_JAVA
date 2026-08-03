package D6_sealed_packagejava17.package3_nonsealed_subclass;
/*
 * non-sealed
 * ----------
 * Removes the restriction.
 *
 * Now ANY class can extend Bird.
 */
public non-sealed class Bird extends Animal {
    public void fly()
    {
        System.out.println("Bird is flying");
    }
}
