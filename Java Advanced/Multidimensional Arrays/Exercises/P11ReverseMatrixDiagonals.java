package Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P11ReverseMatrixDiagonals {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split(" ");

        int r = Integer.parseInt(dimensions[0]);
        int c = Integer.parseInt(dimensions[1]);

         int[][] matrix = new int[r][c];

        for (int i = 0; i < r; i++) {
            int[] line = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            matrix[i] = line;
        }

        for (int d = r + c - 2; d >= 0; d--) {

            for (int i = r - 1; i >= 0; i--) {

                int j = d - i;

                if (j >= 0 && j < c) {
                    System.out.print(matrix[i][j] + " ");
                }

            }

            System.out.println();
        }

    }

}
