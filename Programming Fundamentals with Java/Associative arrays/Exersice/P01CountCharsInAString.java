package Exersice;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Stream;

public class P01CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<Character, Integer> counts = new LinkedHashMap<>();

        char[] charactersArray = input.toCharArray();

        for (int i = 0; i < charactersArray.length; i++) {
            if (charactersArray[i] == ' ') {
                continue;
            }

            if (!counts.containsKey(charactersArray[i])) {
                counts.put(charactersArray[i], 0);
            }

            counts.put(charactersArray[i], counts.get(charactersArray[i]) + 1);
        }

        for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
