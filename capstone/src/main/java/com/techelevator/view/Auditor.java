package com.techelevator.view;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Auditor {
    static LocalDateTime now = LocalDateTime.now();
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/y h:m:s a");

     public static void addMoneyAudit(BigDecimal tempBalance) {

         String path = "audit/audit.txt";
         File file = new File(path);

         try (FileWriter fileWriter = new FileWriter(file , true);
              PrintWriter writer = new PrintWriter(fileWriter)
         ) {
             writer.println(formatter.format(now) + " MONEY FED:\t" + tempBalance.toString() + " " + Wallet.getBalance().toString());
         }
         catch(IOException e) {
         }
     }

    public static void purchaseAudit(String itemName, String itemLocation, BigDecimal tempBalance) {

        String path = "audit/audit.txt";
        File file = new File(path);

        try (FileWriter fileWriter = new FileWriter(file , true);
             PrintWriter writer = new PrintWriter(fileWriter)
        ) {
            writer.println(formatter.format(now) + " " + itemName + "\t" + itemLocation + " " + tempBalance.toString() + " " + Wallet.getBalance());
        }
        catch(IOException e) {
        }
    }

    public static void clearingAudit(BigDecimal tempBalance) {

        String path = "audit/audit.txt";
        File file = new File(path);

        try (FileWriter fileWriter = new FileWriter(file , true);
             PrintWriter writer = new PrintWriter(fileWriter)
        ) {
            LocalDateTime now = LocalDateTime.now();
            writer.println(formatter.format(now) + " "  + "CHANGE GIVEN:\t" + tempBalance.toString() + " " + Wallet.getBalance());
        }
        catch(IOException e) {
        }
    }
}
