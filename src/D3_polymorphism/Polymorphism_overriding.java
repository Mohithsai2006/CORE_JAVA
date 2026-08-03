package D3_polymorphism;
class Animal{
    public void sound(){
        System.out.println("Animal is making sound");
    }
//    public static void  sleep(){
//        System.out.println("Animal is  sleeping");
//    }
    public void sleep(){
        System.out.println("Animal is  sleeping");
    }
}
class Dog extends Animal{
    @Override
    public void sound(){
        System.out.println("Dog is making sound");
    }
//    @Override
//    public static void  sleep(){
//        System.out.println("Dog is  sleeping");
//    }
    //static methods cant be overriden this is because override annotation , if we remove override then it will compile becuase then its comes under
    //method hiding instead of overriding
    @Override
    public void sleep(){
        System.out.println("Dog is  sleeping");
    }
}
public class Polymorphism_overriding {
    public static void main(String[] args) {
        Animal a=new Dog();
        a.sleep();
    }
}
