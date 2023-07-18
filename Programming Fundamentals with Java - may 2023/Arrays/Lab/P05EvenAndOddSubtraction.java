package Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P05EvenAndOddSubtraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbersArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(value -> Integer.parseInt(value)).toArray();

        int evenSum = 0;
        int oddSum = 0;

        for (int i = 0; i < numbersArr.length; i++) {
            if (numbersArr[i] % 2 == 0) {
                evenSum += numbersArr[i];
            } else  {
                oddSum += numbersArr[i];
            }
        }
        int diff = evenSum - oddSum;

        System.out.println(diff);
    }
}
