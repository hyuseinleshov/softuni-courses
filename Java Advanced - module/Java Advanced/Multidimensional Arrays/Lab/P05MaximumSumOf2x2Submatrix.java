package Lab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P05MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = readMatrix(scanner, rows, cols);

        int biggestSum = 0;
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int first = matrix[row][col];
                int second = matrix[row][col + 1];
                int third = matrix[row + 1][col];
                int fourth = matrix[row + 1][col + 1];

                int sum = first + second + third + fourth;
                if (sum > biggestSum) {
                    queue.clear();
                    queue.offer(first);
                    queue.offer(second);
                    queue.offer(third);
                    queue.offer(fourth);
                    biggestSum = sum;
                }
            }
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(queue.poll() + " ");
            }
            System.out.println();
        }

        System.out.print(biggestSum);
    }

    private static int[][] readMatrix(Scanner scanner, int rows, int cols) {

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            int[] inputTokens = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

            matrix[row] = inputTokens;
        }

        return matrix;
    }
}
