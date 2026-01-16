package com.pluralsight;

import java.util.Scanner;

public class ShowLedger {

    public static void showLedger() {

        String ledgerScreen = """
                ===========Ledger screen=============
                 A) All
                 D) Deposits
                 P) Payments
                 R) Reports
                 H) Back to home screen               
                
                 
                """;

           while(true){
                System.out.println(ledgerScreen);
                String choice = ConsoleHelper.promptForString("Enter your choice").toUpperCase();

               switch (choice) {
                   case "A" -> System.out.println("Display all entries");
                   case "D" -> DisplayDeposits.displayDeposits();
                   case "P" -> DisplayPayments.displayPayments();
                   case "R" -> DisplayReports.displayReports();
                   case "H" -> {
                       System.out.println("Returning to home screen ...");
                       break;
                   }
                   default -> System.out.println("Invalid choice. Please try again.");

               }
               if (choice.equals("H")) {
                   break;
               }
        }

    }

}
