import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P02EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] textWordsArray = input.split("[]");
        List<String> allEmojisList = new ArrayList<>();
        List<Integer> allDigits = new ArrayList<>();

        String numbers = input.replaceAll("[^0-9]", "");

        for (int i = 0; i < textWordsArray.length; i++) {
            if (textWordsArray[i].contains("::") || textWordsArray[i].contains("**")) {
                allEmojisList.add(textWordsArray[i]);
            }
        }

        List<String> validEmojis = new ArrayList<>();

        for (int i = 0; i < allEmojisList.size(); i++) {
            String currentEmoji = allEmojisList.get(i);
            String firstTwoCharacters = currentEmoji.substring(0, 2);
            String lastTwoCharacters = currentEmoji.substring(currentEmoji.length() - 2, currentEmoji.length());
            String charactersWithoutFirst = currentEmoji.substring(3, (currentEmoji.length() - 2));

            if ((firstTwoCharacters.equals("::") && lastTwoCharacters.equals("::") || (firstTwoCharacters.equals("**") && lastTwoCharacters.equals("**")))) {
                if ((currentEmoji.length() - 4) >= 3) {
                    if (Character.isUpperCase(currentEmoji.charAt(2))) {
                        boolean isNotValid = true;
                        for (int j = 0; j < charactersWithoutFirst.length(); j++) {
                            if ((Character.isLetter(charactersWithoutFirst.charAt(j)) && (Character.isLowerCase(charactersWithoutFirst.charAt(j))))) {

                            } else {
                                isNotValid = false;
                            }
                        }
                        if (isNotValid) {
                            validEmojis.add(currentEmoji);
                        }
                    }
                }
            }
        }
        long coolThreshold = 1;
        String[] numbersArray = numbers.split("");
        for (int i = 0; i < numbers.length(); i++) {
            coolThreshold = coolThreshold * (Integer.parseInt(numbersArray[i]));
        }

        System.out.printf("Cool threshold: %d%n", coolThreshold);

        List<String> coolEmojisList = new ArrayList<>();

        for (int i = 0; i < validEmojis.size(); i++) {
            int coolness = 0;
            String letters = validEmojis.get(i).substring(2, (validEmojis.get(i).length() - 2));
            for (int j = 0; j < letters.length(); j++) {
                coolness += (int) (letters.charAt(j));
            }
            if (coolness > coolThreshold) {
                coolEmojisList.add(validEmojis.get(i));
            }
        }

        System.out.printf("%d emojis found in the text. The cool ones are:%n", validEmojis.size());
        for (int i = 0; i < coolEmojisList.size(); i++) {
            System.out.println(coolEmojisList.get(i));
        }
    }
}
