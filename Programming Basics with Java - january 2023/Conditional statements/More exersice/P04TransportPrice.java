package PBMoreE02ConditionalStatements;

import java.util.Scanner;

public class P04TransportPrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String dayOrNight = scanner.nextLine();

         double taxiStartTax = 0.70;
         double dayTariiff = 0.79;
         double nightTariff = 0.90;
         double day = taxiStartTax + (n * dayTariiff);
         double night = taxiStartTax + (n + nightTariff);

         double busTariff = 0.09;
         double busPrice = n * busTariff;
         //minimum 20 km

        double trainTariff = 0.06;
        double trainPrice = n * trainTariff;
        //minimum 100 km

        if (dayOrNight.equals(day)) {
            System.out.printf("%.2f",day);
        } else if (dayOrNight.equals(night)) {
            System.out.printf("%.2f",night);
        } else if (n > 20 && n < 100) {
            System.out.printf("%.2f",busPrice);
        } else if (n > 100) {
            System.out.printf("%.2f",trainPrice);
        }
    }
}
