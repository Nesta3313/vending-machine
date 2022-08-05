package com.techelevator.view;

import java.math.BigDecimal;

public class Drink extends Snacks {

    public Drink(String location, String item, String itemType, BigDecimal price) {
        super(location, item, itemType, price);
    }

    @Override
    public String toString() {
        return "Drinky, Drinky, Slurp Slurp!";
    }

}
