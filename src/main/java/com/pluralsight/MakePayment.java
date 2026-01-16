package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class MakePayment {

    public static void makePayment(Scanner scanner) {
        LocalDate today = LocalDate.now();
        LocalTime time = LocalTime.now();

        String description = ConsoleHelper.promptForString("Please enter the description");
        String vendorName = ConsoleHelper.promptForString("Please enter vendor name");
        double amount = ConsoleHelper.promptForDouble("Please enter amount to be paid");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("transactions.csv", true))) {
            writer.write(today + "|" + time + "|" + description + "|" + vendorName + "|" + -amount + "\n");
            System.out.println("Payment completed");
        } catch (IOException ex) {
            System.err.println("Error completing payment: " + ex.getMessage());
        }

        System.out.println("Payment successful!\n");

    }

}
