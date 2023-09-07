package model;

public class Apartment extends Financial {

    int parkingSpot;

    int floor;

    public Apartment(double propertyValue, int financialTerm, double annualRate, int parkingSpot, int floor) {
        super(propertyValue, financialTerm, annualRate);
        this.parkingSpot = parkingSpot;
        this.floor = floor;
    }

    @Override
    public double totalPayment() {
        double value = 0;
        for (int i = 1; i <= getFinancialTerm() ; i++){
            value += ((getAnnualRate() / i) / 100) * monthlyPay();
        }
        return super.totalPayment() + value;
    }
}
