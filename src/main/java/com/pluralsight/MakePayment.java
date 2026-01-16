package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MakePayment {

    public static void makePayment() {
        LocalDate today = LocalDate.now();
        LocalTime time = LocalTime.now();

        DateTimeFormatter dateFmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFmt = DateTimeFormatter.ofPattern("HH:mm:ss");

        try {
            String description = ConsoleHelper.promptForString("Please enter the description: ");
            String vendorName = ConsoleHelper.promptForString("Please enter vendor name: ");
            double amount = ConsoleHelper.promptForDouble("Please enter amount to be paid: ");

            // make sure amount is positive
            if (amount <= 0) {
                System.out.println("Amount must be greater than zero. Payment canceled.");
                return;
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("transactions.csv", true))) {
                writer.write(today + "|" + time + "|" + description + "|" + vendorName + "|" + amount);
                writer.newLine();
            }

            System.out.println("Payment successful!");

        } catch (Exception ex) {
            System.err.println("Invalid input. Payment not processed.");
        }

    }

}
