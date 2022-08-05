package com.techelevator.view;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class SalesReport {
    static LocalDateTime now = LocalDateTime.now();
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM_dd_y_h_m_s_a");
    static String path = formatter.format(now).toString() + ".csv";
    static File file = new File(path);

    public static void createFile(){

        if(!file.exists()){
            try{
                file.createNewFile();
            }catch(IOException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static void salesGenerator(Map<String, Snacks> currentInventory) {

        try(FileWriter writer = new FileWriter(file);
            PrintWriter printer = new PrintWriter(writer)){

            for(String key: currentInventory.keySet()){
                printer.println(currentInventory.get(key).getItem() + ", " + (currentInventory.get(key).getQuantitySold().toString()));
            }
            grossSales(currentInventory);
            System.out.println();
            printer.println("Total Sales =  " + grossSales(currentInventory).toString());

        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static BigDecimal grossSales(Map<String, Snacks> currentInventory){

        BigDecimal grossSale = BigDecimal.ZERO;

        for(String key : currentInventory.keySet()){
            BigDecimal quantitySold = currentInventory.get(key).getQuantitySold();
            BigDecimal price = currentInventory.get(key).getPrice();
            grossSale = grossSale.add(quantitySold.multiply(price));
        }
        return grossSale;

    }
}
