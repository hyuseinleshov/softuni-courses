package Exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P04BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbersArray = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int n = numbersArray[0];
        int s = numbersArray[1];
        int x = numbersArray[2];

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        int[] numbersToAddArray = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < n; i++) {
            queue.offer(numbersToAddArray[i]);
        }

        for (int i = 0; i < s; i++) {
            queue.poll();
        }

        if (queue.isEmpty()) {
            System.out.println(0);
        } else if (queue.contains(x)) {
            System.out.println("true");
        } else {
            System.out.println(Collections.min(queue));
        }
    }
}
