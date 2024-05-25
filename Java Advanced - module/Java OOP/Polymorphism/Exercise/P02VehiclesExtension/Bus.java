package Exercise.P02VehiclesExtension;

public class Bus extends Vehicle {

    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    public double getFuelQuantity() {
        return super.getFuelQuantity();
    }

    @Override
    public void setFuelQuantity(double fuelQuantity) {
        super.setFuelQuantity(fuelQuantity);
    }

    public boolean drive(double km, boolean isWithPeople) {

        if (isWithPeople == true) {
            setFuelConsumption(getFuelConsumption() + 1.4);
        }

        return super.drive(km);
    }

    @Override
    public void refuel(double litres) {
        super.refuel(litres);
    }

}
