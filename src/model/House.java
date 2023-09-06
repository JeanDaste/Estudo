package model;

import java.util.Scanner;

public class House extends Financial {
    double discount;

    public House(double propertyValue, int financialTerm, double annualRate) {
        super(propertyValue, financialTerm, annualRate);
    }

    public House(double propertyValue, int financialTerm, double annualRate, double discount) {
        super(propertyValue, financialTerm, annualRate);
        this.discount = discount;
    }

    public static double discount(Scanner sc) {
        System.out.println("Type discount for a house: ");
        double discount = sc.nextDouble();
        while (discount <= 0 || discount > 100) {
            if (discount >= 100) {
                System.out.print("The value is too big\nType it other discount: U$ ");
            } else {
                System.out.print("Value has to be greater\nType it other discount: U$ ");
            }
            discount = sc.nextDouble();
        }
        return discount;
    }

    @Override
    public double monthlyPay() {
        return super.monthlyPay() - discount;
    }

    @Override
    public double totalPayment() {
        double payment = super.totalPayment() - (getFinancialTerm() * discount);
        if (payment <= 0) {
            return 0.00;
        }
        else {
            return payment;
        }
}
}