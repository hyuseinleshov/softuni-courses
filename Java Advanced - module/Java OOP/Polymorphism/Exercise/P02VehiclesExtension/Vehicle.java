package Exercise.P02VehiclesExtension;

public class Vehicle implements Driving, Refueling {

    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;

    public Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        setFuelQuantity(fuelQuantity);
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {

        if (fuelQuantity <= 0) {

            System.out.println("Fuel must be a positive number");
        } else {

            this.fuelQuantity = fuelQuantity;
        }

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

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public void refuel(double litres) {

        double fuel = fuelQuantity + litres;

        if (fuel > tankCapacity) {

            System.out.println("Cannot fit fuel in tank");
        } else if (litres <= 0) {

            System.out.println("Fuel must be a positive number");
        } else {
            setFuelQuantity(fuel);
        }
    }

}
