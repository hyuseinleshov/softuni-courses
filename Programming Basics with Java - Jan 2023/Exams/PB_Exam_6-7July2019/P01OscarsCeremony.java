import java.util.Scanner;

public class P01OscarsCeremony {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rent = Integer.parseInt(scanner.nextLine());

        double priceForStatuettes = rent - (rent * 0.30);
        double priceForCatering = priceForStatuettes - (priceForStatuettes * 0.15);
        double priceForVoicing = priceForCatering / 2;
        double totalPrice = priceForStatuettes + priceForCatering + priceForVoicing + rent;

        System.out.printf("%.2f",totalPrice);
    }
}
