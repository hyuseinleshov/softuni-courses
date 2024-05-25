package Exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String numbers = scanner.nextLine();

        int[] numbersArray = Arrays.stream(numbers.split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int number : numbersArray) {
            stack.push(number);
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
