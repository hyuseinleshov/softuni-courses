package Exercises;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P04CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Map<Character, Integer> characterOccurrences = new TreeMap<>();
        
        char[] allCharacters = text.toCharArray();

        for (int i = 0; i < allCharacters.length; i++) {
            char currentCharacter = allCharacters[i];
            if (!characterOccurrences.containsKey(currentCharacter)) {
                characterOccurrences.put(currentCharacter, 1);
            } else {
                characterOccurrences.put(currentCharacter, characterOccurrences.get(currentCharacter) + 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : characterOccurrences.entrySet()) {
            System.out.printf("%s: %d time/s%n", entry.getKey(), entry.getValue());
        }
    }
}
