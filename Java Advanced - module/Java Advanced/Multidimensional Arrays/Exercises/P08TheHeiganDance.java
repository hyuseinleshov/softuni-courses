package Exercises;

import java.util.Scanner;

public class P08TheHeiganDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] chamberMatrix = new int[15][15];

        double playerHitPoints = 18500;
        double HeiganHitPoints = 3000000;

        int playerRow = 7;
        int playerCol = 7;

        double damage = Double.parseDouble(scanner.nextLine());

        boolean isCloudDamage = false;
        boolean isEruption = false;

        String lastSpell = "";

        int spellRow = 0;
        int spellCol = 0;

        while (playerHitPoints > 0 && HeiganHitPoints > 0) {
            String[] tokens = scanner.nextLine().split(" ");

            HeiganHitPoints -= damage;

            if (HeiganHitPoints <= 0) {
                break;
            }

            if (isCloudDamage) {
                playerHitPoints -= 3500;
                isCloudDamage = false;
                chamberMatrix = hitNeighboringCells(chamberMatrix, spellRow, spellCol, 0);
            }

            if (isEruption) {
                chamberMatrix = hitNeighboringCells(chamberMatrix, spellRow, spellCol, 0);
            }

            if (playerHitPoints <= 0) {
                break;
            }

            String spell = tokens[0];
            lastSpell = spell;
            int row = Integer.parseInt(tokens[1]);
            int col = Integer.parseInt(tokens[2]);

            spellRow = row;
            spellCol = col;

            int spellDamage = 0;

            if (spell.equals("Cloud")) {
                spellDamage = 3500;
                if (playerRow == row && playerCol == col) {
                    playerHitPoints -= spellDamage;
                    isCloudDamage = true;
                } else {
                    chamberMatrix = hitNeighboringCells(chamberMatrix, row, col, spellDamage);
                    if (chamberMatrix[playerRow][playerCol] == spellDamage) {
                        int[] playerRowAndCol = playerMove(chamberMatrix, playerRow, playerCol);
                        playerRow = playerRowAndCol[0];
                        playerCol = playerRowAndCol[1];
                    }
                }

            } else if (spell.equals("Eruption")) {
                if (isCloudDamage) {
                    playerHitPoints -= 3500;
                    isCloudDamage = false;
                }
                spellDamage = 6000;
                if (playerRow == row && playerCol == col) {
                    playerHitPoints -= spellDamage;
                } else {
                    chamberMatrix = hitNeighboringCells(chamberMatrix, row, col, spellDamage);
                    if (chamberMatrix[playerRow][playerCol] == spellDamage) {
                        int[] playerRowAndCol = playerMove(chamberMatrix, playerRow, playerCol);
                        playerRow = playerRowAndCol[0];
                        playerCol = playerRowAndCol[1];
                        isEruption = true;
                    }
                }

            }
        }

        if (HeiganHitPoints <= 0) {
            System.out.println("Heigan: Defeated!");
        } else {
            System.out.printf("Heigan: %.2f%n", HeiganHitPoints);
        }

        if (playerHitPoints <= 0) {
            if (lastSpell.equals("Cloud")) {
                System.out.println("Player: Killed by Plague Cloud");
            } else {
                System.out.println("Player: Killed by " + lastSpell);
            }
        } else {
            System.out.printf("Player: %.0f%n", playerHitPoints);
        }

        System.out.printf("Final position: %d, %d%n", playerRow, playerCol);
    }

    private static int[] playerMove(int[][] chamberMatrix, int playerRow, int playerCol) {
        int[] tokens = new int[2];
        
        // try up
        if (isValidCell(chamberMatrix, playerRow - 1, playerCol)) {
            if (chamberMatrix[playerRow - 1][playerCol] == 0) {
                tokens[0] = playerRow - 1;
                tokens[1] = playerCol;

                return tokens;
            }
        }
        // try right
        if (isValidCell(chamberMatrix, playerRow, playerCol + 1)) {
            if (chamberMatrix[playerRow][playerCol + 1] == 0) {
                tokens[0] = playerRow;
                tokens[1] = playerCol + 1;

                return tokens;
            }
        }
        // try down
        if (isValidCell(chamberMatrix, playerRow + 1, playerCol)) {
            if (chamberMatrix[playerRow + 1][playerCol] == 0) {
                tokens[0] = playerRow + 1;
                tokens[1] = playerCol;

                return tokens;
            }
        }
        // try left
        if (isValidCell(chamberMatrix, playerRow, playerCol - 1)) {
            if (chamberMatrix[playerRow][playerCol - 1] == 0) {
                tokens[0] = playerRow - 1;
                tokens[1] = playerCol;
            }
        }

        return tokens;
    }

    public static int[][] hitNeighboringCells(int[][] matrix, int row, int col, int damage) {

        matrix[row][col] = damage;

        int dimensionsLength = 15;

        int[] dr = {0, 0, -1, 1, 1, 1, -1, -1};
        int[] dc = {-1, 1, 0, 0, 1, -1, 1, -1};

        for (int i = 0; i < 8; i++) {
            int newRow = row + dr[i];
            int newCol = col + dc[i];

            if (newRow >= 0 && newRow < dimensionsLength && newCol >= 0 && newCol < dimensionsLength) {
                matrix[newRow][newCol] = damage;
            }
        }

        return matrix;
    }

    public static boolean isValidCell(int[][] matrix, int row, int col) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        return row >= 0 && row < numRows && col >= 0 && col < numCols;
    }

}
