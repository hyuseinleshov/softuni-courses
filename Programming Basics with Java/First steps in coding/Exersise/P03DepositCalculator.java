import java.util.Scanner;

public class P03DepositCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // сума = депозирана сума + срок на депозита * ((депозирана сума * годишен лихвен процент ) / 12)

        double deposit = Double.parseDouble(scanner.nextLine());
        int depositTerm = Integer.parseInt(scanner.nextLine());
        double percentPerYear = Double.parseDouble(scanner.nextLine());

        double finalAmount = deposit + depositTerm * ((deposit * (percentPerYear / 100) / 12));

        System.out.println(finalAmount);
    }
}
