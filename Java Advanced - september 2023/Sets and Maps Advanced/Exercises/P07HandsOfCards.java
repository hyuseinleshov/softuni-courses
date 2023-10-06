package Exercises;

import java.util.*;

public class P07HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Integer> personsScore = new LinkedHashMap<>();
        Map<String, Set<String>> personsCards = new LinkedHashMap<>();

        while (!input.equals("JOKER")) {
            int index = input.indexOf(':');
            String cards = input.substring(index + 2, input.length());
            String name = input.substring(0, index);

            String[] tokens = cards.split(", ");

           if (!personsCards.containsKey(name)) {
               personsCards.put(name, new LinkedHashSet<>());
           }

            for (int i = 0; i < tokens.length; i++) {
                String card = tokens[i];
                personsCards.get(name).add(card);
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, Set<String>> entry : personsCards.entrySet()) {
            int cardsValue = 0;

            for (String card : entry.getValue()) {
                String power = "";
                char type;
                if (card.length() > 2) {
                    power = card.substring(0, 2);
                    type = card.charAt(2);
                } else {
                    power = card.substring(0, 1);
                    type = card.charAt(1);
                }

                int p = 0;
                int t = 0;

                switch (power) {
                    case "J":
                        p = 11;
                        break;
                    case "Q":
                        p = 12;
                        break;
                    case "K":
                        p = 13;
                        break;
                    case "A":
                        p = 14;
                        break;
                    default:
                        p = Integer.parseInt(power);
                        break;
                }

                switch (type) {
                    case 'S':
                        t = 4;
                        break;
                    case 'H':
                        t = 3;
                        break;
                    case 'D':
                        t = 2;
                        break;
                    case 'C':
                        t = 1;
                        break;
                }

                cardsValue += (p * t);
            }

            String name = entry.getKey();

            if (!personsScore.containsKey(name)) {
                personsScore.put(name, cardsValue);
            } else {
                personsScore.put(name, personsScore.get(name) + cardsValue);
            }
        }

        for (Map.Entry<String, Integer> entry : personsScore.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
