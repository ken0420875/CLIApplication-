package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DisplayDeposits {

    public static void displayDeposits() {

        System.out.println("\n======= DEPOSITS ONLY =======");
        System.out.printf("%-12s | %-10s | %-20s | %-20s | %10s\n",
                "Date", "Time", "Description", "Vendor", "Amount");
        System.out.println("------------------------------------------------------------------------");

        try (BufferedReader reader = new BufferedReader(new FileReader("transactions.csv"))) {

            String line;
            ArrayList<String> lines = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }

            for (int i = lines.size() - 1; i >= 0; i--) {
                String[] parts = lines.get(i).split("\\|");
                if (parts.length == 5) {
                    double amount = Double.parseDouble(parts[4]);
                    if (amount > 0) {
                        System.out.printf("%-12s | %-10s | %-20s | %-20s | %10.2f\n",
                                parts[0], parts[1], parts[2], parts[3], amount);
                    }
                }
            }

        } catch (IOException ex) {
            System.err.println("Error reading file: " + ex.getMessage());
        }

        ConsoleHelper.promptForString("Press enter to continue");

    }

}
