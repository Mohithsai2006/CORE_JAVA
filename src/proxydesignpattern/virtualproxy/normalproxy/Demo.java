package proxydesignpattern.virtualproxy.normalproxy;

public class Demo {

    public static void main(String[] args) {
        Image i1=new RealImage("hi.png"); //irrespective of our use the expensive operation is executed while creation of object which is not necessary
        i1.display();





        Image image = new ProxyImage("photo.png");
        System.out.println("Proxy created.");
        System.out.println();
        image.display();//so we are creating the realobj when we required to call the method to perform expensive operation
        image.display(); //obj!=null so same obj is used


    }
}