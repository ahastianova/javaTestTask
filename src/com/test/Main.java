package com.test;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int result = 1;
        while (result != 0) {
            System.out.println("Launch first(1) or second (2) task?");
            result = in.nextInt();
            if (result ==1) {
                launchTaskOne();
            }

            if (result == 2) {
                launchTaskTwo();
            }

        }
    }

    public static void launchTaskOne() {
        User tester = new User(7, "Developer");
        System.out.println(tester.getId());
        System.out.println(tester.getVacancy());
    }

    public static void launchTaskTwo() {
        try {
            var priceGenerator = new PriceGenerator();
            priceGenerator.applyDiscountToPrices();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
