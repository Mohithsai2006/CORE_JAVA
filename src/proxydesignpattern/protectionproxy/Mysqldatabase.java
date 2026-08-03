package proxydesignpattern.protectionproxy;

public class Mysqldatabase implements  Database {
@Override
public void delete(){
System.out.println("Use has been deleted");
}

}
