package D1_controlflowstatements;


public class Main {

    // Method demonstrating return statement
    static int findSquare(int number) {

        // If number is negative, return immediately
        if (number < 0) {
            System.out.println("Negative number received.");
            return -1;
        }

        return number * number;
    }

    public static void main(String[] args) {

        System.out.println("========== CONTROL FLOW STATEMENTS IN JAVA ==========\n");

        // -------------------------------------------------------
        // 1. Simple if Statement
        // -------------------------------------------------------

        int age = 20;

        if (age >= 18) {
            System.out.println("if Statement : Person is eligible to vote.");
        }

        // -------------------------------------------------------
        // 2. if-else Statement
        // -------------------------------------------------------

        int marks = 45;

        if (marks >= 50) {
            System.out.println("if-else : Pass");
        } else {
            System.out.println("if-else : Fail");
        }

        // -------------------------------------------------------
        // 3. if-else-if Ladder
        // -------------------------------------------------------

        int percentage = 82;

        if (percentage >= 90) {
            System.out.println("Grade A");
        }
        else if (percentage >= 75) {
            System.out.println("Grade B");
        }
        else if (percentage >= 60) {
            System.out.println("Grade C");
        }
        else {
            System.out.println("Grade D");
        }

        // -------------------------------------------------------
        // 4. Nested if
        // -------------------------------------------------------

        boolean hasID = true;
        int personAge = 22;

        if (personAge >= 18) {

            if (hasID) {
                System.out.println("Nested if : Entry Allowed");
            }
            else {
                System.out.println("Nested if : ID Required");
            }

        } else {
            System.out.println("Nested if : Under Age");
        }

        // -------------------------------------------------------
        // 5. switch Statement
        // -------------------------------------------------------

        int day = 4;

        switch (day) {

            case 1:
                System.out.println("Monday");
                break;

            case 2:
                System.out.println("Tuesday");
                break;

            case 3:
                System.out.println("Wednesday");
                break;

            case 4:
                System.out.println("Thursday");
                break;

            case 5:
                System.out.println("Friday");
                break;

            default:
                System.out.println("Weekend");
        }

        // -------------------------------------------------------
        // 6. for Loop
        // -------------------------------------------------------

        System.out.println("\nfor Loop");

        for (int i = 1; i <= 5; i++) {
            System.out.println("Iteration : " + i);
        }

        // -------------------------------------------------------
        // 7. Enhanced for Loop (for-each)
        // -------------------------------------------------------

        System.out.println("\nEnhanced for Loop");

        String[] fruits = {"Apple", "Mango", "Orange"};

        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // -------------------------------------------------------
        // 8. while Loop
        // -------------------------------------------------------

        System.out.println("\nwhile Loop");

        int count = 1;

        while (count <= 5) {
            System.out.println("Count = " + count);
            count++;
        }

        // -------------------------------------------------------
        // 9. do-while Loop
        // -------------------------------------------------------

        System.out.println("\ndo-while Loop");

        int number = 1;

        do {
            System.out.println("Number = " + number);
            number++;
        }
        while (number <= 5);

        // -------------------------------------------------------
        // 10. break Statement
        // -------------------------------------------------------

        System.out.println("\nbreak Statement");

        for (int i = 1; i <= 10; i++) {

            if (i == 6) {
                System.out.println("Loop terminated at " + i);
                break;
            }

            System.out.println(i);
        }

        // -------------------------------------------------------
        // 11. continue Statement
        // -------------------------------------------------------

        System.out.println("\ncontinue Statement");

        for (int i = 1; i <= 10; i++) {

            if (i % 2 == 0) {
                continue;
            }

            System.out.println(i);
        }

        // -------------------------------------------------------
        // 12. Labeled break
        // -------------------------------------------------------

        System.out.println("\nLabeled break");

        outerLoop:

        for (int i = 1; i <= 3; i++) {

            for (int j = 1; j <= 3; j++) {

                System.out.println(i + " " + j);

                if (i == 2 && j == 2) {
                    System.out.println("Breaking both loops");
                    break outerLoop;
                }
            }
        }

        // -------------------------------------------------------
        // 13. Labeled continue
        // -------------------------------------------------------

        System.out.println("\nLabeled continue");

        outer:

        for (int i = 1; i <= 3; i++) {

            for (int j = 1; j <= 3; j++) {

                if (j == 2) {
                    continue outer;
                }

                System.out.println(i + " " + j);
            }
        }

        // -------------------------------------------------------
        // 14. return Statement
        // -------------------------------------------------------

        System.out.println("\nreturn Statement");

        int result = findSquare(6);

        System.out.println("Square = " + result);

        // Program ends here
        System.out.println("\nEnd of Program");
    }
}
