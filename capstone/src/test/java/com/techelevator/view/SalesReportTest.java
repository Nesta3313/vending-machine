package com.techelevator.view;

import com.sun.source.tree.Tree;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.*;

public class SalesReportTest {


    @Test
    public void grossSales_Should_Return_TotalAmount(){
        Map<String, Snacks> salesMap = new TreeMap<>();
        Munchy munchy = new Munchy("A1", "Brownies", "Munchy", BigDecimal.valueOf(2.00));
        Drink drink = new Drink("B2", "Soda", "Drink", BigDecimal.valueOf(2.60));
        salesMap.put(munchy.getLocation(), munchy);
        salesMap.put(drink.getLocation(), drink);
        BigDecimal expected = BigDecimal.valueOf(4.60);

        String message = "Should return the correct sum of snacks sold multiplied by their price";

        munchy.purchaseItem();
        drink.purchaseItem();

        BigDecimal actual = SalesReport.grossSales(salesMap);

        assertEquals(message, expected, actual);





    }


}
