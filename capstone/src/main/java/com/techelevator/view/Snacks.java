package com.techelevator.view;

import java.math.BigDecimal;

public abstract class Snacks {

    private String location;
    private String item;
    private String itemType;
    private BigDecimal price;
    private int quantity;
    private BigDecimal quantitySold = BigDecimal.ZERO;

    public Snacks(String location, String item, String itemType, BigDecimal price) {
        this.location = location;
        this.item = item;
        this.itemType = itemType;
        this.price = price;
        this.quantity = 7;
    }

    public String getLocation() {
        return location;
    }

    public String getItem() {
        return item;
    }

    public String getItemType() {
        return itemType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getQuantitySold(){
        return quantitySold;
    }

    public void setQuantitySold(){
        this.quantitySold = this.quantitySold.add(BigDecimal.ONE);
    }

    public boolean purchaseItem(){
        if(getQuantity() > 0){
            this.quantity = getQuantity() - 1;
            setQuantitySold();
            System.out.println(getItem() + " Cost: $" + getPrice());
            return true;
        }
        else {
            System.out.println("NO LONGER AVAILABLE");
            return false;
        }
    }
}
