package Exercise;

import java.util.Scanner;

public class P04PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();

        boolean isValid = true;

        if (!isBetween(password)) {
            isValid = false;
        }
        if (!isConsist(password)) {
            isValid = false;
        }
        if (!isHave(password)) {
            isValid = false;
        }
        if (isValid) {
            System.out.println("Password is valid");
        }
    }
    public static boolean isBetween (String password) {
        boolean isValid = true;
        if (!(password.length() >= 6 && password.length() <= 10)) {
            System.out.println("Password must be between 6 and 10 characters");
            isValid = false;
        }
        return isValid;
    }
    public static boolean isConsist (String password) {
        boolean isValid = true;
        for (int i = 0; i < password.length(); i++) {
            if (!(Character.isLetterOrDigit(password.charAt(i)))) {
                System.out.println("Password must consist only of letters and digits");
                isValid = false;
                break;
            }
        }
        return isValid;
    }
    public static boolean isHave (String password) {
        int count = 0;
        for (int i = 0; i < password.length(); i++) {
            char charAtI = password.charAt(i);
            if (charAtI == '0' || charAtI == '1' || charAtI == '2' ||charAtI == '3' || charAtI == '4' ||
                    charAtI == '5' || charAtI == '6' || charAtI == '7' || charAtI == '8' || charAtI == '9') {
                count++;
            }
        }
        if (count > 1) {
            return true;
        }
        System.out.println("Password must have at least 2 digits");
        return false;
    }
}
