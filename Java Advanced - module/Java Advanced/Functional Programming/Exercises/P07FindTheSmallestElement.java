package Exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class P07FindTheSmallestElement {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        Function<int[], Integer> smallestNum = array -> {
            if (array == null || array.length == 0) {
                return 0;
            }

            int smallest = array[0];
            int index = 0;

            for (int i = 1; i < array.length; i++) {
                if (array[i] <= smallest) {
                    smallest = array[i];
                    index = i;
                }
            }

            return index;
        };

        int smallestIndex = smallestNum.apply(numbers);

        System.out.println(smallestIndex);

    }

}
