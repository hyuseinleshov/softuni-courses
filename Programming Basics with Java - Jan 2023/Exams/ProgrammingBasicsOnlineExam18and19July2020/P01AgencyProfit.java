import java.util.Scanner;

public class P01AgencyProfit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String companyName = scanner.nextLine();
        int adultTickets = Integer.parseInt(scanner.nextLine());
        int kidTickets = Integer.parseInt(scanner.nextLine());
        double netWorthAdult = Double.parseDouble(scanner.nextLine());
        double tax = Double.parseDouble(scanner.nextLine());

        double netWorthKid = (netWorthAdult * 0.3) + tax;
        double adultWithTax = netWorthAdult + tax;
        double total = (kidTickets * netWorthKid) + (adultTickets * adultWithTax);
        double profit = total * 0.2;

        System.out.printf("The profit of your agency from %s tickets is %.2f lv.",companyName,profit);
    }
}
