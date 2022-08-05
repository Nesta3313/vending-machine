package com.techelevator.view;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class FileReader {

    private static Scanner input = new Scanner(System.in);
    static Map<String, Snacks> itemMap = new TreeMap<>();

    public Map<String, Snacks> displayItems(){

        File file = new File("catering.csv");

        try(Scanner streamText = new Scanner(file)){

            while(streamText.hasNextLine()){

                String nextLine = streamText.nextLine();
                String[] itemArray = nextLine.split(",");
                String location = itemArray[0];
                String item = itemArray[1];
                String itemType = itemArray[2];
                BigDecimal price = new BigDecimal(itemArray[3]);

                if(itemType.equals("Munchy")){
                    itemMap.put(location, new Munchy(location, item, itemType, price));
                }else if(itemType.equals("Drink")){
                    itemMap.put(location, new Drink(location, item, itemType, price));
                }else if(itemType.equals("Dessert")){
                    itemMap.put(location, new Dessert(location, item, itemType, price));
                }else if(itemType.equals("Sandwich")){
                    itemMap.put(location, new Sandwich(location, item, itemType, price));
                }
            }

        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        return itemMap;
    }

}
