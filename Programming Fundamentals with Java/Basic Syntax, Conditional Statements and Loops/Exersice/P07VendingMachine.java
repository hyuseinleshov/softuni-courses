package Exersise;

import java.util.Scanner;

public class P07VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double sum = 0;
        double change = 0;

        while (!input.equals("Start")) {
            double coin = Double.parseDouble(input);
            boolean isValidCoins = coin == 0.1 || coin == 0.2 || coin == 0.5 || coin == 1 || coin == 2;
            if (!isValidCoins) {
                System.out.printf("Cannot accept %.2f%n",coin);
            } else {
                sum = sum + coin;
            }
            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        double price = 0;
        boolean isInvalid = false;

        while (!input.equals("End")) {
            switch (input) {
                case "Nuts":
                    price = 2.0;
                    break;
                case "Water":
                    price = 0.7;
                    break;
                case "Crisps":
                    price = 1.5;
                    break;
                case "Soda":
                    price = 0.8;
                    break;
                case "Coke":
                    price = 1.0;
                    break;
                default:
                    System.out.println("Invalid product");
                    isInvalid = true;
            }
            if (price > sum && !isInvalid) {
                System.out.println("Sorry, not enough money");
            } else if (sum >= price && !isInvalid){
                System.out.printf("Purchased %s%n", input);
            }
            if (!isInvalid && sum >= price) {
                sum = sum - price;
                change = sum;
            } else if (sum <= 0) {

            }
            input = scanner.nextLine();
        }
        System.out.printf("Change: %.2f", change);
    }
}
