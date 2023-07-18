import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P03HeroesOfCodeAndLogicVII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> heroesHitPoints = new LinkedHashMap<>();
        Map<String, Integer> heroesManaPoints = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] heroDataArray = scanner.nextLine().split(" ");

            String heroName = heroDataArray[0];
            int hitPoints = Integer.parseInt(heroDataArray[1]);
            int manaPoints = Integer.parseInt(heroDataArray[2]);

            heroesHitPoints.put(heroName, hitPoints);
            heroesManaPoints.put(heroName, manaPoints);
        }

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] commandsArray = input.split(" - ");

            String command = commandsArray[0];
            String heroName = commandsArray[1];

            if (command.equals("CastSpell")) {
                int mpNeeded = Integer.parseInt(commandsArray[2]);
                String spellName = commandsArray[3];

                if (heroesManaPoints.get(heroName) >= mpNeeded) {
                    heroesManaPoints.put(heroName, heroesManaPoints.get(heroName) - mpNeeded);
                    System.out.printf("%s has successfully cast %s and now has %d MP!%n", heroName, spellName, heroesManaPoints.get(heroName));
                } else {
                    System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spellName);
                }
            } else if (command.equals("TakeDamage")) {
                int damage = Integer.parseInt(commandsArray[2]);
                String attacker = commandsArray[3];

                heroesHitPoints.put(heroName, heroesHitPoints.get(heroName) - damage);

                if (heroesHitPoints.get(heroName) > 0) {
                    System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", heroName, damage, attacker, heroesHitPoints.get(heroName));
                } else {
                    heroesManaPoints.remove(heroName);
                    heroesHitPoints.remove(heroName);

                    System.out.printf("%s has been killed by %s!%n", heroName, attacker);
                }
            } else if (command.equals("Recharge")) {
                 int amount = Integer.parseInt(commandsArray[2]);

                 heroesManaPoints.put(heroName, heroesManaPoints.get(heroName) + amount);

                 if (heroesManaPoints.get(heroName) > 200) {
                     int neededToRemoveFromAmount = heroesManaPoints.get(heroName) - 200;
                     amount -= neededToRemoveFromAmount;
                     heroesManaPoints.put(heroName, 200);
                 }

                 System.out.printf("%s recharged for %d MP!%n", heroName, amount);
            } else if (command.equals("Heal")) {
                int amount = Integer.parseInt(commandsArray[2]);

                heroesHitPoints.put(heroName, heroesHitPoints.get(heroName) + amount);

                if (heroesHitPoints.get(heroName) > 100) {
                    int neededToRemoveFromAmount = heroesHitPoints.get(heroName) - 100;
                    amount -= neededToRemoveFromAmount;
                    heroesHitPoints.put(heroName, 100);
                }

                System.out.printf("%s healed for %d HP!%n", heroName, amount);
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, Integer> entry : heroesHitPoints.entrySet()) {
            System.out.println(entry.getKey());

            System.out.printf("  HP: %d%n", entry.getValue());
            System.out.printf("  MP: %d%n", heroesManaPoints.get(entry.getKey()));
        }
    }
}
