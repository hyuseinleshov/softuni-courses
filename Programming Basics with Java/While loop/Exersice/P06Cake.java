package WhileLoop_Exercise;

import java.util.Scanner;

public class P06Cake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());

        int piecesCount = width * length;

        String command = scanner.nextLine();

        while (!command.equals("STOP")) {
            int pieces = Integer.parseInt(command);
            piecesCount -= pieces;
            if (piecesCount <= 0) {
                System.out.printf("No more cake left! You need %d pieces more.",Math.abs(piecesCount));
                break;
            }
            command = scanner.nextLine();
        }
        if (command.equals("STOP")) {
            System.out.printf("%d pieces are left.",piecesCount);
        }
    }
}
