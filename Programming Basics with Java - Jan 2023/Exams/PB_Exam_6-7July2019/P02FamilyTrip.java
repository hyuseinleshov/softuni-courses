import java.util.Scanner;

public class P02FamilyTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int nights = Integer.parseInt(scanner.nextLine());
        double priceForNight = Double.parseDouble(scanner.nextLine());
        int othersPercent = Integer.parseInt(scanner.nextLine());

        if (nights > 7) {
            priceForNight = priceForNight - (priceForNight * 0.05);
        }

        double totalPrice = nights * priceForNight;

        double otherMoney = budget * (othersPercent * 1.0 / 100);

        totalPrice = totalPrice + otherMoney;

        double restMoney = Math.abs(budget - totalPrice);
        if (totalPrice <= budget) {
            System.out.printf("Ivanovi will be left with %.2f leva after vacation.",restMoney);
        } else {
            System.out.printf("%.2f leva needed.",restMoney);
        }
    }
}
