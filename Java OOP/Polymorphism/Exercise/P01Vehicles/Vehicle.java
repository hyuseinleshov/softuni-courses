package Exercise.P01Vehicles;

public class Vehicle implements Driving, Refueling {

    private double fuelQuantity;
    private double fuelConsumption;

    public Vehicle(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    @Override
    public boolean drive(double km) {

        double burntLitres = km * fuelConsumption;

        double fuel = fuelQuantity - burntLitres;

        if (fuel > 0) {
            fuelQuantity = fuel;
            return true;
        }

        return false;
    }

    @Override
    public void refuel(double litres) {

        fuelQuantity += litres;
    }

}
