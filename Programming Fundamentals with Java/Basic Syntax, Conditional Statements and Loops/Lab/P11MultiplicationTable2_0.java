package Lab;

import java.util.Scanner;

public class P11MultiplicationTable2_0 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int multiplier = Integer.parseInt(scanner.nextLine());

        // {theInteger} X {times} = {product}

        for (int i = multiplier; i <= 10 ; i++) {
            int result = i * n;
            System.out.printf("%d X %d = %d%n", n, i, result);
        }
        int result = n * multiplier;
        if (multiplier > 10) {
            System.out.printf("%d X %d = %d", n, multiplier, result);
        }
    }
}
