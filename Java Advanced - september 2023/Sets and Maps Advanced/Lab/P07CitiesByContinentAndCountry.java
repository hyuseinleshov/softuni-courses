package Lab;

import java.util.*;

public class P07CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, LinkedHashMap<String, List<String>>> towns = new LinkedHashMap<>();


        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(" ");

            String continent = tokens[0];
            String country = tokens[1];
            String city = tokens[2];

            if (!towns.containsKey(continent)) {
                towns.put(continent, new LinkedHashMap<>());
                towns.get(continent).put(country, new ArrayList<>());
                towns.get(continent).get(country).add(city);
            } else {
                if (towns.get(continent).containsKey(country)) {
                    towns.get(continent).get(country).add(city);
                } else {
                    towns.get(continent).put(country, new ArrayList<>());
                    towns.get(continent).get(country).add(city);
                }
            }
        }

        for (Map.Entry<String, LinkedHashMap<String, List<String>>> continent : towns.entrySet()) {
            System.out.println(continent.getKey() + ":");

            for (Map.Entry<String, List<String>> country : continent.getValue().entrySet()) {
                List<String> currentCountry = country.getValue();
                String splitedCountry = String.join(", ", currentCountry);

                System.out.printf("  %s -> %s%n", country.getKey(), splitedCountry);
            }
        }
    }
}
