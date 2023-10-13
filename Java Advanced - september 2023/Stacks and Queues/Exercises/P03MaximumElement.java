package Exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P03MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String command = scanner.nextLine();
            if (command.contains(" ")) {
                int[] numbersArray = Arrays.stream(command.split("\\s+")).mapToInt(Integer::parseInt).toArray();

                int number = numbersArray[1];

                stack.push(number);
            } else if (command.equals("2")) {
                stack.pop();
            } else if (command.equals("3")){
                System.out.println(Collections.max(stack));
            }
        }
    }
}
