package Exercises.P05CarSalesman;

public class Car {

    private String model;
    private Engine engine;
    private int weight;
    private String color;

    public Car(String model, Engine engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public Car(String model, Engine engine) {
        this(model, engine, -1, "n/a");
    }

    public Car(String model, Engine engine, int weight) {
        this(model, engine, weight, "n/a");
    }

    public Car(String model, Engine engine, String color) {
        this(model, engine, -1, color);
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.model).append(":").append(System.lineSeparator());
        sb.append(this.engine);
        sb.append("Weight: ").append((this.weight == -1) ? "n/a" : this.weight).append(System.lineSeparator());
        sb.append("Color: ").append(this.color).append(System.lineSeparator());
        return sb.toString().trim();
    }

}
