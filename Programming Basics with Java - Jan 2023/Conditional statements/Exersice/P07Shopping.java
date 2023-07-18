package E02ConditionalStatements;

import java.util.Scanner;

public class P07Shopping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double PetarBudget = Double.parseDouble(scanner.nextLine());
        int videocardCount = Integer.parseInt(scanner.nextLine());
        int processorCount = Integer.parseInt(scanner.nextLine());
        int ramMemoryCount = Integer.parseInt(scanner.nextLine());

        double videocardPrice = videocardCount * 250;
        double processorPrice = (videocardPrice * 0.35) * processorCount;
        double ramMemoryPrice = (videocardPrice * 0.1) * ramMemoryCount;

        double finalPrice = videocardPrice + processorPrice + ramMemoryPrice;
        if (videocardCount > processorCount) {
            finalPrice = finalPrice - (finalPrice * 0.15);
        }

        double restMoney = PetarBudget - finalPrice;
        double neededMoney = finalPrice - PetarBudget;

        if (PetarBudget >= finalPrice) {
            System.out.printf("You have %.2f leva left!",restMoney);
        } else {
            System.out.printf("Not enough money! You need %.2f leva more!",neededMoney);
        }
    }
}
