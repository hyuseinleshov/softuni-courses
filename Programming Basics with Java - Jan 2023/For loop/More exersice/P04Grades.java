package ForLoop_MoreExersises;

import java.util.Scanner;

public class P04Grades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int examStudents = Integer.parseInt(scanner.nextLine());

        int excellent = 0;
        int veryGood = 0;
        int great = 0;
        int fail = 0;

        double total = 0;

        for (int i = 1; i <= examStudents ; i++) {
            double studentsGrade = Double.parseDouble(scanner.nextLine());

            total = total + studentsGrade;

            if (studentsGrade >= 5.00) {
                excellent++;
            } else if (studentsGrade >= 4.00 && studentsGrade <= 4.99) {
               veryGood++; 
            } else if (studentsGrade >= 3.00 && studentsGrade <= 3.99) {
                great++;
            } else {
                fail++;
            }
        }
        double average = total / examStudents;

        double excellentPercent = excellent * 1.0 / examStudents * 100;
        double veryGoodPercent = veryGood * 1.0 / examStudents * 100;
        double greatPercent = great * 1.0 / examStudents * 100;
        double failPercent = fail * 1.0 / examStudents * 100;

        System.out.printf("Top students: %.2f%%%n",excellentPercent);
        System.out.printf("Between 4.00 and 4.99: %.2f%%%n",veryGoodPercent);
        System.out.printf("Between 3.00 and 3.99: %.2f%%%n",greatPercent);
        System.out.printf("Fail: %.2f%%%n",failPercent);
        System.out.printf("Average: %.2f",average);
    }
}
