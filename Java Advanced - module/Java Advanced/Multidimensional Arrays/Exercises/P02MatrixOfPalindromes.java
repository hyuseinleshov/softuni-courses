package Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P02MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] tokens = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int r = tokens[0];
        int c = tokens[1];

        String[][] matrix = new String[r][c];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {

                char outsideSymbol = (char) ('a' + row);
                char middleSymbol = (char) (outsideSymbol + col);

                matrix[row][col] = String.valueOf(new char[] {outsideSymbol, middleSymbol, outsideSymbol});
            }
        }

        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

}
