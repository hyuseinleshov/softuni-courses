package WhileLoop_Exercise;

import java.util.Scanner;

public class P02ExamPreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int poorGrades = Integer.parseInt(scanner.nextLine());

        String exersiseName = scanner.nextLine();
        int grade = Integer.parseInt(scanner.nextLine());
        int poorGradesCounter = 0;
        int total = 0;
        int gradesCount = 0;
        String lastExersise = "";

        while (poorGradesCounter < poorGrades) {
            total += grade;
            gradesCount++;
            if (grade <= 4) {
                poorGradesCounter++;
            }
            if (poorGradesCounter == poorGrades) {
                System.out.printf("You need a break, %d poor grades.",poorGradesCounter);
                break;
            }
            exersiseName = scanner.nextLine();
            if (!exersiseName.equals("Enough")) {
                lastExersise = exersiseName;
            }
            if (exersiseName.equals("Enough")) {
                break;
            }
            grade = Integer.parseInt(scanner.nextLine());
        }
        if (exersiseName.equals("Enough")) {
            System.out.printf("Average score: %.2f%n",total * 1.0 / gradesCount);
            System.out.printf("Number of problems: %d%n",gradesCount);
            System.out.printf("Last problem: %s",lastExersise);
        }
    }
}
