package NestedLoops_Exersise;

import java.util.Scanner;

public class P04TrainTheTrainers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int peoples = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        double totalSum = 0;
        int counter = 0;
        while (!input.equals("Finish")) {
            String presentationName = input;

            double average = 0;
            double sum = 0;

            for (int i = 1; i <= peoples ; i++) {
                double assessment = Double.parseDouble(scanner.nextLine());
                        sum += assessment;
                        totalSum += assessment;
                        counter++;
            }
            average = sum / peoples;
            System.out.printf("%s - %.2f.%n",presentationName,average);
            sum = 0;
            average = 0;
            input = scanner.nextLine();
        }
        double totalAverage = totalSum / counter;
        System.out.printf("Student's final assessment is %.2f.",totalAverage);
    }
}
