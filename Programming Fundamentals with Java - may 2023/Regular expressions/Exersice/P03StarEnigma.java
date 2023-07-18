package Exersice;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P03StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> attackedPlanets = new TreeMap<>();
        Map<String, Integer> destroyedPlanets = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String message = scanner.nextLine();

            String decryptionKey = message.replaceAll("[^STARstar]+", "");
            int count = decryptionKey.length();

            StringBuilder decryptedMessage = new StringBuilder();

            for (int j = 0; j < message.length(); j++) {
                char currentChar = (char) (message.charAt(j) - count);
                decryptedMessage.append(currentChar);
            }

            String regex = "@(?<planetName>[A-Za-z]+)[^@\\-!:>]*:(?<population>[0-9]+)[^@\\-!:>]*!(?<attackType>[A]?[D]?)![^@\\-!:>]*\\->(?<soldierCount>[0-9]+)";
            Pattern pattern = Pattern.compile(regex);

            Matcher matcher = pattern.matcher(decryptedMessage);

            if (matcher.find()) {
                String planetName = matcher.group("planetName");
                int population = Integer.parseInt(matcher.group("population"));
                String attackType = matcher.group("attackType");
                int soldierCount = Integer.parseInt(matcher.group("soldierCount"));

                if (attackType.equals("A")) {
                    attackedPlanets.put(planetName, population);
                } else {
                    destroyedPlanets.put(planetName, population);
                }
            }
        }
        System.out.println("Attacked planets: " + attackedPlanets.size());
        if (!attackedPlanets.isEmpty()) {
            for (Map.Entry<String, Integer> entry : attackedPlanets.entrySet()) {
                System.out.println("-> " + entry.getKey());
            }
        }
        System.out.println("Destroyed planets: " + destroyedPlanets.size());
        if (!destroyedPlanets.isEmpty()) {
            for (Map.Entry<String, Integer> entry : destroyedPlanets.entrySet()) {
                System.out.println("-> " + entry.getKey());
            }
        }
    }
}
