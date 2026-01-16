package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AddDeposit {

    public static void addDeposit(Scanner scanner) {
        LocalDate today = LocalDate.now();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        System.out.println("Current time (00:00)");
        String time = scanner.nextLine();

        String description =ConsoleHelper.promptForString("Please Enter the description:");
        String vendorName =ConsoleHelper.promptForString("Please enter Vendor name: ");
        double amountPaid = ConsoleHelper.promptForDouble("Please enter amount to be paid: ");
        // used this multiple times
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("transactions.csv" , true))) {
            writer.write(today.format(fmt)+ "|" + time + "|" + description + "|" + vendorName + "|" + amountPaid + "\n");
            System.out.println("Deposit has went through");
        } catch (IOException ex) {
            System.err.println("Error " + ex.getMessage());
        }

//        System.out.println();

    }

}
