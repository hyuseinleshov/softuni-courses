package MoreComplexChecks_Exersise;

import java.util.Scanner;

public class P03NewHouse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String flowersType = scanner.nextLine();
        int flowersCount = Integer.parseInt(scanner.nextLine());
        int budget = Integer.parseInt(scanner.nextLine());

        double price = 0;
        double discount = 0;
        double totalPrice = 0;

        switch (flowersType) {
            case "Roses":
                price = 5;
                totalPrice = price * flowersCount;
                if (flowersCount > 80) {
                    discount = 0.10;
                    totalPrice = (price * flowersCount) - ((price * flowersCount) * discount);
                }
                break;
            case "Dahlias":
                price = 3.80;
                totalPrice = price * flowersCount;
                if (flowersCount > 90) {
                    discount = 0.15;
                    totalPrice = (price * flowersCount) - ((price * flowersCount) * discount);
                }
                break;
            case "Tulips":
                price = 2.80;
                totalPrice = price * flowersCount;
                if (flowersCount > 80) {
                    discount = 0.15;
                    totalPrice = (price * flowersCount) - ((price * flowersCount) * discount);
                }
                break;
            case "Narcissus":
                price = 3;
                totalPrice = price * flowersCount;
                if (flowersCount < 120) {
                    discount = 0.15;
                    totalPrice = (price * flowersCount) + ((price * flowersCount) * discount);
                }
                break;
            case "Gladiolus":
                price = 2.50;
                totalPrice = price * flowersCount;
                if (flowersCount < 80) {
                    discount = 0.20;
                    totalPrice = (price * flowersCount) + ((price * flowersCount) * discount);
                }
                break;
        }
        double leftMoney = budget - totalPrice;
        double neededMoney = totalPrice - budget;
        if (budget >= totalPrice) {
            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.",flowersCount,flowersType,leftMoney);
        } else if (totalPrice > budget) {
            System.out.printf("Not enough money, you need %.2f leva more.",neededMoney);
        }
    }
}
