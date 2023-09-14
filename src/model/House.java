package model;

import java.util.InputMismatchException;
import java.util.Scanner;

public class House extends Financial {
    private double discount;

    private double constructedArea;

    private double sizePlot;

    public House(Scanner sc) {
        super(sc);
    }
    public House(double propertyValue, int financialTerm, double annualRate, double constructedArea,
                 double sizePlot) {

        super(propertyValue, financialTerm, annualRate);
        this.constructedArea = constructedArea;
        this.sizePlot = sizePlot;
    }

    public House(double propertyValue, int financialTerm, double annualRate, double constructedArea,
                 double sizePlot, double discount) throws DiscountGreaterInterestException {

        super(propertyValue, financialTerm, annualRate);
        this.constructedArea = constructedArea;
        this.sizePlot = sizePlot;
        this.discount = validateDiscount(discount);
    }


    @Override
    public double monthlyPay() {
        return super.monthlyPay() - getDiscount();
    }

    @Override
    public double totalPayment() {
        double payment = super.totalPayment() - (getFinancialTerm() * getDiscount());
        if (payment <= 0) {
            return 0.00;
        } else {
            return payment;
        }
    }

    public double validateDiscount(double discount) throws DiscountGreaterInterestException {
        try {
            if (discount > 100) {
                throw new IllegalArgumentException("The discount has overcome the limit, has been defined 100, " +
                        "it was modified to the minimum of 0.01");
            } else if (discount <= 0) {
                throw new IllegalArgumentException("The discount was below the minimum rate, it was modified to " +
                        "the minimum of 0.01");
            } else if (discount > (getPropertyValue() / getFinancialTerm()) * (getAnnualRate() / 12)) {
                throw new DiscountGreaterInterestException("The discount exceeds the interest value applied to the " +
                        "installments, defined for a minimum discount of 0.01 ");
            }
        } catch (IllegalArgumentException | DiscountGreaterInterestException e) {
            System.out.println(e.getMessage());
            return 0.01;
        } catch (InputMismatchException e) {
            System.out.println("This is not a number valid, it was modified to the minimum of 0.01");
            return 0.01;
        }
        return discount;
    }

    public double getDiscount() {
        return discount;
    }

    public double getConstructedArea() {
        return constructedArea;
    }

    public double getSizePlot() {
        return sizePlot;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setConstructedArea(double constructedArea) {
        this.constructedArea = constructedArea;
    }

    public void setSizePlot(double sizePlot) {
        this.sizePlot = sizePlot;
    }
}