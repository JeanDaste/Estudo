package model;

import util.UserInterface;

import java.util.Scanner;

public abstract class Financial {
    private double propertyValue;

    private int financialTerm;

    private double annualRate;


    public Financial(Scanner sc) {
        this.propertyValue = UserInterface.propertyValue(sc);
        this.financialTerm = UserInterface.financialTerm(sc);
        this.annualRate = UserInterface.annualRate(sc);

    }
    public Financial(double propertyValue, int financialTerm, double annualRate) {
        if (propertyValue >= 500000000) {
            throw new RuntimeException("The value is higher than the estimated limit\nType it other value of property: U$ ");
        } else if (propertyValue <= 0) {
            throw new RuntimeException("The value has to be greater\nType it other value of property: U$ ");
        }
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

    public void setPropertyValue(double propertyValue) {
        this.propertyValue = propertyValue;
    }

    public void setFinancialTerm(int financialTerm) {
        this.financialTerm = financialTerm;
    }

    public void setAnnualRate(double annualRate) {
        this.annualRate = annualRate;
    }
}
