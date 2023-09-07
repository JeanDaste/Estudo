package model;

public class Plot extends Financial {

    String area;

    public Plot(double propertyValue, int financialTerm, double annualRate, String area) {
        super(propertyValue, financialTerm, annualRate);
        this.area = area;
    }

    @Override
    public double monthlyPay() {
        return super.monthlyPay() * 1.02;
    }

    @Override
    public double totalPayment() {
        return super.totalPayment() * 1.02;
    }
}
