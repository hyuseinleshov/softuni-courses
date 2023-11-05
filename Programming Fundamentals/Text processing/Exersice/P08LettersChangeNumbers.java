package Exersice;

import java.util.Scanner;

public class P08LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] stringsArray = input.split("\\s+");
        double totalSum = 0;

        for (int i = 0; i < stringsArray.length; i++) {
            String currentString = stringsArray[i];

            double modifiedNumber = getModifiedNumber(currentString);
            totalSum += modifiedNumber;
        }
        System.out.printf("%.2f", totalSum);
    }

    private static double getModifiedNumber(String currentString) {
        char letterBefore = currentString.charAt(0);
        char letterAfter = currentString.charAt(currentString.length() - 1);
        double number = Double.parseDouble(currentString.substring(1, currentString.length() - 1));

        if (Character.isUpperCase(letterBefore)) {
            number = number / (letterBefore - 64);
        } else if (Character.isLowerCase(letterBefore)){
            number = number * (letterBefore - 96);
        }

        if (Character.isUpperCase(letterAfter)) {
            number = number - (letterAfter - 64);
        } else if (Character.isLowerCase(letterAfter)) {
            number = number + (letterAfter - 96);
        }
        return number;
    }
}
