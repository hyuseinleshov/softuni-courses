package ForLoop_Exersise;

import java.util.Scanner;

public class P04CleverLily {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int age = Integer.parseInt(scanner.nextLine());
        double washMachinePrice = Double.parseDouble(scanner.nextLine());
        int toyPrice = Integer.parseInt(scanner.nextLine());

        double sum = 0;
        int toysCount = 0;
        for (int i = 1; i <= age ; i++) {
            if (i % 2 == 0) {
                sum = (sum + (i / 2) * 10) - 1;
            } else {
                toysCount++;
            }
        }
        double toysPrice = toyPrice * toysCount;
        double totalMoney = sum + toysPrice;
        double otherMoney = totalMoney - washMachinePrice;
        double neededMoney = washMachinePrice - totalMoney;
        if (totalMoney >= washMachinePrice) {
            System.out.printf("Yes! %.2f",otherMoney);
        } else {
            System.out.printf("No! %.2f",neededMoney);
        }
    }
}
