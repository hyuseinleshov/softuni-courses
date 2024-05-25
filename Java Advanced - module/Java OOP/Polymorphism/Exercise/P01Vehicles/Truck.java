package Exercise.P01Vehicles;

public class Truck extends Vehicle {

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + 1.6);
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
