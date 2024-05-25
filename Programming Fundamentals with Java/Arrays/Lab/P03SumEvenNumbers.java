package Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P03SumEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        String numbers = scanner.nextLine();
//
//        String[] numbersArrString = numbers.split(" ");
//
//        int[] numbersArr = new int[numbersArrString.length];
//
//        for (int i = 0; i < numbersArrString.length; i++) {
//            numbersArr[i] = Integer.parseInt(numbersArrString[i]);
//        }

        int[] numbersArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();

        int evenSum = 0;

        for (int i = 0; i < numbersArr.length; i++) {
            if (numbersArr[i] % 2 == 0) {
                evenSum += numbersArr[i];
            }
        }
        System.out.println(evenSum);
    }
}
