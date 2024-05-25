package JavaAdvancedExam_17June2023.automotiveRepairShop;

import java.util.ArrayList;
import java.util.List;

public class RepairShop {

    private int capacity;
    private List<Vehicle> vehicles;

    public RepairShop(int capacity) {
        this.capacity = capacity;
        this.vehicles = new ArrayList<>();
    }

    private int getCapacity() {
        return capacity;
    }

    private int sizeOfVehicles() {
        return vehicles.size();
    }

    public void addVehicle(Vehicle vehicle) {

        if (sizeOfVehicles() < getCapacity()) {
            this.vehicles.add(vehicle);
        }

    }

    public boolean removeVehicle(String vin) {

        for (int i = 0; i < sizeOfVehicles(); i++) {
            Vehicle currentVehicle = this.vehicles.get(i);

            if (currentVehicle.getVIN().equals(vin)) {
                this.vehicles.remove(i);
                return true;
            }
        }

        return false;
    }

    public int getCount() {
        return sizeOfVehicles();
    }

    public Vehicle getLowestMileage() {

        int lowestMileage = Integer.MAX_VALUE;
        Vehicle lowestMileageVehicle = null;

        for (Vehicle vehicle : this.vehicles) {

            if (vehicle.getMileage() < lowestMileage) {
                lowestMileageVehicle = vehicle;
                lowestMileage = vehicle.getMileage();
            }
        }

        return lowestMileageVehicle;
    }

    public String report() {

        StringBuilder vehiclesSb = new StringBuilder();

        for (Vehicle vehicle : this.vehicles) {

            vehiclesSb.append(vehicle.toString()).append(System.lineSeparator());
        }

        return "Vehicles in the preparatory:\n"
                + vehiclesSb.toString();
    }

}
