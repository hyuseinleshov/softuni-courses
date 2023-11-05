package JavaAdvancedExam_17June2023;

import java.util.Arrays;
import java.util.Scanner;

public class P02MouseInTheKitchen {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] cupboardDimensions = Arrays.stream(scanner.nextLine().split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = cupboardDimensions[0];
        int m = cupboardDimensions[1];

        int mouseRow = 0;
        int mouseCol = 0;

        int cheeseCount = 0;

        char[][] cupboard = new char[n][m];

        for (int row = 0; row < cupboard.length; row++) {

            char[] line = scanner.nextLine().toCharArray();

            for (int col = 0; col < cupboard[row].length; col++) {
                cupboard[row][col] = line[col];

                if (line[col] == 'M') {
                    mouseRow = row;
                    mouseCol = col;
                }

                if (line[col] == 'C') {
                    cheeseCount++;
                }
            }

        }

        String input = scanner.nextLine();

        while (!input.equals("danger")) {

            String direction = input;

            boolean isInside = checkDirection(n, m, direction, mouseRow, mouseCol);

            if (isInside == false) {
                System.out.println("No more cheese for tonight!");
                break;
            }

            int row = mouseRow;
            int col = mouseCol;

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

            char symbol = cupboard[row][col];

            if (symbol == 'C') {

                cupboard[mouseRow][mouseCol] = '*';
                cupboard[row][col] = 'M';

                mouseRow = row;
                mouseCol = col;
                cheeseCount--;

                if (cheeseCount == 0) {
                    System.out.println("Happy mouse! All the cheese is eaten, good night!");
                    break;
                }

            } else if (symbol == 'T') {

                cupboard[mouseRow][mouseCol] = '*';
                cupboard[row][col] = 'M';

                mouseRow = row;
                mouseCol = col;

                System.out.println("Mouse is trapped!");
                break;
                
            } else if (symbol == '*') {

                cupboard[mouseRow][mouseCol] = '*';
                cupboard[row][col] = 'M';

                mouseRow = row;
                mouseCol = col;

            }

            input = scanner.nextLine();
        }

        if (cheeseCount > 0 && input.equals("danger")) {
            System.out.println("Mouse will come back later!");
        }

        for (int row = 0; row < cupboard.length; row++) {
            for (int col = 0; col < cupboard[row].length; col++) {
                System.out.print(cupboard[row][col]);
            }
            System.out.println();
        }

    }

    private static boolean checkDirection(int n, int m, String direction, int mouseRow, int mouseCol) {

        switch (direction) {
            case "up":

                if (mouseRow - 1 < 0) {
                    return false;
                }
                break;
            case "down":

                if (mouseRow + 1 > n - 1) {
                    return false;
                }
                break;
            case "left":

                if (mouseCol - 1 < 0) {
                    return false;
                }
                break;
            case "right":

                if (mouseCol + 1 > m - 1) {
                    return false;
                }
                break;
        }

        return true;
    }

}
