package NestedLoops_Lecture;

import java.util.Scanner;

public class P05Travelling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String destination = scanner.nextLine();

        while (!destination.equals("End")) {
            double neededMoney = Double.parseDouble(scanner.nextLine());

            double budget = 0;
            while (budget < neededMoney) {
                double savedMoney = Double.parseDouble(scanner.nextLine());
                budget += savedMoney;
            }
            if (budget >= neededMoney) {
                System.out.printf("Going to %s!%n",destination);
            }

            destination = scanner.nextLine();
        }
    }
}
