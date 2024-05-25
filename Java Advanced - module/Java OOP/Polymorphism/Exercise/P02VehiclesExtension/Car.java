package Exercise.P02VehiclesExtension;

public class Car extends Vehicle {

    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption + 0.9, tankCapacity);
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
