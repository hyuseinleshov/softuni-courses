package Exercise.P04PizzaCalories;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] pizzaData = scanner.nextLine().split("\\s+");

        String name = pizzaData[1];
        int numberOfToppings = Integer.parseInt(pizzaData[2]);

        Pizza pizza = new Pizza(name, numberOfToppings);

        String[] doughData = scanner.nextLine().split("\\s+");

        String flourType = doughData[1];
        String bakingTechnique = doughData[2];
        int doughWeight = Integer.parseInt(doughData[3]);

        Dough dough = new Dough(flourType, bakingTechnique, doughWeight);

        pizza.setDough(dough);

        String input = scanner.nextLine();

        while (!input.equals("END")) {

            String[] currentToppingData = input.split("\\s+");

            String toppingType = currentToppingData[1];
            int toppingWeight = Integer.parseInt(currentToppingData[2]);

            Topping topping = new Topping(toppingType, toppingWeight);

            pizza.addTopping(topping);

            input = scanner.nextLine();
        }

        System.out.println(pizza.getName() + " - " + pizza.getOverallCalories());

    }

}
