package Lab;

import java.util.Scanner;

public class P05Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String product = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());

        printPrice(product, quantity);
    }
    public static void printPrice (String product, int quantity) {
        double price = 0;
        if (product.equals("coffee")) {
            price = 1.50;
        } else if (product.equals("water")) {
            price = 1;
        } else if (product.equals("coke")) {
            price = 1.40;
        } else if (product.equals("snacks")) {
            price = 2.00;
        }
        double totalPrice = quantity * price;
        System.out.printf("%.2f", totalPrice);
    }
}
