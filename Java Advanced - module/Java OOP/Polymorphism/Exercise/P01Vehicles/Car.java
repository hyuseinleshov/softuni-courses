package Exercise.P01Vehicles;

public class Car extends Vehicle {

    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + 0.9);
    }

    @Override
    public boolean drive(double km) {
        return super.drive(km);
    }

    @Override
    public void refuel(double litres) {
        super.refuel(litres);
    }

}
