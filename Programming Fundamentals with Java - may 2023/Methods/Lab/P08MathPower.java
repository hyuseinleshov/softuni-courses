package Lab;

import java.text.DecimalFormat;
import java.util.Scanner;

public class P08MathPower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double result = mathPower(Double.parseDouble(scanner.nextLine()), Integer.parseInt(scanner.nextLine()));

        System.out.println(new DecimalFormat("0.####").format(result));
    }
    public static double mathPower (double number, int power) {
        return Math.pow(number, power);
    }
}
