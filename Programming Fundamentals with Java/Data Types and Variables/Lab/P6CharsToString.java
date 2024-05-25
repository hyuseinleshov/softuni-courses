package Lab;

import java.util.Scanner;

public class P6CharsToString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String sum = "";
        for (int i = 0; i < 3; i++) {
            String a = scanner.nextLine();
            sum = sum + a;
        }
        System.out.println(sum);
    }
}
