import java.util.Scanner;

public class P02AddBags {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double over20kg = Double.parseDouble(scanner.nextLine());
        double kg = Integer.parseInt(scanner.nextLine());
        int days = Integer.parseInt(scanner.nextLine());
        int count = Integer.parseInt(scanner.nextLine());

        double tax = 0;
        if (kg < 10) {
            tax = over20kg * 0.2;
        } else if (kg <= 20) {
            tax = over20kg * 0.5;
        } else {
            tax = over20kg;
        }

        if (days > 30) {
            tax = tax * 1.10;
        } else if (days >= 7) {
            tax = tax * 1.15;
        } else {
            tax = tax * 1.40;
        }

        double totalSum = tax * count;

        System.out.printf("The total price of bags is: %.2f lv.",totalSum);
    }
}
