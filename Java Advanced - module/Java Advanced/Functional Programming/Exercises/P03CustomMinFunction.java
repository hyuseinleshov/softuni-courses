package Exercises;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.function.Function;

public class P03CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Function<int[], Integer> findSmallest = (arr) -> {
            int smallest = arr[0];
            for (int num : arr) {
                if (num < smallest) {
                    smallest = num;
                }
            }
            return smallest;
        };

        System.out.println(findSmallest.apply(numbers));
    }
}
