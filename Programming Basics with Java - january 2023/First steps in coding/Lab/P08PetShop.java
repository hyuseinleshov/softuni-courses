import java.util.Scanner;

public class P08PetShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dogFood = Integer.parseInt(scanner.nextLine());
        int catFood = Integer.parseInt(scanner.nextLine());
        double priceDogFood = dogFood * 2.50;
        int priceCatFood = catFood * 4;
        double allprice = priceCatFood + priceDogFood;
        System.out.printf("%.2f lv.",allprice);
    }
}
