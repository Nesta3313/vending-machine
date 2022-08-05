package com.techelevator.view;

import java.math.BigDecimal;
import java.math.MathContext;

public class Wallet {

    private static BigDecimal balance = new BigDecimal(0);
    private static int[] changeArray = new int[4];

    public static BigDecimal getBalance() {
        return balance;
    }

    public static int[] getChangeArray(){
        return  changeArray;
    }

    public static void addMoney(BigDecimal tempAmount){
        balance = balance.add(tempAmount);
    }

    public static void removeMoney(Snacks object){
        balance = balance.subtract(object.getPrice());
    }

    public static void clearBalance(){

        calculateClear();

        balance = BigDecimal.ZERO;
    }

    public static void calculateClear() {
        MathContext precision = new MathContext(1);
        int oneDollarBills = balance.intValue();
        BigDecimal number = balance.multiply(BigDecimal.valueOf(100.00));
        BigDecimal remainder = number.remainder(BigDecimal.valueOf(100.00));
        int quarters = remainder.divide(BigDecimal.valueOf(25.00)).intValue();
        remainder = remainder.subtract(BigDecimal.valueOf(25.00).multiply(BigDecimal.valueOf(quarters))).round(precision);
        //FIXME fix precision for dimes
        int dimes = remainder.divide(BigDecimal.valueOf(10.00)).intValue();
        remainder = remainder.subtract(BigDecimal.valueOf(10.00).multiply(BigDecimal.valueOf(dimes)));
        int nickels = remainder.divide(BigDecimal.valueOf(5.00)).intValue();
        remainder = remainder.subtract(BigDecimal.valueOf(5.00).multiply(BigDecimal.valueOf(nickels)));

        changeArray[0] = oneDollarBills;
        changeArray[1] = quarters;
        changeArray[2] = dimes;
        changeArray[3] = nickels;

        System.out.println("Please take your change: \n" + oneDollarBills + " One dollar bills \n" + quarters + " Quarter(s) \n" + dimes + " Dime(s) and " + nickels + " Nickel(s)");

    }

}
