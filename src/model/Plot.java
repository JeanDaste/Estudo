package model;
public class Plot extends Financial {
    public Plot(double propertyValue, int financialTerm, double annualRate) {
        super(propertyValue, financialTerm, annualRate);
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
