package Exercises.P06PokemonTrainer;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Trainer> trainers = new ArrayList<>();

        while (!input.equals("Tournament")) {

            String[] tokens = input.split("\\s+");

            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);

            boolean containsTrainer = false;

            for (Trainer trainer : trainers) {
                if (trainer.getName().equals(trainerName)) {
                    containsTrainer = true;
                    break;
                }
            }

            if (containsTrainer = true) {

            } else {
                Trainer trainer = new Trainer(trainerName);
            }

            trainers.add(trainer);

            input = scanner.nextLine();
        }

        String secondInput = scanner.nextLine();

        while (!secondInput.equals("End")) {

            String element = secondInput;

            secondInput = scanner.nextLine();
        }

    }

}
