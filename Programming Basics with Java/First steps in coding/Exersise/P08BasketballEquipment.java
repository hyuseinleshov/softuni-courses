import java.util.Scanner;

public class P08BasketballEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int yearTaxForBasketball = Integer.parseInt(scanner.nextLine());

        double sneakers = yearTaxForBasketball -(yearTaxForBasketball * 0.40);
        double suit = sneakers - (sneakers * 0.20);
        double ball = suit * 0.25;
        double accessories = ball * 0.20;

        double all = yearTaxForBasketball + sneakers + suit + ball + accessories;

        System.out.println(all);
    }
}
