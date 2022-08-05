package com.techelevator.view;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class WalletTest {

    @Before
    public void setup(){
        Wallet.clearBalance();
    }



    @Test
    public void addMoney_ShouldUpdateBalance_WhenWeAddMoney(){
        BigDecimal bill = BigDecimal.ONE;
        BigDecimal expected = BigDecimal.ONE;
        String message = "Should update balance when we add bill";

        Wallet.addMoney(bill);
        BigDecimal actual = Wallet.getBalance();

        assertEquals(message, expected, actual);

    }

    @Test
    public void removeMoney_ShouldUpdateBalance_WhenWePurchaseItemDrink(){
        Snacks drink = new Drink("A1", "Soda", "Drink", BigDecimal.valueOf(1.90));
        Wallet.addMoney(BigDecimal.TEN);
        BigDecimal expected = BigDecimal.valueOf(8.10);
        String message = "Should remove money from balance when item is purchased";

        Wallet.removeMoney(drink);
        BigDecimal actual = Wallet.getBalance();

        assertEquals(message, expected, actual);
    }

    @Test
    public void removeMoney_ShouldUpdateBalance_WhenWePurchaseItemMunchy(){
        Snacks munchy = new Munchy("A1", "Soda", "Munchy", BigDecimal.valueOf(1.90));
        Wallet.addMoney(BigDecimal.TEN);
        BigDecimal expected = BigDecimal.valueOf(8.10);
        String message = "Should remove money from balance when item is purchased";

        Wallet.removeMoney(munchy);
        BigDecimal actual = Wallet.getBalance();

        assertEquals(message, expected, actual);
    }

    @Test
    public void removeMoney_ShouldUpdateBalance_WhenWePurchaseItemSandwich(){
        Snacks sandwich = new Sandwich("A1", "Soda", "Sandwich", BigDecimal.valueOf(1.90));
        Wallet.addMoney(BigDecimal.TEN);
        BigDecimal expected = BigDecimal.valueOf(8.10);
        String message = "Should remove money from balance when item is purchased";

        Wallet.removeMoney(sandwich);
        BigDecimal actual = Wallet.getBalance();

        assertEquals(message, expected, actual);
    }

    @Test
    public void removeMoney_ShouldUpdateBalance_WhenWePurchaseItemDessert(){
        Snacks dessert = new Dessert("A1", "Soda", "Dessert", BigDecimal.valueOf(1.90));
        Wallet.addMoney(BigDecimal.TEN);
        BigDecimal expected = BigDecimal.valueOf(8.10);
        String message = "Should remove money from balance when item is purchased";

        Wallet.removeMoney(dessert);
        BigDecimal actual = Wallet.getBalance();

        assertEquals(message, expected, actual);
    }

    @Test
    public void clearBalance_ShouldClearBalanceToZero_WhenWeClearBalance(){
        Wallet.addMoney(BigDecimal.TEN);
        BigDecimal expected = BigDecimal.ZERO;
        String message = "Should clear balance when clear balance method is run";

        Wallet.clearBalance();
        BigDecimal actual = Wallet.getBalance();

        assertEquals(message, expected, actual);
    }

    @Test
    public void calculateClear_ShouldReturnProperChange_WhenWeClearBalance(){
        int[] expected = {3, 3, 2, 0};

        Wallet.addMoney(BigDecimal.valueOf(3.95));
        String message = "Cashback arrays should be equal";

        Wallet.clearBalance();
        int[] actual = Wallet.getChangeArray();

        assertEquals(message, expected[0], actual[0]);
        assertEquals(message, expected[1], actual[1]);
        assertEquals(message, expected[2], actual[2]);
        assertEquals(message, expected[3], actual[3]);
    }



}
