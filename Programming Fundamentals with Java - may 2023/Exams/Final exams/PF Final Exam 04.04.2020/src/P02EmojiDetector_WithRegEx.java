import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02EmojiDetector_WithRegEx {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String regexForNumbers = "\\d";
        Pattern patternForNumbers = Pattern.compile(regexForNumbers);
        Matcher numbers = patternForNumbers.matcher(input);

        BigInteger coolThreshold = new BigInteger("1");

        while (numbers.find()) {
            BigInteger number = new BigInteger(numbers.group());
            coolThreshold = coolThreshold.multiply(number);
        }

        System.out.println("Cool threshold: " + coolThreshold);

        String regexForValidEmojis = "([:*]{2})(?<letters>[A-Z][a-z]{2,})\\1";
        Pattern patternForValidEmojis = Pattern.compile(regexForValidEmojis);
        Matcher validEmojis = patternForValidEmojis.matcher(input);

        List<String> allValidEmojis = new ArrayList<>();

        while (validEmojis.find()) {
            allValidEmojis.add(validEmojis.group());
        }

        System.out.println(allValidEmojis.size() + " emojis found in the text. The cool ones are:");

        for (int i = 0; i < allValidEmojis.size(); i++) {
            String currentEmoji = allValidEmojis.get(i);
            String currentEmojiLetters = allValidEmojis.get(i).substring(2, currentEmoji.length() - 2);

            BigInteger coolness = new BigInteger("0");

            for (int j = 0; j < currentEmojiLetters.length(); j++) {
                int number = currentEmojiLetters.charAt(j);
                BigInteger currentLetterNumber = new BigInteger(String.valueOf(number));
                coolness = coolness.add(currentLetterNumber);
            }
            if (coolness.compareTo(coolThreshold) > 0) {
                System.out.println(currentEmoji);
            }
        }
    }
}
