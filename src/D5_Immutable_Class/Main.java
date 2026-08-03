package D5_Immutable_Class;

public class Main {
    public static void main(String[] args){
        Ranking r1 = new Ranking(1);
        Immutable im = new Immutable(22, "ashwin", r1);

        //im.age = 100; not possible because private fields
        im.print();

        r1.rank= 2;
        im.print();

        Ranking temp = im.getRanking();
        temp.rank=3;
        im.print();
    }
}
