package WhileLoop_Lecture;

import java.util.Scanner;

public class P08Graduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();

        double grade = Double.parseDouble(scanner.nextLine());
        double total = 0;
        int year = 1;
        int poorGrades = 0;
        while (year <= 12) {
            if (grade >= 4) {
                total += grade;
                year++;
            } else {
                poorGrades++;
            }
            if (poorGrades > 1) {
                System.out.printf("%s has been excluded at %d grade",name,year);
                break;
            }
            if (year <= 12) {
                grade = Double.parseDouble(scanner.nextLine());
            }
        }
        if (poorGrades < 2) {
            double average = total / 12;
            System.out.printf("%s graduated. Average grade: %.2f",name,average);
        }
    }
}
