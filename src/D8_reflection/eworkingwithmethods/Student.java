package D8_reflection.eworkingwithmethods;
public class Student {

    public void study() {
        System.out.println("Student is Studying...");
    }

    public int add(int a, int b) {
        return a + b;
    }

    protected void protectedMethod() {
        System.out.println("Protected Method");
    }

    void defaultMethod() {
        System.out.println("Default Method");
    }

    private void privateMethod() {
        System.out.println("Private Method");
    }

    public static void collegeName() {
        System.out.println("ABC College");
    }
}