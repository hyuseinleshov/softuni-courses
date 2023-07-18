package Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String regex = "\\d+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        List<String> validWords = new ArrayList<>();

        while (matcher.find()) {
            validWords.add(matcher.group());
        }

        for (int i = 0; i < validWords.size(); i++) {
            System.out.println(validWords.get(i));
        }
    }
}
