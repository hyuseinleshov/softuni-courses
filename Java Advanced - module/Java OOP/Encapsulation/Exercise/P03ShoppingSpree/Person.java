package Exercise.P03ShoppingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setName(String name) {

        if (name.isBlank()) {

            throw new IllegalArgumentException("Name cannot be empty");
        }

        this.name = name;
    }

    private void setMoney(double money) {

        if (money < 0) {

            throw new IllegalArgumentException("Money cannot be negative");
        }

        this.money = money;
    }

    public void buyProduct(Product product) {

        if (money >= product.getCost()) {

            products.add(product);

            setMoney(money - product.getCost());
            System.out.printf("%s bought %s%n", name, product.getName());
        } else {

            System.out.printf("%s can't afford %s", name, product.getName());
        }

    }

    public String getName() {
        return name;
    }

    public List<Product> getProducts() {
        return products;
    }

}
