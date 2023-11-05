package E02ConditionalStatements;

import java.util.Scanner;

public class P03TimePlus15Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hour = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());

        int minutes2 = hour * 60;
        int totalMinutes = minutes2 + minutes;
        int minutesPlus15 =totalMinutes + 15;

        int hour2 = minutesPlus15 / 60;
        int minutes3 = minutesPlus15 % 60;

        if (hour2 <= 23) {
            System.out.printf("%d:%02d",hour2,minutes3);
        } else if (hour2 > 23) {
            System.out.printf("0:%02d",minutes3);
        }
    }
}
