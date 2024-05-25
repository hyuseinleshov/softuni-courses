package Exersice;

import java.util.Scanner;

public class P04CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        StringBuilder textSb = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char currentSymbol = text.charAt(i);
            char symbolToReplace = (char) (currentSymbol + 3);
            textSb.append(symbolToReplace);
        }
        System.out.println(textSb);
    }
}
