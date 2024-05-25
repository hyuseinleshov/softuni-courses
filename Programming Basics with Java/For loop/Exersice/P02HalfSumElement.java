package ForLoop_Exersise;

import java.util.Scanner;

public class P02HalfSumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int sumWithoutMaxNumber = 0;
        int sum = 0;
        int maxNumber = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            if (number > maxNumber) {
                maxNumber = number;
            }
            sum = sum + number;
            sumWithoutMaxNumber = sum - maxNumber;
        }
        int diff = Math.abs(sumWithoutMaxNumber - maxNumber);
        if (sumWithoutMaxNumber == maxNumber) {
            System.out.printf("Yes%nSum = %d",maxNumber);
        } else {
            System.out.printf("No%nDiff = %d",diff);
        }
    }
}
