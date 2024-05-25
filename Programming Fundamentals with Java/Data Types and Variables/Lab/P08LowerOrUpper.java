package Lab;

import java.util.Locale;
import java.util.Scanner;

public class P08LowerOrUpper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String character = scanner.next();

        String upper = character.toUpperCase();

        if (character.equals(upper)) {
            System.out.println("upper-case");
        } else {
            System.out.println("lower-case");
        }
    }
}
