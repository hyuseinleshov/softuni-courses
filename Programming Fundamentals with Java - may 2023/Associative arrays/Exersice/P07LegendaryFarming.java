package Exersice;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P07LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Integer> materials = new LinkedHashMap<>();
        Map<String, Integer> junk = new LinkedHashMap<>();
        String legendaryItem = "";
        materials.put("shards", 0);
        materials.put("fragments", 0);
        materials.put("motes", 0);

        while (true) {
            boolean isValid = false;
            String[] commandsArray = input.split(" ");
            for (int i = 0; i < commandsArray.length; i += 2) {
                int quantity = Integer.parseInt(commandsArray[i]);
                String materialName = commandsArray[i + 1].toLowerCase();
                switch (materialName) {
                    case "shards":
                    case "fragments":
                    case "motes":
                        if (materials.containsKey(materialName)) {
                            materials.put(materialName, materials.get(materialName) + quantity);
                        } else {
                            materials.put(materialName, quantity);
                        }
                        break;
                    default:
                        if (junk.containsKey(materialName)) {
                            junk.put(materialName, junk.get(materialName) + quantity);
                        } else {
                            junk.put(materialName, quantity);
                        }
                        break;
                }
                if (!junk.containsKey(materialName)) {
                    if (materials.get(materialName) >= 250) {
                        materials.put(materialName, materials.get(materialName) - 250);
                        isValid = true;
                        if (materialName.equals("shards")) {
                            legendaryItem = "Shadowmourne";
                        } else if (materialName.equals("fragments")) {
                            legendaryItem = "Valanyr";
                        } else {
                            legendaryItem = "Dragonwrath";
                        }
                        break;
                    }
                }
            }
            if (isValid) {
                break;
            }
            input = scanner.nextLine();
        }
        System.out.println(legendaryItem + " obtained!");

        for (Map.Entry<String, Integer> entry : materials.entrySet()) {
            System.out.printf("shards: %d%n" +
                    "fragments: %d%n" +
                    "motes: %d%n", materials.get("shards"), materials.get("fragments"), materials.get("motes"));
            break;
        }

        for (Map.Entry<String, Integer> entry : junk.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }
    }
}
