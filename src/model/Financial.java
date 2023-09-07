package model;
public abstract class Financial {
    private double propertyValue;

    private int financialTerm;

    private double annualRate;

    public Financial(double propertyValue, int financialTerm, double annualRate) {
        this.propertyValue = propertyValue;
        this.financialTerm = financialTerm;
        this.annualRate = annualRate;
    }

    public double monthlyPay() {
        return (propertyValue / financialTerm) * (1 + (annualRate / 12));
    }

    public double totalPayment() {
        return (propertyValue / financialTerm) * (1 + (annualRate / 12)) * financialTerm;
    }

    public double getPropertyValue() {
        return propertyValue;
    }

    public int getFinancialTerm() {
        return financialTerm;
    }

    public double getAnnualRate() {
        return annualRate;
    }
}
