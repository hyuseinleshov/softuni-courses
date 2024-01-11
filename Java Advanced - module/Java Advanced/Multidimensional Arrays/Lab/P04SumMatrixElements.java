package Lab;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class P04SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        System.out.println(rows);
        System.out.println(cols);

        int[][] matrix = readMatrix(scanner, rows, cols);

        int sum  = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                sum += Integer.parseInt(String.valueOf(matrix[row][col]));
            }
        }

        System.out.println(sum);
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
