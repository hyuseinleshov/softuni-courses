package Lab;

import java.util.Scanner;

public class P02Grades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printGrades(Double.parseDouble(scanner.nextLine()));

    }
    public static void printGrades (double grade) {
        String gradeText = "";
        if (grade >= 2.00 && grade <= 2.99) {
            gradeText = "Fail";
        } else if (grade >= 3 && grade <= 3.49) {
            gradeText = "Poor";
        } else if (grade >= 3.50 && grade <= 4.49) {
            gradeText = "Good";
        } else if (grade >= 4.50 && grade <= 5.49) {
            gradeText = "Very good";
        } else if (grade >= 5.50) {
            gradeText = "Excellent";
        }
        System.out.println(gradeText);
    }
}
