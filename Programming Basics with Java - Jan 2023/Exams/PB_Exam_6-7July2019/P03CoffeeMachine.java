import java.util.Scanner;

public class P03CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String drink = scanner.nextLine();
        String sugar = scanner.nextLine();
        int drinksCount = Integer.parseInt(scanner.nextLine());

        double totalSum = 0;

        switch (drink) {
            case "Espresso":
                if (sugar.equals("Without")) {
                    totalSum = drinksCount * 0.90;
                } else if (sugar.equals("Normal")) {
                    totalSum = drinksCount;
                } else if (sugar.equals("Extra")) {
                    totalSum = drinksCount * 1.20;
                }
                break;
            case "Cappuccino":
                if (sugar.equals("Without")) {
                    totalSum = drinksCount;
                } else if (sugar.equals("Normal")) {
                    totalSum = drinksCount * 1.20;
                } else if (sugar.equals("Extra")) {
                    totalSum = drinksCount * 1.60;
                }
                break;
            case "Tea":
                if (sugar.equals("Without")) {
                    totalSum = drinksCount * 0.50;
                } else if (sugar.equals("Normal")) {
                    totalSum = drinksCount * 0.60;
                } else if (sugar.equals("Extra")) {
                    totalSum = drinksCount * 0.70;
                }
                break;
        }
        if (sugar.equals("Without")) {
            totalSum = totalSum - (totalSum * 0.35);
        } if (drink.equals("Espresso") && drinksCount > 4) {
            totalSum = totalSum - (totalSum * 0.25);
        } if (totalSum > 15.00) {
            totalSum = totalSum - (totalSum * 0.20);
        }
        System.out.printf("You bought %d cups of %s for %.2f lv.",drinksCount,drink,totalSum);
    }
}
