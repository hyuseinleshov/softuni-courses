package Exersice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P01Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String regex = ">>(?<furnitureName>[A-Za-z]+)<<(?<price>[0-9]+\\.?[0-9]+)!(?<quantity>[0-9]+)";
        Pattern pattern = Pattern.compile(regex);

        List<String> furnituresList = new ArrayList<>();
        double totalSum = 0;

        while (!input.equals("Purchase")) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String furnitureName = matcher.group("furnitureName");
                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("quantity"));

                furnituresList.add(furnitureName);
                totalSum += (price * quantity);
            }

            input = scanner.nextLine();
        }

        System.out.println("Bought furniture:");

        for (int i = 0; i < furnituresList.size(); i++) {
            System.out.println(furnituresList.get(i));
        }

        System.out.printf("Total money spend: %.2f", totalSum);
    }
}
