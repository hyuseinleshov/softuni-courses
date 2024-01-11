package Exercise.P05Restaurant.Beverages;

import java.math.BigDecimal;

public class Coffee extends HotBeverage {

    private final static double COFFEE_MILLILITERS = 50;
    private final static BigDecimal COFFEE_PRICE = new BigDecimal("3.5");
    private double caffeine;

    public Coffee(String name) {
        super(name, COFFEE_PRICE, COFFEE_MILLILITERS);
    }

    public double getCaffeine() {
        return caffeine;
    }

}
