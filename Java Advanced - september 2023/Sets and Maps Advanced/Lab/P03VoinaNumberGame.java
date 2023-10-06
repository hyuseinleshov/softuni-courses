package Lab;


import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.HashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<Integer> firstPlayerDeck = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        LinkedHashSet<Integer> secondPlayerDeck = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        int rounds = 50;

        while (rounds-- > 0) {
            int firstPlayerCard = firstPlayerDeck.iterator().next();
            firstPlayerDeck.remove(firstPlayerCard);
            int secondPlayerCard = secondPlayerDeck.iterator().next();
            secondPlayerDeck.remove(secondPlayerCard);

            if (firstPlayerCard > secondPlayerCard) {
                firstPlayerDeck.add(firstPlayerCard);
                firstPlayerDeck.add(secondPlayerCard);
            } else if (secondPlayerCard > firstPlayerCard) {
                secondPlayerDeck.add(firstPlayerCard);
                secondPlayerDeck.add(secondPlayerCard);
            }

            if (firstPlayerDeck.isEmpty() || secondPlayerDeck.isEmpty()) {
                break;
            }
        }

        String output;

        if (firstPlayerDeck.size() > secondPlayerDeck.size()) {
            output = "First player win!";
        } else if (secondPlayerDeck.size() > firstPlayerDeck.size()) {
            output = "Second player win!";
        } else {
            output = "Draw!";
        }

        System.out.println(output);
    }
}
