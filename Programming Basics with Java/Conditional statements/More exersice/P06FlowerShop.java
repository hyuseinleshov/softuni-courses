package PBMoreE02ConditionalStatements;

import java.util.Scanner;

public class P06FlowerShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int magnolias = Integer.parseInt(scanner.nextLine());
        int hyacinths = Integer.parseInt(scanner.nextLine());
        int roses = Integer.parseInt(scanner.nextLine());
        int cactuses = Integer.parseInt(scanner.nextLine());
        double gift = Double.parseDouble(scanner.nextLine());

        //Магнолии – 3.25 лева
        //Зюмбюли – 4 лева
        //Рози – 3.50 лева
        //Кактуси – 8 лева
        //От общата сума, Мария трябва да плати 5% данъци.

        double magnoliasPrice = magnolias * 3.25;
        double hyacinthasPrice = hyacinths * 4;
        double rosesPrice = roses * 3.50;
        double cactusesPrice = cactuses * 8;
        double totalPrice = magnoliasPrice + hyacinthasPrice + rosesPrice + cactusesPrice;
        double tax = totalPrice * 0.05;
        double totalWithoutTax = totalPrice - tax;
        double remainedMoney = Math.floor(totalWithoutTax - gift);
        double neededMoney = Math.ceil(gift - totalWithoutTax);

        if (totalWithoutTax >= gift) {
            System.out.printf("She is left with %.0f leva.",remainedMoney);
        } else if (gift > totalWithoutTax) {
            System.out.printf("She will have to borrow %.0f leva.",neededMoney);
        }
    }
}
