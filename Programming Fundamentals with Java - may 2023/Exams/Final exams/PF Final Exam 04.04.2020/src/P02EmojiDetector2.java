import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class P02EmojiDetector2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String numbers = input.replaceAll("[^0-9]", "");
        int[] numbersArray = Arrays.stream(numbers.split("")).mapToInt(Integer::parseInt).toArray();

        long coolThreshold = 1;
        for (int i = 0; i < numbersArray.length; i++) {
            coolThreshold *= numbersArray[i];
        }

        //String[] wordsArray = input.split("[ \t\n,?.!\"]+");

        String[] wordsArray = input.split("");
        List<String> allEmojis = new ArrayList<>();

        for (int i = 0; i < wordsArray.length; i++) {
            if (wordsArray[i].contains(":") || wordsArray[i].contains("*")) {
                allEmojis.add(wordsArray[i]);
            }
        }

        List<String> validEmojis = new ArrayList<>();

        for (int i = 0; i < allEmojis.size(); i++) {
            String currentEmoji = allEmojis.get(i);
            String firstTwoCharacters = currentEmoji.substring(0, 2);
            String lastTwoCharacters = currentEmoji.substring(currentEmoji.length() - 2, currentEmoji.length());
            String letters = currentEmoji.substring(2, currentEmoji.length() - 2);
            if ((firstTwoCharacters.equals("::") && lastTwoCharacters.equals("::")) || (firstTwoCharacters.equals("**") && lastTwoCharacters.equals("**"))) {
                if (letters.length() >= 3) {
                    if (Character.isUpperCase(letters.charAt(0))) {
                        boolean isValid = true;
                        for (int j = 1; j < letters.length() ; j++) {
                            if (Character.isLetter(letters.charAt(j)) && Character.isLowerCase(letters.charAt(j))) {

                            } else {
                                isValid = false;
                            }
                        }
                        if (isValid) {
                            validEmojis.add(currentEmoji);
                        }
                    }
                }
            }
        }

        System.out.printf("Cool threshold: %d%n", coolThreshold);
        System.out.printf("%d emojis found in the text. The cool ones are:%n", validEmojis.size());

        for (int i = 0; i < validEmojis.size(); i++) {
            String currentEmoji = validEmojis.get(i);
            long coolness = 0;
            for (int j = 0; j < currentEmoji.length(); j++) {
                coolness += (int) currentEmoji.charAt(j);
            }
            if (coolness > coolThreshold) {
                System.out.println(currentEmoji);
            }
        }
    }
}
