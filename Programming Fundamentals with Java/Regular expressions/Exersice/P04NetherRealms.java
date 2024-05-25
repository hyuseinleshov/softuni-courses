package Exersice;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P04NetherRealms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "\\+?\\-?[0-9]+\\.?[0-9]*";
        Pattern pattern = Pattern.compile(regex);

        String input = scanner.nextLine();
        String[] demonNamesArray = input.split("\\s*,\\s*");

        for (int i = 0; i < demonNamesArray.length; i++) {
            String currentDemon = demonNamesArray[i];

            String allCharacters = currentDemon.replaceAll("[0-9+\\-*\\/.]+", "");
            int demonsTotalHealth = 0;
            for (int j = 0; j < allCharacters.length(); j++) {
                demonsTotalHealth += allCharacters.charAt(j);
            }

            Matcher matcher = pattern.matcher(currentDemon);

            double damage = 0;

            while (matcher.find()) {
                damage += Double.parseDouble(matcher.group());
            }

            String allSymbols = currentDemon.replaceAll("[^*/]+", "");

            for (int j = 0; j < allSymbols.length(); j++) {
                String symbol = String.valueOf(allSymbols.charAt(j));
                if (symbol.equals("*")) {
                    damage *= 2;
                } else {
                    damage /= 2;
                }
            }

            System.out.printf("%s - %d health, %.2f damage%n", currentDemon, demonsTotalHealth, damage);
        }
    }
}
