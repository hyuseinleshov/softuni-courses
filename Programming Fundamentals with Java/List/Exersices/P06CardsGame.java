package Exersices;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P06CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstHand = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondHand = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        int firstPlayerSum = 0;
        int secondPlayerSum = 0;

        while (!(firstHand.isEmpty() || secondHand.isEmpty())) {
            for (int i = 0; i < firstHand.size(); i++) {
                if (firstHand.isEmpty() || secondHand.isEmpty()) {
                    break;
                }
                if (firstHand.get(i) > secondHand.get(i)) {
                    int winningCard = firstHand.get(i);
                    int secondCard = secondHand.get(i);
                    firstHand.remove(i);
                    firstHand.add(winningCard);
                    firstHand.add(secondCard);
                    secondHand.remove(i);
                    i = -1;
                } else if (secondHand.get(i) > firstHand.get(i)) {
                    int winningCard = secondHand.get(i);
                    int secondCard = firstHand.get(i);
                    secondHand.remove(i);
                    secondHand.add(winningCard);
                    secondHand.add(secondCard);
                    firstHand.remove(i);
                    i = -1;
                } else {
                    firstHand.remove(i);
                    secondHand.remove(i);
                    i = -1;
                }
            }
        }
        String winner = "";
        if (secondHand.isEmpty()) {
            for (int i = 0; i < firstHand.size(); i++) {
                firstPlayerSum += firstHand.get(i);
            }
            winner = "First";
            System.out.printf("%s player wins! Sum: %d", winner, firstPlayerSum);
        } else {
            for (int i = 0; i < secondHand.size(); i++) {
                secondPlayerSum += secondHand.get(i);
            }
            winner = "Second";
            System.out.printf("%s player wins! Sum: %d", winner, secondPlayerSum);
        }
    }
}
