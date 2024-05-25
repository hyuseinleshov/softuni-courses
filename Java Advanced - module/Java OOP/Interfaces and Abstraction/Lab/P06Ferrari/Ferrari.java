package Lab.P06Ferrari;

public class Ferrari implements Car {

    private String driverName;
    private final String model = "488-Spider";

    public Ferrari(String driverName) {
        this.driverName = driverName;
    }

    @Override
    public String brakes() {
        return "Brakes!";
    }

    @Override
    public String gas() {
        return "brum-brum-brum-brrrrr";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(model).append('/').append(brakes()).append('/');
        sb.append(gas()).append('/').append(driverName);

        return sb.toString();
    }

}
