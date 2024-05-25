import java.util.Scanner;

public class P05_SuppliesForSchool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pensPackageCount = Integer.parseInt(scanner.nextLine());
        int highlitersPackageCount = Integer.parseInt(scanner.nextLine());
        int litresCount = Integer.parseInt(scanner.nextLine());
        int percentDiscount = Integer.parseInt(scanner.nextLine());

        double pens = pensPackageCount * 5.80;
        double highliters = highlitersPackageCount * 7.20;
        double cleaningAgent = litresCount * 1.20;

        double allPriceWithoutDiscount = pens + highliters + cleaningAgent;

        double discount = allPriceWithoutDiscount * (percentDiscount / 100.0);

        double finalPrice = allPriceWithoutDiscount - discount;

        System.out.println(finalPrice);
    }
}
