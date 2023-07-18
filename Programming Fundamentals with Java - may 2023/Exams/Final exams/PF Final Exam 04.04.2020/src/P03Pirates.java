import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P03Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Integer> citiesPopulation = new LinkedHashMap<>();
        Map<String, Integer> citiesGold = new LinkedHashMap<>();

        while (!input.equals("Sail")) {
            String cityData = input;
            String[] cityDataArray = cityData.split("\\|\\|");

            String cityName = cityDataArray[0];
            int population = Integer.parseInt(cityDataArray[1]);
            int gold = Integer.parseInt(cityDataArray[2]);

            if (citiesGold.containsKey(cityName) && citiesPopulation.containsKey(cityName)) {
                citiesGold.put(cityName, citiesGold.get(cityName) + gold);
                citiesPopulation.put(cityName, citiesPopulation.get(cityName) + population);
            } else {
                citiesGold.put(cityName, gold);
                citiesPopulation.put(cityName, population);
            }

            input = scanner.nextLine();
        }

        String input2 = scanner.nextLine();

        while (!input2.equals("End")) {
            String events = input2;
            String[] eventsArray = events.split("=>");

            String command = eventsArray[0];
            String town = eventsArray[1];

            if (command.equals("Plunder")) {
                int people = Integer.parseInt(eventsArray[2]);
                int gold = Integer.parseInt(eventsArray[3]);

                System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", town, gold, people);

                citiesGold.put(town, citiesGold.get(town) - gold);
                citiesPopulation.put(town, citiesPopulation.get(town) - people);

                if (citiesGold.get(town) <= 0 || citiesPopulation.get(town) <= 0) {
                    citiesGold.remove(town);
                    citiesPopulation.remove(town);
                    System.out.printf("%s has been wiped off the map!%n", town);
                }
            } else if (command.equals("Prosper")) {
                int gold = Integer.parseInt(eventsArray[2]);

                if (gold < 0) {
                    System.out.println("Gold added cannot be a negative number!");
                } else {
                    citiesGold.put(town, citiesGold.get(town) + gold);
                    System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", gold, town, citiesGold.get(town));
                }
            }

            input2 = scanner.nextLine();
        }
        if (citiesGold.size() == 0 && citiesPopulation.size() == 0) {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        } else {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", citiesGold.size());

            for (Map.Entry<String, Integer> entry : citiesGold.entrySet()) {
                System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n", entry.getKey(), citiesPopulation.get(entry.getKey()), entry.getValue());
            }
        }
    }
}
