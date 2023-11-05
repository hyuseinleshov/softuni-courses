package Exersice;

import java.util.Arrays;
import java.util.Scanner;

public class P05TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            boolean isBigger = false;
            for (int j = i + 1; j < numbers.length; j++) {
                if (number > numbers[j]) {
                    isBigger = true;
                } else  {
                    isBigger = false;
                }
            }
            if (isBigger) {
                System.out.print(number + " ");
            }
        }
        System.out.println(numbers[numbers.length - 1]);
    }
}
