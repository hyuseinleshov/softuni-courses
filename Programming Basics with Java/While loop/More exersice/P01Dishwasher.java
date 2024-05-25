package WhileLoop_MoreExersise;

import java.util.Scanner;

public class P01Dishwasher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int washingAgentCount = Integer.parseInt(scanner.nextLine());
        int totalAgent = washingAgentCount * 750;

        String command = scanner.nextLine();
        int timesPut = 0;
        int platesCount = 0;
        int potsCount = 0;

        while (!command.equals("End")) {
            int dishes = Integer.parseInt(command);
            timesPut++;
            if (timesPut % 3 == 0) {
                totalAgent = totalAgent - (dishes * 15);
                potsCount += dishes;
            } else {
                totalAgent = totalAgent - (dishes * 5);
                platesCount += dishes;
            }
            if (totalAgent < 0) {
                System.out.printf("Not enough detergent, %d ml. more necessary!",Math.abs(totalAgent));
                break;
            }
            command = scanner.nextLine();
        }
        if (command.equals("End")) {
            System.out.printf("Detergent was enough!%n");
            System.out.printf("%d dishes and %d pots were washed.%n",platesCount,potsCount);
            System.out.printf("Leftover detergent %d ml.",totalAgent);
        }
    }
}
