package ForLoop_Lecture;

import java.util.Scanner;

public class P09LeftAndRightSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0; i < n; i++) {
            int num1 = Integer.parseInt(scanner.nextLine());
            leftSum = leftSum + num1;
        }
        for (int i = 0; i < n; i++) {
            int num2 = Integer.parseInt(scanner.nextLine());
            rightSum = rightSum + num2;
        }
        int diff = Math.abs(rightSum - leftSum);
        if (rightSum == leftSum) {
            System.out.printf("Yes, sum = %d",rightSum);
        } else {
            System.out.printf("No, diff = %d",diff);
        }
    }
}
