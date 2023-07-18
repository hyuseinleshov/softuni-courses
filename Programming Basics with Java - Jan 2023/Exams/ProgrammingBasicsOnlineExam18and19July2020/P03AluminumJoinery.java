import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class P03AluminumJoinery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int windowsCount = Integer.parseInt(scanner.nextLine());
        String type = scanner.nextLine();
        String delivery = scanner.nextLine();

        double price = 0;

        if (type.equals("90X130")) {
            price = windowsCount * 110;
            if (windowsCount > 60) {
                price = price * 0.92;
            } else if (windowsCount > 30) {
                price = price * 0.95;
            }
        } else if (type.equals("100X150")) {
            price = windowsCount * 140;
            if (windowsCount > 80) {
                price = price * 0.90;
            } else if (windowsCount > 40) {
                price = price * 0.94;
            }
        } else if (type.equals("130X180")) {
            price = windowsCount * 190;
            if (windowsCount > 50) {
                price = price * 0.88;
            } else if (windowsCount > 20) {
                price = price * 0.93;
            }
        } else if (type.equals("200X300")) {
            price = windowsCount * 250;
            if (windowsCount > 50) {
                price = price * 0.86;
            } else if (windowsCount > 25) {
                price = price * 0.91;
            }
        }
        if (delivery.equals("With delivery")) {
            price += 60;
        } else if (delivery.equals("Without delivery")) {
            price = price;
        }
        if (windowsCount > 99) {
            price = price * 0.96;
        }

        if (windowsCount < 10) {
            System.out.printf("Invalid order");
        } else {
            System.out.printf("%.2f BGN",price);
        }
    }
}
