package Lab;

import java.util.Scanner;

public class P01NumberInRange {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int startIndex = scanner.nextInt();
        int endIndex = scanner.nextInt();

        scanner.nextLine();

        System.out.printf("Range: [%d...%d]\n", startIndex, endIndex);

        String input = scanner.nextLine();
        int num = 0;

        while (true) {

            try {
                num = Integer.parseInt(input);

                if (!checkIsValid(num, startIndex, endIndex)) {
                    System.out.println("Invalid number: " + input);
                } else {
                    System.out.println("Valid number: " + num);
                    break;
                }

            } catch (NumberFormatException ex) {
                System.out.println("Invalid number: " + input);
            }

            input = scanner.nextLine();

        }

    }

    private static boolean checkIsValid(int num, int startIndex, int endIndex) {

        return num >= startIndex && num <= endIndex;
    }

}
