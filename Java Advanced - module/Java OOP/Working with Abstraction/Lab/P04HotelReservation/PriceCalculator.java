package Lab.P04HotelReservation;

public class PriceCalculator {

    private double pricePerDay;
    private int numberOfDays;
    private String season;
    private String discountType;

    public PriceCalculator(double pricePerDay, int numberOfDays, String season, String discountType) {
        this.pricePerDay = pricePerDay;
        this.numberOfDays = numberOfDays;
        this.season = season;
        this.discountType = discountType;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public double calculateTotalPrice() {

        double pricePerDay = getPricePerDay();

        if (getSeason().equals("Summer")) {

            pricePerDay *= 4;
        } else if (getSeason().equals("Spring")) {

            pricePerDay *= 2;
        } else if (getSeason().equals("Winter")) {

            pricePerDay *= 3;
        }

        double totalPrice = pricePerDay * getNumberOfDays();

        if (getDiscountType().equals("VIP")) {

            totalPrice *= 0.8;
        } else if (getDiscountType().equals("SecondVisit")) {

            totalPrice *= 0.9;
        }

        return totalPrice;

    }

    private enum DiscountType {

        VIP(1), SecondVisit(2), None(3);

        private int value;

        DiscountType(int value) {

            this.value = value;
        }
    }

    private enum Season {

        Autumn(1), Spring(2), Winter(3), Summer(4);

        private int value;

        Season(int value) {

            this.value = value;
        }

    }

}
