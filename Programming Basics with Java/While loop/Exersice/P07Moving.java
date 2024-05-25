package WhileLoop_Exercise;

import java.util.Scanner;

public class P07Moving {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());

        int cubicMeters = width * length * height;

        String command = scanner.nextLine();

        while (!command.equals("Done")) {
            int cubic = Integer.parseInt(command);
            cubicMeters -= cubic;
            if (cubicMeters <= 0) {
                System.out.printf("No more free space! You need %d Cubic meters more.",Math.abs(cubicMeters));
                break;
            }
            command = scanner.nextLine();
        }
        if (command.equals("Done")) {
            System.out.printf("%d Cubic meters left.",cubicMeters);
        }
    }
}
