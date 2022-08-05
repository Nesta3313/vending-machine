package com.techelevator.view;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;

public class UserInput {
    private static final Scanner input = new Scanner(System.in);

    public static String getWelcomeScreen(){
        System.out.println();
        System.out.println("(D) Display CaTEring items");
        System.out.println("(P) Purchase");
        System.out.println("(E) Exit");

        System.out.println();
        System.out.print("Enter a letter from the menu options: ");
        String choice = input.nextLine();

        return choice.toLowerCase().trim().substring(0, 1);
    }

    public static String purchasingMenu(){
        System.out.println();
        System.out.println("(M) Feed Money");
        System.out.println("(S) Select Item");
        System.out.println("(F) Finish Transaction");

        System.out.println();
        System.out.print("Current Money Provided: $" + Wallet.getBalance());

        System.out.println();
        System.out.print("Enter a letter from the menu options: ");
        String choice = input.nextLine();

        return choice.toLowerCase().trim().substring(0, 1);
    }

    public static String feedMoney(){
        System.out.println();
        System.out.println("(a) $1 bill");
        System.out.println("(b) $5 bill");
        System.out.println("(c) $10 bill");
        System.out.println("(d) $20 bill");

        System.out.println();
        System.out.print("Enter a letter from the menu options: ");
        String choice = input.nextLine();
        return choice.toLowerCase().trim().substring(0, 1);
    }


    public static void displayItems(Map<String, Snacks> itemMap){
        System.out.println();
        for(String key : itemMap.keySet()){
            System.out.println("(" + itemMap.get(key).getLocation() + ") "+ itemMap.get(key).getItem() +" "+ itemMap.get(key).getPrice() + " Remaining quantity: " + itemMap.get(key).getQuantity() );
        }
    }

    public static String pickItem(){
        System.out.println();
        System.out.print("Please select item (example: A1 or B3): ");
        String choice = input.nextLine();
        return choice.toUpperCase().trim().substring(0, 2);
    }







}
