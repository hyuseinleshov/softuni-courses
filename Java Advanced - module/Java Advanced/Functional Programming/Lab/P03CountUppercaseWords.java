package Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P03CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split("\\s+");

        Predicate<String> isUppercase = word -> Character.isUpperCase(word.charAt(0));

        Function<String[], List<String>> uppercaseWords = arr -> Arrays.stream(arr).filter(isUppercase).collect(Collectors.toList());

        List<String> wordsList = uppercaseWords.apply(words);

        System.out.println(wordsList.size());

        wordsList.stream().forEach(word -> System.out.println(word));
    }
}