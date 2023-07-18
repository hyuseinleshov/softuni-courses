package Lab;

import java.util.Scanner;

public class P07RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        repeatString(scanner.nextLine(), Integer.parseInt(scanner.nextLine()));
    }
    public static void repeatString (String input , int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(input);
        }
    }
}
