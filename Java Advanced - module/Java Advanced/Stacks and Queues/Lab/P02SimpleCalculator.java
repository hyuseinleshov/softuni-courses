package Lab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class P02SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String numbers = scanner.nextLine();

        ArrayDeque<String> stack = new ArrayDeque<>();

        String[] numbersArray = numbers.split("\\s+");

        Collections.addAll(stack, numbersArray);

        while (stack.size() > 1) {
            int firstNum = Integer.parseInt(stack.pop());
            String operation = stack.pop();
            int secondNum = Integer.parseInt(stack.pop());

            if (operation.equals("+")) {
                int sum = firstNum + secondNum;
                stack.push(String.valueOf(sum));
            } else {
                int sum = firstNum - secondNum;
                stack.push(String.valueOf(sum));
            }
        }

        System.out.println(stack.pop());
    }
}
