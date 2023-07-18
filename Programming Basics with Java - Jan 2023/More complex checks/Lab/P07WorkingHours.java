package MoreComplexChecks_Lecture;

import java.util.Scanner;

public class P07WorkingHours {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hour = Integer.parseInt(scanner.nextLine());
        String dayOfWeek = scanner.nextLine();

        boolean workingDays = dayOfWeek.equals("Monday") || dayOfWeek.equals("Tuesday") || dayOfWeek.equals("Wednesday") ||
                dayOfWeek.equals("Thursday") || dayOfWeek.equals("Friday") || dayOfWeek.equals("Saturday");
        boolean workingHours = hour >=10 && hour <=18;

        if (workingDays && workingHours) {
            System.out.println("open");
        } else {
            System.out.println("closed");
        }
    }
}
