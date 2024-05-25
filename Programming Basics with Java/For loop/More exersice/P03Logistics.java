package ForLoop_MoreExersises;

import java.util.Scanner;

public class P03Logistics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int loadCount = Integer.parseInt(scanner.nextLine());

        int totalLoad = 0;
        double price = 0;
        double bus = 0;
        double truck = 0;
        double train = 0;
        for (int i = 1; i <= loadCount ; i++) {
            int tons = Integer.parseInt(scanner.nextLine());
            totalLoad = totalLoad + tons;
            if (tons <= 3) {
                price = price + (tons * 200);
                bus = bus + tons;
            } else if (tons <= 11) {
                price = price + (tons * 175);
                truck = truck + tons;
            } else if (tons > 11) {
                price = price + (tons * 120);
                train = train + tons;
            }
        }
        double averagePrice = price / totalLoad;
        double busPercent = bus / totalLoad * 100;
        double truckPercent = truck  / totalLoad * 100;
        double trainPercent = train  / totalLoad * 100;

        System.out.printf("%.2f%n",averagePrice);
        System.out.printf("%.2f%%%n%.2f%%%n%.2f%%%n",busPercent,truckPercent,trainPercent);
    }
}
