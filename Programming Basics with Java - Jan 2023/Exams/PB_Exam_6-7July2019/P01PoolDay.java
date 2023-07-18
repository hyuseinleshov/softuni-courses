import java.util.Scanner;

public class P01PoolDay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int peopleCount = Integer.parseInt(scanner.nextLine());
        double entryTax = Double.parseDouble(scanner.nextLine());
        double priceForOneSunbed = Double.parseDouble(scanner.nextLine());
        double priceForOneUmbrella = Double.parseDouble(scanner.nextLine());

        double entryTaxEquals = peopleCount * entryTax;
        double people75 = Math.ceil(peopleCount * 0.75);
        double sunbed = people75 * priceForOneSunbed;
        double people50 = Math.ceil(peopleCount * 0.50);
        double umbrella = people50 * priceForOneUmbrella;
        double finalPrice = sunbed + umbrella + entryTaxEquals;

        System.out.printf("%.2f lv.",finalPrice);
    }
}
