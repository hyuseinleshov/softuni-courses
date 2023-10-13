package Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P07Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        List<List<Integer>> matrix = new ArrayList<>();
        
        int counter = 1;

        for (int row = 0; row < rows; row++) {
            List<Integer> numbers = new ArrayList<>();
            for (int col = 0; col < cols; col++) {
                numbers.add(counter);

                counter++;
            }

            matrix.add(numbers);
        }

        String input = scanner.nextLine();

        while (!input.equals("Nuke it from orbit")) {
            int[] commands = Arrays.stream(input.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int targetRow = commands[0];
            int targetCol = commands[1];
            int radius = commands[2];

            for (int row = targetRow - radius; row <= targetRow + radius; row++) {
                if (isInside(matrix, row, targetCol)) {
                    matrix.get(row).set(targetCol, 0);
                }
            }

            for (int col = targetCol - radius; col <= targetCol + radius; col++) {
                if (isInside(matrix, targetRow, col)) {
                    matrix.get(targetRow).set(col, 0);
                }
            }

            for (int row = 0; row < matrix.size(); row++) {
                List<Integer> currentRow = matrix.get(row);
                currentRow.removeAll(List.of(0));

                if (currentRow.size() == 0) {
                    matrix.remove(row);
                    row--;
                }
            }

            input = scanner.nextLine();
        }

        printMatrix(matrix);
    }

    private static boolean isInside(List<List<Integer>> matrix, int row, int col) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }

    private static void printMatrix(List<List<Integer>> matrix) {

        for (List<Integer> row : matrix) {
            row.forEach(n -> System.out.print(n + " "));
            System.out.println();
        }
    }

}
