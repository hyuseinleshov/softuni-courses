package ForLoop_Lecture;

import java.util.Scanner;

public class P10OddEvenSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int evenSum = 0;
        int oddSum = 0;

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            if (i % 2 == 0) {
                evenSum = evenSum + number;
            } else {
                oddSum = oddSum + number;
            }
        }
        int diff = Math.abs(evenSum - oddSum);
        if (evenSum == oddSum) {
            System.out.printf("Yes%nSum = %d",evenSum);
        } else {
            System.out.printf("No%nDiff = %d",diff);
        }
    }
}
