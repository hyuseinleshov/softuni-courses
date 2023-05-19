import java.util.Scanner;

public class P01USDtoBGN {
    public static void main(String[] args) {

        //1. Прочетете входните данни от конзолата (щатските долари):
        //2. Създайте нова променлива, в която ще направите конвертирането от
        // щатски долари към български лева, като знаете валутния курс: 1 USD = 1.79549 BGN.
        //3. Принтирайте получените български лева.

        Scanner scanner = new Scanner(System.in);
        double usd = Double.parseDouble(scanner.nextLine());

        double bgn = usd * 1.79549;

        System.out.println(bgn);
    }
}
