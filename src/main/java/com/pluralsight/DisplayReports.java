package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class DisplayReports {
    public static void displayReports() {
        System.out.println("\n ---- Reports Page ----");


        double totalDeposits = 0.0;
        double totalPayments = 0.0;

        try (BufferedReader reader = new BufferedReader(new FileReader("transactions.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                String[] parts = line.split("\\|");
                if (parts.length < 5) continue;

                try {
                    double amount = Double.parseDouble(parts[4]);
                    if (amount > 0) {
                        totalDeposits += amount;
                    } else {
                        totalPayments += amount;
                    }
                } catch (NumberFormatException e) {

                }
            }
        } catch (IOException ex) {
            System.err.println("Error " + ex.getMessage());
            return;
        }

        double balance = totalDeposits + totalPayments;

        System.out.println("\n------ Summary ------");
        System.out.printf("%-20s: %10.2f%n", "Total Deposit Amount", totalDeposits);
        System.out.printf("%-20s: %10.2f%n", "Total Payments", totalPayments);
        System.out.printf("%-20s: %10.2f%n", "Current Amount", balance);

        System.out.println("\nPress Enter to return to the Ledger...");
        new Scanner(System.in).nextLine();
        ShowLedger.showLedger();
    }
}
