package Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P01CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
//
//        int rows = dimensions[0];
//        int cols = dimensions[1];
//
//        int[][] firstMatrix = new int[rows][cols];
//
//        for (int row = 0; row < firstMatrix.length; row++) {
//            int[] inputTokens = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
//
//            firstMatrix[row] = inputTokens;
//        }
//
//        int[] dimensions2 = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
//
//        int rows2 = dimensions2[0];
//        int cols2 = dimensions2[1];
//
//        int[][] secondMatrix = new int[rows2][cols2];
//
//        for (int row = 0; row < secondMatrix.length; row++) {
//            int[] inputTokens = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
//
//            secondMatrix[row] = inputTokens;
//        }

        int[][] firstMatrix = readMatrix(scanner);
        int[][] secondMatrix = readMatrix(scanner);

        boolean isEquals = isMatrixEquals(firstMatrix, secondMatrix);

        if (isEquals) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }

    private static boolean isMatrixEquals(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length) {
            return false;
        }
        if (firstMatrix[0].length != secondMatrix[0].length) {
            return false;
        }

        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col < secondMatrix[row].length; col++) {
                if (firstMatrix[row][col] != secondMatrix[row][col]) {
                    return false;
                }
            }
        }


        return true;
    }

    private static int[][] readMatrix(Scanner scanner) {

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            int[] inputTokens = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            matrix[row] = inputTokens;
        }

        return matrix;
    }
}
