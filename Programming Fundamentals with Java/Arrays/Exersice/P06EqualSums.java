package Exersice;

import java.util.Arrays;
import java.util.Scanner;

public class P06EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbersArray = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean isEqual = true;
        for (int i = 0; i < numbersArray.length; i++) {
            int leftSum = 0;
            int rightSum = 0;
            for (int j = 0; j <= i - 1; j++) {
                leftSum += numbersArray[j];
            }
            for (int j = i + 1; j < numbersArray.length; j++) {
                rightSum += numbersArray[j];
            }
            if (leftSum == rightSum) {
                System.out.print(i);
                isEqual = false;
                break;
            }
        }
        if (isEqual) {
            System.out.print("no");
        }
    }
}
