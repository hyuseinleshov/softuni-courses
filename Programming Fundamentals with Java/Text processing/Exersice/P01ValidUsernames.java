package Exersice;

import java.util.Scanner;

public class P01ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] usernamesArray = scanner.nextLine().split(", ");

        for (int i = 0; i < usernamesArray.length; i++) {
            int usernameLength = usernamesArray[i].length();
            String username = usernamesArray[i];
            boolean isValid = true;
            if (usernameLength >= 3 && usernameLength <= 16) {
                for (int j = 0; j < username.length(); j++) {
                    char symbol = username.charAt(j);
                    boolean isValidSymbol = symbol == '-' || symbol == '_' || Character.isLetter(symbol) || Character.isDigit(symbol);
                    if (isValidSymbol) {

                    } else {
                        isValid = false;
                        break;
                    }
                }
            } else {
                isValid = false;
            }
            if (isValid) {
                System.out.println(username);
            }
        }
    }
}
