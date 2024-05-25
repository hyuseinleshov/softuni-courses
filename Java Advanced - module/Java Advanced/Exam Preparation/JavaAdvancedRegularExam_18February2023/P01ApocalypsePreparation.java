package JavaAdvancedRegularExam_18February2023;

import java.util.*;

public class P01ApocalypsePreparation {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> textilesQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(textilesQueue::offer);

        ArrayDeque<Integer> medicamentsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(medicamentsStack::push);

        Map<String, Integer> items = new LinkedHashMap<>();
        items.put("Patch", 0);
        items.put("Bandage", 0);
        items.put("MedKit", 0);

        while (!textilesQueue.isEmpty() && !medicamentsStack.isEmpty()) {

            int currentTextile = textilesQueue.peek();
            int currentMedicament = medicamentsStack.peek();

            int sum = currentTextile + currentMedicament;

            boolean isEqual = false;

            switch (sum) {
                case 30:

                    int amount = items.get("Patch");

                    items.put("Patch", amount + 1);
                    isEqual = true;
                    break;
                case 40:

                    int amount2 = items.get("Bandage");

                    items.put("Bandage", amount2 + 1);
                    isEqual = true;
                    break;
                case 100:

                    int amount3 = items.get("MedKit");

                    items.put("MedKit", amount3 + 1);
                    isEqual = true;
                    break;
            }

            if (isEqual == true) {
                textilesQueue.poll();
                medicamentsStack.pop();
            } else if (sum > 100) {

                sum -= 100;

                int amount = items.get("MedKit");

                items.put("MedKit", amount + 1);

                textilesQueue.poll();
                medicamentsStack.pop();

                int item = medicamentsStack.pop();

                item += sum;

                medicamentsStack.push(item);
            } else {
                textilesQueue.poll();

                int item = medicamentsStack.pop();

                item += 10;

                medicamentsStack.push(item);
            }

        }

        if (textilesQueue.isEmpty() && medicamentsStack.isEmpty()) {
            System.out.println("Textiles and medicaments are both empty.");
        } else if (medicamentsStack.isEmpty()) {
            System.out.println("Medicaments are empty.");
        } else if (textilesQueue.isEmpty()) {
            System.out.println("Textiles are empty.");
        }

        if (!items.isEmpty()) {

            Map<String, Integer> sortedMap = items.entrySet()
                    .stream()
                    .filter(entry -> entry.getValue() != 0)
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                            .thenComparing(Map.Entry.comparingByKey()))
                    .collect(LinkedHashMap::new, (map, entry) -> map.put(entry.getKey(), entry.getValue()), LinkedHashMap::putAll);

            sortedMap.entrySet().forEach(item -> System.out.println(item.getKey() + " - " + item.getValue()));
        }

        if (!medicamentsStack.isEmpty()) {
            System.out.print("Medicaments left: ");

            StringJoiner joiner = new StringJoiner(", ");
            for (Integer number : medicamentsStack) {
                joiner.add(number.toString());
            }

            System.out.println(joiner);

        } else if (!textilesQueue.isEmpty()) {
            System.out.print("Textiles left: ");

            StringJoiner joiner = new StringJoiner(", ");
            for (Integer number : textilesQueue) {
                joiner.add(number.toString());
            }

            System.out.println(joiner);
        }

    }

}
