package Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P06StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        String input = scanner.nextLine();
        List<String> tokens = new ArrayList<>();

        int longestLength = 0;

        while (!input.equals("END")) {
            tokens.add(input);

            if (input.length() > longestLength) {
                longestLength = input.length();
            }

            input = scanner.nextLine();
        }

        char[][] matrix = new char[tokens.size()][];

        for (int row = 0; row < tokens.size(); row++) {
            StringBuilder tokenSb = new StringBuilder(tokens.get(row));

            if (tokenSb.length() < longestLength) {
                int count = longestLength - tokens.get(row).length();

                for (int i = 0; i < count; i++) {
                    tokenSb.append(" ");
                }
            }

            char[] token = tokenSb.toString().toCharArray();

            matrix[row] = token;
        }

        String degrees = command.replaceAll("[^0-9]", "");
        int rotatesCount = Integer.parseInt(degrees) / 90;

        if (rotatesCount % 4 == 0) {
            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[row].length; col++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        } else {
            for (int i = 1; i <= rotatesCount; i++) {
                matrix = rotateMatrix(matrix, i);
            }

            printMatrix(matrix);
        }
    }

    private static char[][] rotateMatrix(char[][] matrix, int count) {
            char[][] secondMatrix = new char[matrix[0].length][matrix.length];

            int rows = matrix.length;
            int cols = matrix[0].length;

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    secondMatrix[j][rows - 1 - i] = matrix[i][j];
                }
            }

            return secondMatrix;
    }

    private static void printMatrix(char[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
