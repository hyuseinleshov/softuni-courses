package Exersise;

import java.util.Scanner;

public class P03Elevator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int p = Integer.parseInt(scanner.nextLine());

        int fullCoursesCourses = n / p;
        int partialCourse = 0;

        if (n % p != 0) {
            partialCourse++;
        }

        int total = fullCoursesCourses + partialCourse;

        System.out.println(total);
    }
}
