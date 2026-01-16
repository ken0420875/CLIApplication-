package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class AddDeposit {

    public static void addDeposit() {
        LocalDate today = LocalDate.now();
        LocalTime time = LocalTime.now();

        DateTimeFormatter dateFmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFmt = DateTimeFormatter.ofPattern("HH:mm:ss");

//user input
        String description =     ConsoleHelper.promptForString("Please Enter the description:");
        String vendorName =  ConsoleHelper.promptForString("Please enter Vendor name: ");
        double amount = ConsoleHelper.promptForDouble("Please enter amount to be paid: ");
        // used this multiple times

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter("transactions.csv", true))) {

            writer.write(
                    today.format(dateFmt) + "|" +
                            time.format(timeFmt) + "|" +
                            description + "|" +
                            vendorName + "|" +
                            amount + "\n"
            );

            System.out.println("Deposit has gone through ");

        } catch (IOException ex) {
            System.err.println("Error: " + ex.getMessage());
        }



    }

}
