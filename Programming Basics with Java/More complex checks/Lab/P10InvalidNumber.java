package MoreComplexChecks_Lecture;

import java.util.Scanner;

public class P10InvalidNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        boolean validDiapason = number == 0 || number >= 100 && number <= 200;

        if (!validDiapason) {
            System.out.printf("invalid");
        }
    }
}
