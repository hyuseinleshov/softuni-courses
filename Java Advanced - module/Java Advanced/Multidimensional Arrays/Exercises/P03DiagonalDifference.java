package Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P03DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][n];

        for (int row = 0; row < matrix.length; row++) {
            int[] tokens = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = tokens;
        }

        int sumPrimaryDiagonal = getSumOfPrimaryDiagonal(matrix);
        int sumSecondaryDiagonal = getSumOfSecondaryDiagonal(matrix);

        System.out.println(Math.abs(sumPrimaryDiagonal - sumSecondaryDiagonal));
    }

    private static int getSumOfSecondaryDiagonal(int[][] matrix) {
        int sum = 0;
        int count = 0;
        for (int row = matrix.length - 1; row >= 0 ; row--) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (col == count) {
                    sum += matrix[row][col];
                }
            }
            count++;
        }

        return sum;
    }

    private static int getSumOfPrimaryDiagonal(int[][] matrix) {
        int sum = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (row == col) {
                    sum += matrix[row][col];
                }
            }
        }

        return sum;
    }
}
