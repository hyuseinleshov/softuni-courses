package Lab;

import java.math.BigInteger;
import java.util.Scanner;

public class P03BigFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        BigInteger number = new BigInteger("1");
        for (int i = 1; i <= n ; i++) {
            number = number.multiply(BigInteger.valueOf(i));
        }
        System.out.println(number);
    }
}
