package Lab;

import java.util.Scanner;

public class P05DigitsLettersAndOther {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        StringBuilder digitsSb = new StringBuilder();
        StringBuilder lettersSb = new StringBuilder();
        StringBuilder othersSb = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char currentSymbol = text.charAt(i);
            if (Character.isDigit(currentSymbol)) {
                digitsSb.append(currentSymbol);
            } else if (Character.isLetter(currentSymbol)) {
                lettersSb.append(currentSymbol);
            } else {
                othersSb.append(currentSymbol);
            }
        }
        System.out.println(digitsSb);
        System.out.println(lettersSb);
        System.out.println(othersSb);
    }
}
