package Exersice;

import java.util.Scanner;

public class P06ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        StringBuilder nonRepeatedText = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char currentSymbol = text.charAt(i);
            if (i == text.length() - 1) {
                nonRepeatedText.append(currentSymbol);
                break;
            }
            char nextSymbol = text.charAt(i + 1);

            if (currentSymbol != nextSymbol) {
                nonRepeatedText.append(currentSymbol);
            }
        }
        System.out.println(nonRepeatedText);
    }
}
