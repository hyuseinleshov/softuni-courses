package JavaAdvancedRetakeExam_14December2022;

import java.util.Scanner;

public class P02NavyBattle {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        char[][] battlefield = new char[n][n];

        int playerRow = 0;
        int playerCol = 0;

        int battleCruisersCount = 3;

        for (int row = 0; row < n; row++) {

            char[] line = scanner.nextLine().toCharArray();

            for (int col = 0; col < n; col++) {

                if (line[col] == 'S') {

                    playerRow = row;
                    playerCol = col;
                }

                battlefield[row][col] = line[col];
            }

        }

        int navalMinesHits = 0;

        while (navalMinesHits <= 2 && battleCruisersCount > 0) {

            String direction = scanner.nextLine();

            int row = playerRow;
            int col = playerCol;

            switch (direction) {
                case "up":

                    row--;
                    break;
                case "down":

                    row++;
                    break;
                case "left":

                    col--;
                    break;
                case "right":

                    col++;
                    break;
            }

            char symbolToStep = battlefield[row][col];

            if (symbolToStep == '-') {
                
                battlefield[playerRow][playerCol] = '-';
                battlefield[row][col] = 'S';
                
                playerRow = row;
                playerCol = col;
            } else if (symbolToStep == '*') {

                battlefield[playerRow][playerCol] = '-';
                battlefield[row][col] = 'S';

                playerRow = row;
                playerCol = col;

                navalMinesHits++;
            } else if (symbolToStep == 'C') {

                battlefield[playerRow][playerCol] = '-';
                battlefield[row][col] = 'S';

                playerRow = row;
                playerCol = col;

                battleCruisersCount--;
            }

        }

        if (navalMinesHits == 3) {
            System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!\n", playerRow, playerCol);
        } else if (battleCruisersCount == 0) {
            System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
        }

        for (int row = 0; row < n; row++) {

            for (int col = 0; col < n; col++) {

                System.out.print(battlefield[row][col]);
            }

            System.out.println();
        }

    }

}
