package WhileLoop_Lecture;

import java.util.Scanner;

public class P06MaxNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String number = scanner.nextLine();

        int max = Integer.MIN_VALUE;
        while (!number.equals("Stop")) {
            int convertNumber = Integer.parseInt(number);
            if (convertNumber > max) {
                max = convertNumber;
            }
            number = scanner.nextLine();
        }
        System.out.println(max);
    }
}
