package proxydesignpattern.protectionproxy;

public class Main {
    public static void main(String[] args) {
        Database db=new DatabaseProxy("ADMIN");
        db.delete();
        Database db2=new DatabaseProxy("user");
        db2.delete();

    }
}
