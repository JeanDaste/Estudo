package model;

public class House extends Financial {
    private double discount;

    private double constructedArea;

    private double sizePlot;

    public House(double propertyValue, int financialTerm, double annualRate, double constructedArea, double sizePlot) {
        super(propertyValue, financialTerm, annualRate);
        this.constructedArea = constructedArea;
        this.sizePlot = sizePlot;
    }

    public House(double propertyValue, int financialTerm, double annualRate, double constructedArea,
                 double sizePlot, double discount) {
        super(propertyValue, financialTerm, annualRate);
        this.constructedArea = constructedArea;
        this.sizePlot = sizePlot;

        if (discount > 100) {
            System.out.println("The discount has overcome the limit, has been defined 100");
            this.discount = 100;
        } else if (discount <= 0) {
            System.out.println("The discount was below the minimum rate, it was modified to the minimum of 0.01");
            this.discount = 0.01;
        } else {
            this.discount = discount;
        }
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