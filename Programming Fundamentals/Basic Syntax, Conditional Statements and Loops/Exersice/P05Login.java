package Exersise;

import java.util.Scanner;

public class P05Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();

        String reversePassword = "";
        for (int i = username.length() - 1; i >= 0; i--) {
            reversePassword = reversePassword + username.charAt(i);
        }
        int counter = 0;
        while (true) {
            String password = scanner.nextLine();
            counter++;
            if (password.equals(reversePassword)) {
                System.out.printf("User %s logged in.", username);
                break;
            } else if (!password.equals(reversePassword) && counter > 3) {
                System.out.printf("User %s blocked!", username);
                break;
            } else {
                System.out.println("Incorrect password. Try again.");
            }
        }
    }
}
