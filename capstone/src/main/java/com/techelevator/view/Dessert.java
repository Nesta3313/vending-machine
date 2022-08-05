package com.techelevator.view;

import java.math.BigDecimal;

public class Dessert extends Snacks{

    public Dessert(String location, String item, String itemType, BigDecimal price) {
        super(location, item, itemType, price);
    }

    @Override
    public String toString() {
        return "Sugar, Sugar, so Sweet!";
    }
}
