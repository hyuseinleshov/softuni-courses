
package workingWithAbstraction.greedyTimes;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long input = Long.parseLong(scanner.nextLine());
        String[] items = scanner.nextLine().split("\\s+");

        Map<String, Map<String, Long>> bag = new LinkedHashMap<>();
        processItems(input, items, bag);
        printOutput(bag);
    }

    private static void processItems(long input, String[] items, Map<String, Map<String, Long>> bag) {
        for (int i = 0; i < items.length; i += 2) {
            String name = items[i];
            long count = Long.parseLong(items[i + 1]);
            String type = getType(name);

            if (type.isEmpty() || input < calculateSize(bag) + count || !isValidItem(type, count, bag)) {
                continue;
            }

            bag.putIfAbsent(type, new LinkedHashMap<>());
            bag.get(type).putIfAbsent(name, 0L);
            bag.get(type).put(name, bag.get(type).get(name) + count);
        }
    }

    private static String getType(String name) {
        if (name.length() == 3) {
            return "Cash";
        } else if (name.toLowerCase().endsWith("gem")) {
            return "Gem";
        } else if (name.equalsIgnoreCase("gold")) {
            return "Gold";
        }
        return "";
    }

    private static long calculateSize(Map<String, Map<String, Long>> bag) {
        return bag.values().stream()
                .flatMap(innerMap -> innerMap.values().stream())
                .mapToLong(Long::longValue)
                .sum();
    }

    private static boolean isValidItem(String type, long count, Map<String, Map<String, Long>> bag) {
        if (type.equals("Gold")) {
            return true;
        }
        if (type.equals("Gem")) {
            return bag.containsKey("Gold") && bag.get("Gold").values().stream().mapToLong(Long::longValue).sum() >= count;
        }
        if (type.equals("Cash")) {
            return bag.containsKey("Gem") && bag.get("Gem").values().stream().mapToLong(Long::longValue).sum() >= count;
        }
        return false;
    }

    private static void printOutput(Map<String, Map<String, Long>> bag) {
        for (var entry : bag.entrySet()) {
            long sumValues = entry.getValue().values().stream().mapToLong(Long::longValue).sum();
            System.out.printf("<%s> $%s%n", entry.getKey(), sumValues);
            entry.getValue().entrySet().stream()
                    .sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey()))
                    .forEach(item -> System.out.println("##" + item.getKey() + " - " + item.getValue()));
        }
    }

}
