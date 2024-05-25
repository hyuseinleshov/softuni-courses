package Lab;

import java.util.Scanner;

public class P01ReverseStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        while (!text.equals("end")) {
            String reversedString = "";
            for (int i = text.length() - 1; i >= 0; i--) {
                reversedString += text.charAt(i);
            }

            System.out.printf("%s = %s%n", text, reversedString);

            text = scanner.nextLine();
        }
    }
}
