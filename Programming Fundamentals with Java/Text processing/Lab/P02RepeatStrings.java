package Lab;

import java.util.Scanner;

public class P02RepeatStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] wordsArray = scanner.nextLine().split(" ");

        String repeatedString = "";

        for (int i = 0; i < wordsArray.length; i++) {
            int length = wordsArray[i].length();

            for (int j = 0; j < length; j++) {
                repeatedString += wordsArray[i];
            }
        }
        System.out.println(repeatedString);
    }
}
