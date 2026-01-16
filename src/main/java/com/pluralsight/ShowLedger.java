package com.pluralsight;

import java.util.Scanner;

public class ShowLedger {

    public static void showLedger() {
        Scanner scanner = new Scanner(System.in);
        boolean inLedgerPage = true;
        while (inLedgerPage) {
            System.out.println("\n-------Ledger Page ------- ");
            System.out.print("A) All Entries ");
            System.out.println("D)Deposits ");
            System.out.println("P) Payments ");
            System.out.println("R) Reports ");
            System.out.println("H) Home page ");
            System.out.print("Choose Your Choice: ");


            String choice = scanner.nextLine().toUpperCase();
            // Not needed
            switch (choice) {
                case "A":
                    System.out.println("Display all entries");
                    break;
                case "D":
                    DisplayDeposits.displayDeposits();
                    break;
                case "P":
                    DisplayPayments.displayPayments();
                    break;
                case "R":
                    DisplayReports.displayReports();
                    break;
                case "H":
                    inLedgerPage = false;
                    break;
            }

        }

    }

}
