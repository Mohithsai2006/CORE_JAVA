package D1_variables_wrapperclasses;
public class VariablesDemo {
    // ==========================
    // Static Variables
    // ==========================
    static String college = "XYZ University";
    static int studentCount = 0;
    // ==========================
    // Instance Variables
    // ==========================
    int rollNo;
    String name;
    double marks;
    boolean passed;
    public VariablesDemo(int rollNo, String name, double marks, boolean passed) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
        this.passed = passed;
        studentCount++;
    }
    public void display() {
        // ==========================
        // Local Variables
        // ==========================
        String grade;
        if (marks >= 90)
            grade = "A";
        else if (marks >= 75)
            grade = "B";
        else
            grade = "C";
        System.out.println("------------------------");
        System.out.println("Roll No : " + rollNo);
        System.out.println("Name    : " + name);
        System.out.println("Marks   : " + marks);
        System.out.println("Passed  : " + passed);
        System.out.println("Grade   : " + grade);
        System.out.println("College : " + college);
    }
    public static void main(String[] args) {
        // Local Primitive Variable
        int year = 2026;
        // Local Reference Variable
        VariablesDemo s1 = new VariablesDemo(101, "Mohith", 95.5, true);
        VariablesDemo s2 = new VariablesDemo(102, "Sai", 82.3, true);
        s1.display();
        s2.display();
        System.out.println("------------------------");
        System.out.println("Year : " + year);
        System.out.println("Total Students : " + studentCount);
    }
}
