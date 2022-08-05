package com.techelevator.view;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.*;

public class SnacksTest {

    @Test
    public void purchaseItem_ShouldDecreaseQuantity_When_ItemIsPurchased(){
        Map<String, Snacks> salesMap = new TreeMap<>();
        Munchy munchy = new Munchy("A1", "Brownies", "Munchy", BigDecimal.valueOf(2.00));
        salesMap.put(munchy.getLocation(), munchy);
        String message = "Should decrease quantity of item when item is purchased";
        int expected = 6;

        munchy.purchaseItem();

        int actual = munchy.getQuantity();

        assertEquals(message, expected, actual);
    }

    @Test
    public void purchaseItem_ShouldIncreaseQuantitySold_When_ItemIsPurchased(){
        Map<String, Snacks> salesMap = new TreeMap<>();
        Munchy munchy = new Munchy("A1", "Brownies", "Munchy", BigDecimal.valueOf(2.00));
        salesMap.put(munchy.getLocation(), munchy);
        String message = "Should increase quantity of item sold when item is purchased";
        BigDecimal expected = BigDecimal.ONE;

        munchy.purchaseItem();

        BigDecimal actual = munchy.getQuantitySold();

        assertEquals(message, expected, actual);
    }

}
