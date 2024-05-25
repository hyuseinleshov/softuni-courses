package Exercise.P02VehiclesExtension;

public class Truck extends Vehicle {

    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption + 1.6, tankCapacity);
    }

    @Override
    public boolean drive(double km) {
        return super.drive(km);
    }

    @Override
    public void refuel(double litres) {

        super.refuel(litres * 0.95);
    }

}
