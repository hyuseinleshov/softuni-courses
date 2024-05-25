package E02ConditionalStatements;

import java.util.Scanner;

public class P04ToyShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double vacationPrice = Double.parseDouble(scanner.nextLine());
        int puzzels = Integer.parseInt(scanner.nextLine());
        int dolls = Integer.parseInt(scanner.nextLine());
        int teddyBears = Integer.parseInt(scanner.nextLine());
        int minions = Integer.parseInt(scanner.nextLine());
        int trucks = Integer.parseInt(scanner.nextLine());

        int totalToys = puzzels + dolls + teddyBears + minions + trucks;
        double priceForToys = puzzels * 2.60 + dolls * 3 + teddyBears * 4.10 + minions * 8.20 + trucks * 2;

        double discount = 0;
        if (totalToys >= 50) {
            discount = priceForToys * 0.25;
        }
         double winPrice = priceForToys - discount;
         double rent = winPrice * 0.10;
         double total = winPrice - rent;

         double remainingMoney = total - vacationPrice;
         double neededMoney = vacationPrice - total;

         if (total >= vacationPrice) {
             System.out.printf("Yes! %.2f lv left.",remainingMoney);
         } else  if (total < vacationPrice) {
             System.out.printf("Not enough money! %.2f lv needed.",neededMoney);
         }
    }
}
