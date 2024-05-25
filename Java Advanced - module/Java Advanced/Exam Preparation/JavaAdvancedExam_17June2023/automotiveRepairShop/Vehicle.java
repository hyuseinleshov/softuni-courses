package JavaAdvancedExam_17June2023.automotiveRepairShop;

public class Vehicle {

    private String VIN;
    private int mileage;
    private String damage;

    public Vehicle(String VIN, int mileage, String damage) {
        setVIN(VIN);
        setMileage(mileage);
        setDamage(damage);
    }

    public String getVIN() {
        return VIN;
    }

    public int getMileage() {
        return mileage;
    }

    public String getDamage() {
        return damage;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }

    @Override
    public String toString() {
        return String.format("Damage: %s, Vehicle: %s} (%d km)", getDamage(), getVIN(), getMileage());
    }

}
