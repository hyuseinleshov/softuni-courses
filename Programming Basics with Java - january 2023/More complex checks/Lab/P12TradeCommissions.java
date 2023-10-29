package MoreComplexChecks_Lecture;

import java.util.Scanner;

public class P12TradeCommissions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String town = scanner.nextLine();
        double sales = Double.parseDouble(scanner.nextLine());

        double percentCommission = 0;
        boolean validTowns = town.equals("Sofia") || town.equals("Varna") || town.equals("Plovdiv");
        if (town.equals("Sofia")) {
            if (sales >= 0 && sales <= 500) {
                percentCommission = 5;
            } else if (sales > 500 && sales <= 1000) {
                percentCommission = 7;
            } else if (sales > 1000 && sales <= 10000) {
                percentCommission = 8;
            } else if (sales > 10000) {
                percentCommission = 12;
            }
        }
        if (town.equals("Varna")) {
            if (sales >= 0 && sales <= 500) {
                percentCommission = 4.5;
            } else if (sales > 500 && sales <= 1000) {
                percentCommission = 7.5;
            } else if (sales > 1000 && sales <= 10000) {
                percentCommission = 10;
            } else if (sales > 10000) {
                percentCommission = 13;
            }
        }
        if (town.equals("Plovdiv")) {
            if (sales >= 0 && sales <= 500) {
                percentCommission = 5.5;
            } else if (sales > 500 && sales <= 1000) {
                percentCommission = 8;
            } else if (sales > 1000 && sales <= 10000) {
                percentCommission = 12;
            } else if (sales > 10000) {
                percentCommission = 14.5;
            }
        } else if (!validTowns) {
            System.out.println("error");
        }
    if (sales < 0 && validTowns) {
            System.out.println("error");
        }
        double commissionPrice = (percentCommission / 100) * sales;
        if (sales > 0 && validTowns) {
            System.out.printf("%.2f", commissionPrice);
        }
    }
}
