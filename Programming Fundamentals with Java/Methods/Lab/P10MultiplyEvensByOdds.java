package Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P10MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Math.abs(Integer.parseInt(scanner.nextLine()));

        int result = getMultiples(number);
        System.out.println(result);
    }
    public static int getMultiples (int number) {
        int evenSum = evenSum(number);
        int oddSum = oddSum(number);

        return evenSum * oddSum;
    }
    public static int evenSum (int number) {
        String intToString = Integer.toString(number);

        int[] numbersArray = Arrays.stream(intToString.split("")).mapToInt(Integer::parseInt).toArray();

        int sum = 0;

        for (int n : numbersArray) {
            if (n % 2 == 0) {
                sum += n;
            }
        }
        return sum;
    }
    public static int oddSum (int number) {
        String intToString = Integer.toString(number);

        int[] numbersArray = Arrays.stream(intToString.split("")).mapToInt(Integer::parseInt).toArray();

        int sum = 0;

        for (int n : numbersArray) {
            if (n % 2 != 0) {
                sum += n;
            }
        }
        return sum;
    }
}
