package D6_sealed_packagejava17.package2_sealed_subclass_andfinal;

public sealed class Mammal extends Animal permits Dog {
    public void walk(){
        System.out.println("Mammal is walking");
    }
}
