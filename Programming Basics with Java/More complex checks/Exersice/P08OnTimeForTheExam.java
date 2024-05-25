package MoreComplexChecks_Exersise;

import java.util.Scanner;

public class P08OnTimeForTheExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int examHour = Integer.parseInt(scanner.nextLine());
        int examMinute = Integer.parseInt(scanner.nextLine());
        int arrivalHour = Integer.parseInt(scanner.nextLine());
        int arrivalMinute = Integer.parseInt(scanner.nextLine());

        int examTimeMinute = (examHour * 60) + examMinute;
        int arrivalTimeMinute = (arrivalHour * 60) + arrivalMinute;

        int diffLate = arrivalTimeMinute - examTimeMinute;
        int diffEarly = examTimeMinute - arrivalTimeMinute;

        if (arrivalTimeMinute > examTimeMinute) {
            System.out.println("Late");
        } else if (examTimeMinute == arrivalTimeMinute || diffEarly <= 30) {
            System.out.println("On time");
        } else if (arrivalTimeMinute < examTimeMinute || diffEarly > 30) {
            System.out.println("Early");
        }
        int earlyHour = diffEarly / 60;
        int earlyMinute = Math.abs(diffEarly % 60);
        int lateHour = diffLate / 60;
        int lateMinute = Math.abs(diffLate % 60);

        if (arrivalTimeMinute != examTimeMinute) {
            if (diffEarly < 60 && arrivalTimeMinute < examTimeMinute) {
                System.out.printf("%d minutes before the start", earlyMinute);
            } else if (diffEarly >= 60 && earlyMinute < 10 && arrivalTimeMinute < examTimeMinute) {
                System.out.printf("%d:0%d hours before the start", earlyHour, earlyMinute);
            } else if (diffEarly >= 60 && earlyMinute > 10 && arrivalTimeMinute < examTimeMinute) {
                System.out.printf("%d:%d hours before the start", earlyHour, earlyMinute);
            } else if (diffLate < 60 && arrivalTimeMinute > examTimeMinute) {
                System.out.printf("%d minutes after the start", lateMinute);
            } else if (diffLate >= 60 && lateMinute < 10  && arrivalTimeMinute > examTimeMinute) {
                System.out.printf("%d:0%d hours after the start", lateHour, lateMinute);
            } else if (diffLate >= 60 && lateMinute > 10  && arrivalTimeMinute > examTimeMinute) {
                System.out.printf("%d:%d hours after the start", lateHour, lateMinute);
            }
        }
    }
}
