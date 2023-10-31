package Exercise.P04PizzaCalories;

import java.util.Map;

public class Dough {

    private static final Map<String, Double> DOUGH_MODIFIERS =
            Map.of(
                    "White", 1.5,
                    "Wholegrain", 1.0,
                    "Crispy", 0.9,
                    "Chewy", 1.1,
                    "Homemade", 1.0
            );

    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    private void setWeight(double weight) {

        if (weight < 1 || weight > 200) {

            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }

        this.weight = weight;
    }

    private void setFlourType(String flourType) {

        if (!DOUGH_MODIFIERS.containsKey(flourType)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }

        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {

        if (!DOUGH_MODIFIERS.containsKey(bakingTechnique)) {

            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    public double calculateCalories() {
        double flourTypeModifier = DOUGH_MODIFIERS.get(flourType);
        double bakingTechniqueModifier = DOUGH_MODIFIERS.get(bakingTechnique);

        return (2 * weight) * flourTypeModifier * bakingTechniqueModifier;
    }

}
