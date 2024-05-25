package Exercises.P04RawData;

class Tire {

    private double pressure;
    private int age;

    public Tire(double pressure, int age) {
        this.pressure = pressure;
        this.age = age;
    }
}

class Engine {

    private int engineSpeed;
    private int enginePower;

    public Engine(int engineSpeed, int enginePower) {
        this.engineSpeed = engineSpeed;
        this.enginePower = enginePower;
    }
}

class Cargo {

    private int cargoWeight;
    private String cargoType;

    public Cargo(int cargoWeight, String cargoType) {
        this.cargoWeight = cargoWeight;
        this.cargoType = cargoType;
    }
}

public class Car {

    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tire[] tires;

    public Car(String model, Engine engine, Cargo cargo, Tire[] tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;

        if (tires.length == 4) {
            this.tires = tires;
        } else {
            throw new IllegalArgumentException("A car must have exactly 4 tires!");
        }

    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Tire[] getTires() {
        return tires;
    }
}
