package D7_methodreferences.constructorreference;
//it is used when we calling constructor to create new object
//syntax :
// classname::new
public class Demo1 {
    public static void main(String[] args) {
        //lambda expression
        Creator<User> c1=(name)->{
            return new User(name);
        };
        User u1=c1.create("mohith");
        System.out.println("1: "+u1.name);
        //method ref
        Creator<User>c2=User::new;
        User u2=c2.create("sai");
        System.out.println("2: "+u2.name);


    }
}
