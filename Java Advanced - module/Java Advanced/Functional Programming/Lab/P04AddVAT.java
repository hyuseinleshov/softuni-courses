package Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class P04AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<String, Double> addVAT = price -> Double.parseDouble(price) * 1.2;

        List<Double> pricesWithVat = Arrays.stream(scanner.nextLine().split(", "))
                .map(addVAT)
                .collect(Collectors.toList());

        System.out.println("Prices with VAT:");

        pricesWithVat.stream().forEach(price -> System.out.printf("%.2f%n", price));
    }
}
