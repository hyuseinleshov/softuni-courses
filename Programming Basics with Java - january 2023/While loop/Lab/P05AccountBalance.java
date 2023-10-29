package WhileLoop_Lecture;

import java.util.Scanner;

public class P05AccountBalance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String money = scanner.nextLine();
        double total = 0;
        while (!money.equals("NoMoreMoney")) {
            double convertMoney = Double.parseDouble(money);
            if (convertMoney > 0) {
                System.out.printf("Increase: %.2f%n",convertMoney);
                total = total + convertMoney;
            } else {
                System.out.println("Invalid operation!");
                break;
            }
            money = scanner.nextLine();
        }
        System.out.printf("Total: %.2f",total);
    }
}
