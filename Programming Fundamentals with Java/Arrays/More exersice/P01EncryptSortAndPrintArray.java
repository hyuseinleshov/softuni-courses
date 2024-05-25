package MoreExersise;

import java.util.Arrays;
import java.util.Scanner;

public class P01EncryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[] textArray = new String[n];
        int[] sumArray = new int[n];

        for (int i = 0; i < n; i++) {
            String text = scanner.nextLine();
            textArray[i] = text;
        }

        for (int i = 0; i < n; i++) {
            String currentText = textArray[i];
            int sum = 0;
            for (int j = 0; j < currentText.length(); j++) {
                char charAtIndex = currentText.charAt(j);
                boolean isVowel = charAtIndex == 'A' || charAtIndex == 'E' || charAtIndex == 'I' ||
                        charAtIndex == 'O' || charAtIndex == 'U' || charAtIndex == 'a' || charAtIndex == 'e' ||
                        charAtIndex == 'i' || charAtIndex == 'o' || charAtIndex == 'u';
                if (isVowel) {
                    int codeForChar = (int) charAtIndex;
                    sum += codeForChar * currentText.length();
                } else {
                    int codeForChar2 = (int) charAtIndex;
                    sum += codeForChar2 / currentText.length();
                }
            }
            sumArray[i] = sum;
        }
        Arrays.sort(sumArray);
        for (int i = 0; i < n; i++) {
            System.out.println(sumArray[i]);
        }
    }
}
