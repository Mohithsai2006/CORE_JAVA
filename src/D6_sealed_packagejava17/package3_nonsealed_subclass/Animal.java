package D6_sealed_packagejava17.package3_nonsealed_subclass;

public sealed class Animal permits  Bird{
    public void eat(){
        System.out.println("Animal is eating");
    }
}
