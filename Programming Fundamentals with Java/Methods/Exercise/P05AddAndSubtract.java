package Exercise;

import java.util.Scanner;

public class P05AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());
        int thirdNumber = Integer.parseInt(scanner.nextLine());

        int sum = subtract(firstNumber, secondNumber, thirdNumber);

        System.out.println(sum);
    }
    public static int sum (int n1, int n2) {
        int sum = n1 + n2;
        return sum;
    }
    public static int subtract (int n1, int n2, int n3) {
        int sum = sum(n1, n2) - n3;
        return sum;
    }
}
