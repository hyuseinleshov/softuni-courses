package Lab;

import java.util.Scanner;

public class P07TheatrePromotion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         String dayType = scanner.nextLine();
         int age = Integer.parseInt(scanner.nextLine());

         int sale = 0;
         if (dayType.equals("Weekday")) {
             if (age >= 0 && age <= 18) {
                 sale = 12; 
             } else if (age > 18 && age <= 64) {
                 sale = 18;
             } else if (age > 64 && age <= 122) {
                 sale = 12;
             }
         }
        if (dayType.equals("Weekend")) {
            if (age >= 0 && age <= 18) {
                sale = 15;
            } else if (age > 18 && age <= 64) {
                sale = 20;
            } else if (age > 64 && age <= 122) {
                sale = 15;
            }
        }
        if (dayType.equals("Holiday")) {
            if (age >= 0 && age <= 18) {
                sale = 5;
            } else if (age > 18 && age <= 64) {
                sale = 12;
            } else if (age > 64 && age <= 122) {
                sale = 10;
            }
        }
        if (sale > 0) {
            System.out.printf("%d$", sale);
        } else {
            System.out.println("Error!");
        }
    }
}
