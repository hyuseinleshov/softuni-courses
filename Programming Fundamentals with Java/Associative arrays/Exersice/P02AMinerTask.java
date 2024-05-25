package Exersice;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P02AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Integer> counts = new LinkedHashMap<>();

        while (!input.equals("stop")) {
            String resource = input;
            int quantity = Integer.parseInt(scanner.nextLine());

            if (!counts.containsKey(resource)) {
                counts.put(resource, quantity);
            } else {
                counts.put(resource, counts.get(resource) + quantity);
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
