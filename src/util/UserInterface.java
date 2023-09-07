package util;

import java.util.Scanner;
public class UserInterface {
    public static double propertyValue(Scanner sc) {
        System.out.print("Type it value of property: U$ ");
        double value = sc.nextDouble();
        while (value <= 0 || value >= 50000000) { //Maior propriedade já registrada em doláres foi de 500 milhões.
            if (value >= 500000000) {
                System.out.print("The value is too big\nType it other value of property: U$ ");
            } else {
                System.out.print("Value has to be greater\nType it other value of property: U$ ");
            }
            value = sc.nextDouble();
        }
        return value;
    }

    public static int financialTerm(Scanner sc) {
        System.out.print("Type it estimated time of financing in monthly: ");
        int term = sc.nextInt();
        while (term <= 0 || term >= 967)  { //Maximo de meses que pode financiar uma casa como limite
            if (term <= 0){
                System.out.print("Value has to be greater\nType it other time of financing in monthly:");
            } else {
                System.out.print("The value is too big\nType it other time of financing in monthly:");
            }
            term = sc.nextInt();
        }
        return term;
    }

    public static double annualRate(Scanner sc) {
        System.out.print("Type it annual interest rate: ");
        double rate = sc.nextDouble();
        while (rate <= 0 || rate > 40) { //Maximo de juros já registrado no EUA foi de 40% ao ano, este é o limite
            if (rate <= 0) {
                System.out.print("Value has to be greater\nType it other annual interest rate: ");
            } else {
                System.out.print("The value is too big\nType it other annual interest rate: ");
            }
            rate = sc.nextDouble();
        }
        return rate;
    }

    public static double discount(Scanner sc) {
        System.out.print("Type discount: ");
        double discount = sc.nextDouble();
        while (discount <= 0 || discount > 100) {
            if (discount >= 100) {
                System.out.print("The discount has overcome the limit\nType it other discount: U$ ");
            } else {
                System.out.print("The discount was below the minimum rate\nType it other discount: U$ ");
            }
            discount = sc.nextDouble();
        }
        return discount;
    }
}
