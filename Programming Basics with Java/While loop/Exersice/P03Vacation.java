package WhileLoop_Exercise;

import java.util.Scanner;

public class P03Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double vacationMoney = Double.parseDouble(scanner.nextLine());
        double availableMoney = Double.parseDouble(scanner.nextLine());

        String command = scanner.nextLine();
        double sum = Double.parseDouble(scanner.nextLine());
        int spendCount = 0;
        int daysCount = 0;

        while (availableMoney < vacationMoney) {
            daysCount++;
            if (command.equals("spend")) {
                availableMoney = availableMoney - sum;
                spendCount++;
                if (availableMoney < 0) {
                    availableMoney = 0;
                }
            }
            if (command.equals("save")) {
                spendCount = 0;
                availableMoney = availableMoney + sum;
            }
            if (spendCount == 5) {
                System.out.printf("You can't save the money.%n");
                System.out.printf("%d",daysCount);
                break;
            }
            if (availableMoney >= vacationMoney) {
                break;
            }
            command = scanner.nextLine();
            sum = Double.parseDouble(scanner.nextLine());
        }
        if (availableMoney >= vacationMoney) {
            System.out.printf("You saved the money for %d days.",daysCount);
        }
    }
}
