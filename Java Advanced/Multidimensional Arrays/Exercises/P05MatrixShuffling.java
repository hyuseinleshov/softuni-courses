package Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P05MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
                String[] tokens = scanner.nextLine().split(" ");

                matrix[row] = tokens;
        }

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String[] tokens = input.split(" ");

            String command = tokens[0];

            if (!command.equals("swap")) {
                System.out.println("Invalid input!");
                input = scanner.nextLine();
                continue;
            } else if (tokens.length != 5) {
                System.out.println("Invalid input!");
                input = scanner.nextLine();
                continue;
            }

            int row1 = Integer.parseInt(tokens[1]);
            int col1 = Integer.parseInt(tokens[2]);
            int row2 = Integer.parseInt(tokens[3]);
            int col2 = Integer.parseInt(tokens[4]);

            boolean isValid = getIsValid(matrix.length, cols, row1, col1, row2, col2);

            if (isValid == false) {
                System.out.println("Invalid input!");
                input = scanner.nextLine();
                continue;
            }

            String replaced = matrix[row2][col2];
            matrix[row2][col2] = matrix[row1][col1];
            matrix[row1][col1] = replaced;

            printMatix(matrix);

            input = scanner.nextLine();
        }
    }

    private static void printMatix(String[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static boolean getIsValid(int length, int cols, int row1, int col1, int row2, int col2) {
        if (row1 < 0 || row1 > length) {
            return false;
        } else if (row2 < 0 || row2 > length) {
            return false;
        } else if (col1 < 0 || col1 > cols) {
            return false;
        } else if (col2 < 0 || col2 > cols) {
            return false;
        }

        return true;
    }
}
