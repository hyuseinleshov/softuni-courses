import java.util.Scanner;

public class P07FoodDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int chickenMenu = Integer.parseInt(scanner.nextLine());
        int fishMenu = Integer.parseInt(scanner.nextLine());
        int vegatarianMenu= Integer.parseInt(scanner.nextLine());

        double chickenPrice = chickenMenu * 10.35;
        double fishPrice = fishMenu * 12.40;
        double vegatarianPrice = vegatarianMenu * 8.15;

        double bill = chickenPrice + fishPrice + vegatarianPrice;

        double desertAndDelivery = (bill * 0.20) + 2.50;

        System.out.println(bill + desertAndDelivery);
    }
}
