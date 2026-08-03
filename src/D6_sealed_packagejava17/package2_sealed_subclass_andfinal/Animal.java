package D6_sealed_packagejava17.package2_sealed_subclass_andfinal;

public sealed class Animal permits Mammal  {
    public void eat(){
        System.out.println("Animal is eating");
    }
}
