package Exersice;

import java.util.Scanner;

public class P02CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] stringsArray = scanner.nextLine().split(" ");
        String firstString = stringsArray[0];
        String secondString = stringsArray[1];

        System.out.println(getMultipliedSum(firstString, secondString));
    }
    public static int getMultipliedSum (String firstString, String secondString) {
        int totalSum = 0;

        if (firstString.length() == secondString.length()) {
            for (int i = 0; i < firstString.length(); i++) {
                totalSum += (firstString.charAt(i) * secondString.charAt(i));
            }
        } else if (firstString.length() > secondString.length()){
            for (int i = 0; i < firstString.length(); i++) {
                if (i < secondString.length()) {
                    totalSum += (firstString.charAt(i) * secondString.charAt(i));
                } else {
                    totalSum += (int)firstString.charAt(i);
                }
            }
        } else {
            for (int i = 0; i < secondString.length(); i++) {
                if (i < firstString.length()) {
                    totalSum += (firstString.charAt(i) * secondString.charAt(i));
                } else {
                    totalSum += (int)secondString.charAt(i);
                }
            }
        }

        return totalSum;
    }
}
