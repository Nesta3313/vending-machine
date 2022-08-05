package com.techelevator.view;

import java.math.BigDecimal;

public class Sandwich extends Snacks{

    public Sandwich(String location, String item, String itemType, BigDecimal price) {
        super(location, item, itemType, price);
    }

    @Override
    public String toString() {
        return "Sandwich So Delicious, Yum!";
    }
}
