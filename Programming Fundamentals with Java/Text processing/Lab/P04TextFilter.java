package Lab;

import java.util.Scanner;

public class P04TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] wordsToReplace = scanner.nextLine().split(", ");
        String text = scanner.nextLine();

        for (int i = 0; i < wordsToReplace.length; i++) {
            String asterisk = "";
            for (int j = 0; j < wordsToReplace[i].length(); j++) {
                asterisk += '*';
            }
            text = text.replace(wordsToReplace[i], asterisk);
        }
        System.out.println(text);
    }
}
