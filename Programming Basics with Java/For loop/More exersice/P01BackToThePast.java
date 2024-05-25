package ForLoop_MoreExersises;

import java.util.Scanner;

public class P01BackToThePast {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double inheritance = Double.parseDouble(scanner.nextLine());
        int yearToLIve = Integer.parseInt(scanner.nextLine());

        int age = 17;
        int startYear = 1800;
        int n = yearToLIve - 1800;

        for (int i = 0; i <= n ; i++) {
            if (i % 2 == 0) {
                age++;
                inheritance-=12000;
            } else {
                age ++;
                inheritance = inheritance - (12000 + 50 * age);
            }
        }
        double neededMoney = Math.abs(inheritance);
        if (inheritance >= 0) {
            System.out.printf("Yes! He will live a carefree life and will have %.2f dollars left.",inheritance);
        } else {
            System.out.printf("He will need %.2f dollars to survive.",neededMoney);
        }
    }
}
