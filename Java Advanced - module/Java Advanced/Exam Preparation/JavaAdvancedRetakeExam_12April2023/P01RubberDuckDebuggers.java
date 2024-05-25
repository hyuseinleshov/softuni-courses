package JavaAdvancedRetakeExam_12April2023;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01RubberDuckDebuggers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int darthVaderDuckyCount = 0;
        int thorDuckyCount = 0;
        int bigBlueRubberDuckyCount = 0;
        int smallYellowRubberCount = 0;

        ArrayDeque<Integer> programmersTimeQueue = new ArrayDeque<>();
        Arrays.stream(scanner. nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(programmersTimeQueue::offer);

        ArrayDeque<Integer> numberOfTasksStack = new ArrayDeque<>();
        Arrays.stream(scanner. nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(numberOfTasksStack::push);

        while (!programmersTimeQueue.isEmpty() && !numberOfTasksStack.isEmpty()) {

            int currentProgrammerTime = programmersTimeQueue.peek();
            int currentNumberOfTasks = numberOfTasksStack.peek();

            int calculatedTime = currentProgrammerTime * currentNumberOfTasks;

            if (calculatedTime >= 0 && calculatedTime <= 240) {

                if (calculatedTime >= 0 && calculatedTime <= 60) {
                    
                    darthVaderDuckyCount++;
                } else if (calculatedTime >= 61 && calculatedTime <= 120) {
                    
                    thorDuckyCount++;
                } else if (calculatedTime >= 121 && calculatedTime <= 180) {
                    
                    bigBlueRubberDuckyCount++;
                } else if (calculatedTime >= 181 && calculatedTime <= 240) {

                    smallYellowRubberCount++;
                }

                programmersTimeQueue.poll();
                numberOfTasksStack.pop();
                
            } else if (calculatedTime > 240) {

                currentNumberOfTasks -= 2;
                numberOfTasksStack.pop();
                numberOfTasksStack.push(currentNumberOfTasks);

                programmersTimeQueue.poll();
                programmersTimeQueue.addLast(currentProgrammerTime);

                continue;
            }

        }

        System.out.println("Congratulations, all tasks have been completed! Rubber ducks rewarded:");

        System.out.println("Darth Vader Ducky: " + darthVaderDuckyCount);
        System.out.println("Thor Ducky: " + thorDuckyCount);
        System.out.println("Big Blue Rubber Ducky: " + bigBlueRubberDuckyCount);
        System.out.println("Small Yellow Rubber Ducky: " + smallYellowRubberCount);

    }

}
