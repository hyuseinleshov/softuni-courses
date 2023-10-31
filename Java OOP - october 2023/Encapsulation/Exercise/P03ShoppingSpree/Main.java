package Exercise.P03ShoppingSpree;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] peopleArray = scanner.nextLine().split(";");
        String[] productsArray = scanner.nextLine().split(";");

        Map<String, Person> people = new LinkedHashMap<>();
        for (String person : peopleArray) {

            String[] personData = person.split("=");

            String name = personData[0];
            double money = Double.parseDouble(personData[1]);

            people.put(name, new Person(name, money));
        }

        Map<String, Product> products = new LinkedHashMap<>();
        for (String product : productsArray) {

            String[] productData = product.split("=");

            String name = productData[0];
            double cost = Double.parseDouble(productData[1]);

            products.put(name, new Product(name, cost));
        }

        String input = scanner.nextLine();

        while (!input.equals("END")) {

            String[] command = input.split("\\s+");

            String name = command[0];
            String product = command[1];

            Product productToBuy = products.get(product);

            people.get(name).buyProduct(productToBuy);


            input = scanner.nextLine();
        }

        for (Map.Entry<String, Person> personEntry : people.entrySet()) {

            Person person = personEntry.getValue();

            if (person.getProducts().isEmpty()) {

                System.out.printf("%s - Nothing bought", person.getName());
            } else {

                StringBuilder productsSb = new StringBuilder();

                List<Product> productsList = person.getProducts();

                for (int i = 0; i < productsList.size() - 1; i++) {
                    productsSb.append(productsList.get(i).getName()).append(", ");
                }

                productsSb.append(productsList.get(productsList.size() - 1).getName());

                System.out.printf("%s - %s%n", person.getName(), productsSb);
            }
        }

    }

}
