package D11_comparable;

public class Student implements Comparable<Student> {
    int rollno;
    String name;
    int marks;
    public Student(int a,String b,int c){
        rollno=a;
        name=b;
        marks=c;
    }
    @Override
    public  int compareTo(Student o){
        //using Integer.compare()
//        return Integer.compare(this.rollno,o.rollno);
        //using ternary operator which is used in Integer.compare()
//        int x=this.rollno;
//        int y=o.rollno;
//        return (x < y) ? -1 : ((x == y) ? 0 : 1);
        //to compare name
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "["+rollno+" "+name+" "+marks+"]";
    }
}
