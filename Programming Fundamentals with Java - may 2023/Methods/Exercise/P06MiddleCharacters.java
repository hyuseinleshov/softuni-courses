package Exercise;

import java.util.Scanner;

public class P06MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        getMiddleCharacter(text);
    }
    public static void getMiddleCharacter (String text) {
        if (text.length() % 2 == 0) {
            char firstCharacter = text.charAt((text.length() / 2) - 1);
            char secondCharacter = text.charAt(text.length() / 2);
            System.out.print(firstCharacter);
            System.out.print(secondCharacter);
        } else {
            char firstCharacter = text.charAt(text.length() / 2);
            System.out.println(firstCharacter);
        }
    }
}
