 package WhileLoop_Exercise;

import java.util.Scanner;

public class P04Walking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String commandOrSteps = scanner.nextLine();
        int stepsGoal = 10000;
        int stepsSum = 0;

        while (stepsSum < stepsGoal) {
            if (commandOrSteps.equals("Going home")) {
                commandOrSteps = scanner.nextLine();
                int steps = Integer.parseInt(commandOrSteps);
                stepsSum = stepsSum + steps;
                break;
            } else {
                int steps = Integer.parseInt(commandOrSteps);
                stepsSum = stepsSum + steps;
            }
            if (stepsSum > 10000) {
                break;
            }
            commandOrSteps = scanner.nextLine();
        }
        int stepsDiff = Math.abs(stepsSum - stepsGoal);
        if (stepsSum >= stepsGoal) {
            System.out.printf("Goal reached! Good job!%n");
            System.out.printf("%d steps over the goal!",stepsDiff);
        } else {
            System.out.printf("%d more steps to reach goal.",stepsDiff);
        }
    }
}
