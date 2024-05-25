package JavaAdvancedRetakeExam_12April2023;

import java.util.Scanner;

public class P02TheSquirrel {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int hazelnutsCount = 0;

        boolean isInField = true;
        boolean isTrapped = false;

        int n = Integer.parseInt(scanner.nextLine());

        char[][] field = new char[n][n];

        int squirrelRow = 0;
        int squirrelCol = 0;

        String[] commands = scanner.nextLine().split(", ");

        for (int row = 0; row < n; row++) {
            char[] line = scanner.nextLine().toCharArray();

            for (int col = 0; col < line.length; col++) {
                if (line[col] == 's') {
                    squirrelRow = row;
                    squirrelCol = col;

                    field[row][col] = '*';
                }

                field[row][col] = line[col];
            }

        }

        for (String command : commands) {

            int row = squirrelRow;
            int col = squirrelCol;

            switch (command) {

                case "up":

                    row--;
                    break;
                case "down":

                    row++;
                    break;
                case "right":

                    col++;
                    break;
                case "left":

                    col--;
                    break;
            }

            boolean  checkIsInField = checkRowAndCol(row, col, n);

            if (checkIsInField == false) {

                isInField = false;
                break;
            }

            char symbol = field[row][col];

            if (symbol == 'h') {

                hazelnutsCount++;
                field[row][col] = '*';

                if (hazelnutsCount == 3) {
                    break;
                }
            } else if (symbol == 't') {

                isTrapped = true;
                break;
            }

            squirrelRow = row;
            squirrelCol = col;

        }

        if (isInField == false) {
            System.out.println("The squirrel is out of the field.");
        } else if (isTrapped == true) {
            System.out.println("Unfortunately, the squirrel stepped on a trap...");
        } else if (hazelnutsCount < 3) {
            System.out.println("There are more hazelnuts to collect.");
        } else if (hazelnutsCount == 3) {
            System.out.println("Good job! You have collected all hazelnuts!");
        }

        System.out.println("Hazelnuts collected: " + hazelnutsCount);

    }

    private static boolean checkRowAndCol(int row, int col, int n) {

        return row >= 0 && row < n && col >= 0 && col < n;
    }

}
