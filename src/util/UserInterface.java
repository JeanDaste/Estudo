package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {
    public static double propertyValue(Scanner sc) {
        System.out.print("Type it value of property: U$ ");
        double value;
        while (true) { //Maior propriedade já registrada em doláres foi de 500 milhões.
            try {
                value = sc.nextDouble();
                if (value >= 500000000) {
                    throw new RuntimeException("The value is higher than the estimated limit");
                } else if (value <= 0) {
                    throw new RuntimeException("The value has to be greater");
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("This is not a number valid");
                System.out.print("Type other value of property: ");
                sc.next();
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.out.print("Type other value of property: ");
            }
        }
        return value;
    }

    public static int financialTerm(Scanner sc) {
        System.out.print("Type estimated time of financing in monthly: ");
        int term;
        while (true) { // Maximo de meses que pode financiar uma casa como limite
            try {
                term = sc.nextInt();
                if (term <= 0) {
                    throw new RuntimeException("Value has to be greater\n");
                } else if (term >= 968) {
                    throw new RuntimeException("The value is too big\n");
                }
                break;

            } catch (InputMismatchException e) {
                System.out.println("This is not a number valid");
                System.out.print("Type other time of financing in monthly: ");
                sc.next();

            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.out.print("Type other time of financing in monthly: ");
            }
        }
        return term;
    }

    public static double annualRate(Scanner sc) {
        System.out.print("Type it annual interest rate: ");
        double rate;
        while (true) { // Maximo de juros já registrado no EUA foi de 40% ao ano, este é o limite
            try {
                rate = sc.nextDouble();
                if (rate <= 0) {
                    throw new RuntimeException("Value has to be greater\n");
                } else if (rate > 40) {
                    throw new RuntimeException("The value is too big\n");
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("This is not a number valid");
                System.out.print("Type it other annual interest rate: ");
                sc.next();

            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.out.print("Type it other annual interest rate:");
            }
        }
        return rate;
    }

    public static double discount(Scanner sc) {
        System.out.print("Type discount: ");
        double discount;
        while (true) { // Maximo de desconto pré-definido
            try {
                discount = sc.nextDouble();
                if (discount >= 100) {
                    throw new RuntimeException("The discount has overcome the limit\n");
                } else if (discount <= 0) {
                    throw new RuntimeException("The discount was below the minimum rate\n");
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("This is not a number valid");
                System.out.print("Type other discount: U$ ");
                sc.next();

            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.out.print("Type other discount: U$ ");
            }
        }
        return discount;
    }
}
