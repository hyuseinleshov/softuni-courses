package Lab;

import java.util.Scanner;

public class P03IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = readMatrix(scanner, rows, cols);
        char[][] secondMatrix = readMatrix(scanner, rows, cols);

        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col < firstMatrix[row].length; col++) {
                if (firstMatrix[row][col] != secondMatrix[row][col]) {
                    System.out.print("* ");
                } else {
                    System.out.print(firstMatrix[row][col] + " ");
                }
            }

            System.out.println();
        }
    }

    private static char[][] readMatrix(Scanner scanner, int rows, int cols) {

        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            String input = scanner.nextLine().replaceAll(" ", "");
            char[] inputTokens = input.toCharArray();
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = inputTokens[col];
            }
        }

        return matrix;
    }
}
