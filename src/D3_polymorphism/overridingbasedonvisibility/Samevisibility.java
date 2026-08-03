package D3_polymorphism.overridingbasedonvisibility;
class parent{
    public void show(){
        System.out.println("Parent show method");
    }
}
class child extends parent{
//    @Override
    public void show(){
        System.out.println("child show method");
    }

}
public class Samevisibility {
    public static void main(String[] args) {
        parent p= new child();
        p.show();
    }
}
