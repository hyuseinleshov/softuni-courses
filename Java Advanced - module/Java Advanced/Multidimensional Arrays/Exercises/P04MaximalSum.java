package Exercises;

import java.util.*;

public class P04MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] tokens = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = tokens[0];
        int m = tokens[1];

        int[][] matrix = new int[n][m];

        for (int row = 0; row < matrix.length; row++) {
            int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = numbers;
        }

        int biggestSum = 0;

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {
                int firstThree = matrix[row][col] + matrix[row + 1][col] + matrix[row + 2][col];
                int secondThree = matrix[row][col + 1] + matrix[row + 1][col + 1] + matrix[row + 2][col + 1];
                int thirdThree = matrix[row][col + 2] + matrix[row + 1][col + 2] + matrix[row + 2][col + 2];

                int sum = firstThree + secondThree + thirdThree;

                if (sum > biggestSum) {
                    biggestSum = sum;

                    queue.clear();

                    queue.offer(matrix[row][col]);
                    queue.offer(matrix[row][col + 1]);
                    queue.offer(matrix[row][col + 2]);

                    queue.offer(matrix[row + 1][col]);
                    queue.offer(matrix[row + 1][col + 1]);
                    queue.offer(matrix[row + 1][col + 2]);

                    queue.offer(matrix[row + 2][col]);
                    queue.offer(matrix[row + 2][col + 1]);
                    queue.offer(matrix[row + 2][col + 2]);
                }
            }
        }

        System.out.println("Sum = " + biggestSum);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 2) {
                    System.out.print(queue.poll());
                } else {
                    System.out.print(queue.poll() + " ");
                }
            }
            System.out.println();
        }
    }
}
