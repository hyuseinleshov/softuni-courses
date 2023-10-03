package Lab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P04CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] numbersArray = Arrays.stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();

        Map<Double, Integer> occurrencesMap = new LinkedHashMap<>();

        for (double number : numbersArray) {
            if (!occurrencesMap.containsKey(number)) {
                occurrencesMap.put(number, 1);
            } else {
                occurrencesMap.put(number, occurrencesMap.get(number) + 1);
            }
        }

        for (Double key : occurrencesMap.keySet()) {
            System.out.printf("%.1f -> %d%n", key, occurrencesMap.get(key));
        }
    }
}
