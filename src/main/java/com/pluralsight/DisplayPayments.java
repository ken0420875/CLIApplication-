package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DisplayPayments {

    public static void displayPayments() {
        System.out.println("\n--- Payments --- ");
        System.out.printf("%-12s | %-10s | %-20s | %-20s | %10s\n",
                "Date", "Time", "Description", "Vendor", "Amount");
        // something could go right here
        System.out.println("----------------");
        try (BufferedReader reader = new BufferedReader(new FileReader("transactions.csv"))) {
            String line;
            ArrayList<String> lines = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
    /// help needed
            for (int i = lines.size() - 1; i >= 0; i--) {
                String[] parts = lines.get(i).split("\\|");
                if (parts.length == 5) {
                    double amount = Double.parseDouble(parts[4]);
                    if (amount < 0) {
                        System.out.printf("%-12s | %-10s | %-20s | %-20s | %10.2f\n",
                                parts[0], parts[1], parts[2], parts[3], amount);
                    }
                }
            }
        } catch (IOException ex) {
            System.err.println("Error reading file: " + ex.getMessage());
        }

        System.out.println("\nPress Enter to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();



    }

}
