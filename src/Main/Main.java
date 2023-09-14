package Main;

import util.UserInterface;

import java.util.ArrayList;
import java.util.Scanner;

import model.*;

public class Main {

    public static void main(String[] args) throws Exception {

        ArrayList<Financial> financials = new ArrayList<>();
        double propertyValue = 0;
        double totalPayment = 0;
        int count = 1;


        Scanner sc = new Scanner(System.in);
        House user1 = new House(UserInterface.propertyValue(sc), UserInterface.financialTerm(sc),
                UserInterface.annualRate(sc), 100, 120, UserInterface.discount(sc));
        Thread.sleep(500);
        sc.close();

        House user2 = new House(100000, 160, 10, 100, 120);

        Apartment user3 = new Apartment(250000, 360, 10, 2, 16);

        Apartment user4 = new Apartment(250000, 360, 10, 1, 15);

        Plot user5 = new Plot(100000, 320, 10, "Residential");

        financials.add(user1);
        financials.add(user2);
        financials.add(user3);
        financials.add(user4);
        financials.add(user5);

        System.out.println();
        Thread.sleep(500);

        for (Financial f : financials) {
            System.out.println(f.getClass().getSimpleName() + " " + count);
            System.out.printf("The property %d value is: U$ %.2f\n", count, f.getPropertyValue());
            System.out.printf("The value of the financed property %d is: U$ %.2f\n\n", count, f.totalPayment());
            propertyValue += f.getPropertyValue();
            totalPayment += f.totalPayment();
            count++;
            Thread.sleep(500);
        }

        System.out.printf("The total value of the properties is: U$ %.2f\n", propertyValue);
        System.out.printf("The total value of the properties with financing is: U$ %.2f\n", totalPayment);
    }
}