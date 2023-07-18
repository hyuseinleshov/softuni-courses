package WhileLoop_Lecture;

import java.util.Scanner;

public class P03SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        int number2 = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        while (true) {
            sum = sum +number2;
            if (sum >= number) {
                break;
            }
            number2 = Integer.parseInt(scanner.nextLine());
        }
        System.out.println(sum);
    }
}
