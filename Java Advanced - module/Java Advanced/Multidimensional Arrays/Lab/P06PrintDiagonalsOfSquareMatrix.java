package Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P06PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][size];

        for (int row = 0; row < matrix.length; row++) {
            int[] inputTokens = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            matrix[row] = inputTokens;
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (row == col) {
                    System.out.print(matrix[row][col] + " ");
                }
            }
        }

        System.out.println();

        int startCol = 0;

        for (int row = matrix.length - 1; row >= 0; row--) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (col == startCol) {
                    System.out.print(matrix[row][col] + " ");
                }
            }
            startCol++;
        }
    }
}
