package D3_polymorphism.overridingbasedonvisibility;
class animal{
    protected void sound(){
        System.out.println("Animal is doing sound");
    }
}
class dog extends animal{
    public void sound(){
        System.out.println("Dog is barking");
    }
}
public class Increasedvisibility {
    public static void main(String[] args) {
        animal a=new dog();
        a.sound();
    }
}
