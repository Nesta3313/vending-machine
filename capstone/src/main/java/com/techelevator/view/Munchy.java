package com.techelevator.view;

import java.math.BigDecimal;

public class Munchy extends Snacks{

    public Munchy(String location, String item, String itemType, BigDecimal price) {
        super(location, item, itemType, price);
    }

    @Override
    public String toString() {
        return "Munchy, Munchy, so Good!";
    }
}
