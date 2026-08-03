package D9_annotations.customannotations.multivaluedannot;

public class Demo {

    public static void main(String[] args) {

        Class<Employee> cls = Employee.class;

        EmployeeInfo info = cls.getAnnotation(EmployeeInfo.class);

        System.out.println("Name       : " + info.name());
        System.out.println("Age        : " + info.age());
        System.out.println("Salary     : " + info.salary());
        System.out.println("Department : " + info.department());

    }

}