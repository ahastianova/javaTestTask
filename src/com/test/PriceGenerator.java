package com.test;

import java.util.Random;

public class PriceGenerator {

    Random rnd = new Random();
    int[] prices;
    int discount;
    int offset;
    int readLength;

    public PriceGenerator() throws InterruptedException {
        prices = generatePrices();
        discount = generateNumber();
        offset = generateNumber();
        readLength = generateNumber();
        System.out.println("Prices was generated: ");
        printPrices();
        System.out.println("");
        System.out.println("Discount was generated: " + discount);
        System.out.println("Offset was generated: " + offset);
        System.out.println("Read length was generated: " + readLength);

    }

    private int[] decryptData(int[] price, int discount, int offset, int readLength) throws IllegalArgumentException{

        if (price == null || price.length == 0) {
            throw new IllegalArgumentException("Массив цен не должен быть пустым");
        }
        if (discount < 1 || discount > 99 || offset < 0 || readLength < 1) {
            throw new IllegalArgumentException("Недопустимые параметры функции");
        }

        if (price.length < offset + readLength) {
            throw new IllegalArgumentException("Длина и отступ превышают длину массива");
        }
        int[] result = new int[readLength];
        for (int i = 0; i < readLength; i++) {
            result[i] = applyDiscount(price[offset + i], discount);
        }

        return result;

    }

    private int applyDiscount(int price, int discount) {
        return (int) Math.floor((double) price * (100 - discount)/ 100);
    }

    private int[] generatePrices() {
        int[] result = rnd.ints(10, 0, 100).toArray();
        return result;
    }

    private int generateNumber() {
        return rnd.nextInt(10);
    }

    private void printPrices() {
        for (int newPrice : prices) {
            System.out.printf("%d ", newPrice);
        }
        System.out.println("");
    }

    public void applyDiscountToPrices(int[] price, int discount, int offset, int readLength) throws IllegalArgumentException {
        this.prices = decryptData(price, discount, offset, readLength);
        System.out.println("Prices with applied discount:");
        printPrices();

    }

    public void applyDiscountToPrices() throws IllegalArgumentException{
        this.prices = decryptData(prices, discount, offset, readLength);
        System.out.println("Prices with applied discount:");
        printPrices();
    }
}
