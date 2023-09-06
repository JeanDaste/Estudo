package model;

public class Apartment extends Financial {
    public Apartment(double propertyValue, int financialTerm, double annualRate) {
        super(propertyValue, financialTerm, annualRate);
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
