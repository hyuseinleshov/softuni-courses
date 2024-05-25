package Exercise;

import java.util.Scanner;

public class P09PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            int number = Integer.parseInt(input);
            int lastDigit = number % 10;
            int firstDigit = 0;
            while (number > 0) {
                if (number < 10) {
                    firstDigit = number;
                    break;
                }
                number = number / 10;
            }
            if (firstDigit == lastDigit) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
            input = scanner.nextLine();
        }
    }
}
