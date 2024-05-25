package Exercises;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P02BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] operationsArray = scanner.nextLine().split(" ");
        String[] numbersArray = scanner.nextLine().split("\\s+");

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int N = Integer.parseInt(operationsArray[0]);
        int S = Integer.parseInt(operationsArray[1]);
        int X = Integer.parseInt(operationsArray[2]);

        for (int i = 0; i < N; i++) {
            stack.push(Integer.parseInt(numbersArray[i]));
        }

        for (int i = 0; i < S; i++) {
            stack.pop();
        }

        if (stack.isEmpty()) {
            System.out.println(0);
        } else if (stack.contains(X)) {
            System.out.println("true");
        } else {
            System.out.println(Collections.min(stack));
        }
    }
}
