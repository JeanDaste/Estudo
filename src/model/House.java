package model;

import util.UserInterface;

import java.util.InputMismatchException;
import java.util.Scanner;

public class House extends Financial {
    private double discount;

    private double constructedArea;

    private double sizePlot;

    public House(Scanner sc) {
        super(sc);
    }
    public House(double propertyValue, int financialTerm, double annualRate, double sizePlot, double constructedArea) {
        super(propertyValue, financialTerm, annualRate);
        this.sizePlot = sizePlot;
        this.constructedArea = constructedArea;

    }

    public House(double propertyValue, int financialTerm, double annualRate, double sizePlot, double constructedArea,
                 double discount, Scanner sc) {

        super(propertyValue, financialTerm, annualRate);
        this.sizePlot = sizePlot;
        this.constructedArea = constructedArea;
        this.discount = validateDiscount(discount, sc);
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

    private double validateDiscount(double discount, Scanner sc) {
        while (true) {
            try {
                if (discount > 100) {
                    throw new IllegalArgumentException("The discount has overcome the limit");
                } else if (discount <= 0) {
                    throw new IllegalArgumentException("The discount was below the minimum rate");
                } else if (discount > (getPropertyValue() / getFinancialTerm()) * (getAnnualRate() / 12)) {
                    throw new DiscountGreaterInterestException("The discount exceeds the interest value applied");
                }
                break;
            } catch (IllegalArgumentException | DiscountGreaterInterestException e) {
                System.out.println(e.getMessage());
                discount = UserInterface.discount(sc);
            } catch (InputMismatchException e) {
                System.out.println("This is not a number valid");
                discount = UserInterface.discount(sc);
            }
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