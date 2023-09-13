package model;

public class Apartment extends Financial {

    private int parkingSpot;

    private int floor;

    public Apartment(double propertyValue, int financialTerm, double annualRate, int parkingSpot, int floor) {
        super(propertyValue, financialTerm, annualRate);
        this.parkingSpot = parkingSpot;
        this.floor = floor;
    }

    @Override
    public double totalPayment() {
        double value = 0;
        for (int i = 1; i <= getFinancialTerm(); i++) {
            value += ((getAnnualRate() / i) / 100) * monthlyPay();
        }
        return super.totalPayment() + value;
    }


    public int getParkingSpot() {
        return parkingSpot;
    }

    public int getFloor() {
        return floor;
    }

    public void setParkingSpot(int parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }
}
