package D3_packages.student;

public class Student {
    String name;
    int id;
    public Student(String n,int k){
        name=n;
        id=k;
    }
    public  void details(){
        System.out.println("Name: "+name);
        System.out.println("id: "+id);
    }
}
