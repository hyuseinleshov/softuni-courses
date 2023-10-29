package NestedLoops_Exersise;

import java.util.Scanner;

public class P06CinemaTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int totalCounter = 0;
        int student = 0;
        int standard = 0;
        int kid = 0;
        while (!input.equals("Finish")) {
            int freeSeats = Integer.parseInt(scanner.nextLine());
            String type = scanner.nextLine();
            int counter = 0;

            while (!type.equals("End")) {
                counter++;
                totalCounter++;
                switch (type) {
                    case "student":
                        student++;
                        break;
                    case "standard":
                        standard++;
                        break;
                    case "kid":
                        kid++;
                        break;
                }
                if (counter >= freeSeats) {
                    break;
                }
                type = scanner.nextLine();
            }
            double total = counter * 1.0 / freeSeats * 100;
            System.out.printf("%s - %.2f%% full.%n",input,total);
            counter = 0;
            input = scanner.nextLine();
        }
        double studentPercent = student * 1.0 / totalCounter * 100;
        double standardPercent = standard * 1.0 / totalCounter * 100;
        double kidPercent = kid * 1.0 / totalCounter * 100;
        System.out.printf("Total tickets: %d%n",totalCounter);
        System.out.printf("%.2f%% student tickets.%n",studentPercent);
        System.out.printf("%.2f%% standard tickets.%n",standardPercent);
        System.out.printf("%.2f%% kids tickets.",kidPercent);
    }
}
