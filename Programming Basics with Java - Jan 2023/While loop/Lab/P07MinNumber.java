package WhileLoop_Lecture;

import java.util.Scanner;

public class P07MinNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String number = scanner.nextLine();

        int min = Integer.MAX_VALUE;
        while (!number.equals("Stop")) {
            int convertNumber = Integer.parseInt(number);
            if (convertNumber < min) {
                min = convertNumber;
            }
            number = scanner.nextLine();
        }
        System.out.println(min);
    }
}
