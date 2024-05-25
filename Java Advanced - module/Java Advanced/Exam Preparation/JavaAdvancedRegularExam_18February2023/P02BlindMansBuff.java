package JavaAdvancedRegularExam_18February2023;

import java.util.Scanner;

public class P02BlindMansBuff {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");

        int n = Integer.parseInt(tokens[0]);
        int m = Integer.parseInt(tokens[1]);

        char[][] playground = new char[n][m];

        int playerRow = 0;
        int playerCol = 0;

        int movesCount = 0;
        int touchedPlayersCount = 0;

        for (int row = 0; row < n; row++) {

            String[] line = scanner.nextLine().split("\\s+");

            for (int col = 0; col < line.length; col++) {

                char currentSymbol = line[col].charAt(0);

                if (currentSymbol == 'B') {

                    playerRow = row;
                    playerCol = col;

                    playground[row][col] = '-';
                } else {
                    playground[row][col] = currentSymbol;
                }

            }
        }

        String input = scanner.nextLine();

        while (!input.equals("Finish")) {

            String command = input;

            int row = playerRow;
            int col = playerCol;

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

            boolean isInRange = checkRowAndCol(row, col, n, m);

            if (isInRange == false) {

                input = scanner.nextLine();
                continue;
            }

            char symbolToStep = playground[row][col];

            if (symbolToStep == 'O') {

                input = scanner.nextLine();
                continue;
            } else if (symbolToStep == 'P') {

                playground[row][col] = '-';

                playerRow = row;
                playerCol = col;

                movesCount++;
                touchedPlayersCount++;

                if (touchedPlayersCount == 3) {

                    break;
                }
            } else if (symbolToStep == '-') {

                playerRow = row;
                playerCol = col;

                movesCount++;
            }

            input = scanner.nextLine();
        }

        System.out.println("Game over!");

        System.out.printf("Touched opponents: %d Moves made: %d", touchedPlayersCount, movesCount);

    }

    private static boolean checkRowAndCol(int row, int col, int rows, int cols) {

        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

}
