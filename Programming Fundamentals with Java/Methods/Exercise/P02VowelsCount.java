package Exercise;

import java.util.Scanner;

public class P02VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().toLowerCase();

        vowelsCount(input);
    }
    public static void vowelsCount (String text) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            char charAtI = text.charAt(i);
            if (charAtI == 'a' || charAtI == 'e' || charAtI == 'i' || charAtI == 'o' || charAtI == 'u') {
                count++;
            }
        }
        System.out.println(count);
    }
}
