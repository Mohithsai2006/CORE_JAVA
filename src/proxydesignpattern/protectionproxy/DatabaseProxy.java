package proxydesignpattern.protectionproxy;

public class DatabaseProxy implements  Database{
    private Mysqldatabase db;
    String role;
    DatabaseProxy(String role){

        db=new Mysqldatabase();
        this.role=role;
    }
    @Override
    public void delete(){
        if(role.equals("ADMIN")){
            db.delete();
        }
        else{
            System.out.println("Access denied");
        }
    }
}
