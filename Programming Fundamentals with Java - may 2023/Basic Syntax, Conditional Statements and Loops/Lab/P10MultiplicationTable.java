package Lab;

import java.util.Scanner;

public class P10MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        // {theInteger} X {times} = {product}

        for (int i = 1; i <= 10 ; i++) {
            int result = i * n;
            System.out.printf("%d X %d = %d%n", n, i, result);
        }
    }
}
