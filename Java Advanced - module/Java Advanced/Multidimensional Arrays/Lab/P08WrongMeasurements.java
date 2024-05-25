package Lab;

import java.util.*;

public class P08WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        
        int[][] matrix = new int[rows][];

        for (int i = 0; i < matrix.length; i++) {
            int[] inputTokens = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            
            matrix[i] = inputTokens;
        }

        int[] wrongValueRowAndCol = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int wrongValue = matrix[wrongValueRowAndCol[0]][wrongValueRowAndCol[1]];

        List<int[]> parameters = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == wrongValue) {
                    int up = 0;
                    int down = 0;
                    int left = 0;
                    int right = 0;

                    if (isInBounds(matrix, row - 1, col) && matrix[row - 1][col] != wrongValue) {
                        up = matrix[row - 1][col];
                    }
                    // Left
                    if (isInBounds(matrix, row, col - 1) && matrix[row][col - 1] != wrongValue) {
                        left = matrix[row][col - 1];
                    }
                    // Down
                    if (isInBounds(matrix, row + 1, col) && matrix[row + 1][col] != wrongValue) {
                        down = matrix[row + 1][col];
                    }
                    // Right
                    if (isInBounds(matrix, row, col + 1) && matrix[row][col + 1] != wrongValue) {
                        right = matrix[row][col + 1];
                    }

                    int sum = up + down + left + right;

                    int[] parametersArray = new int[3];
                    parametersArray[0] = row;
                    parametersArray[1] = col;
                    parametersArray[2] = sum;

                    parameters.add(parametersArray);
                }
            }
        }

        for (int[] params : parameters) {
            matrix[params[0]][params[1]] = params[2];
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isInBounds(int[][] matrix, int r, int c) {
        return r >= 0 && r < matrix.length
                && c >= 0 && c < matrix[r].length;
    }

}
