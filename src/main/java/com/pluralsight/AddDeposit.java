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

        System.out.println("Please Enter the description:");
        String description = scanner.nextLine();
        System.out.print("Please enter Vendor name: ");
        String vendorName = scanner.nextLine();
        System.out.print("Please enter amount to be paid: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        // double because of the number
        // used this multiple timess
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("transactions.csv" , true))) {
            writer.write(today.format(fmt)+ "|" + time + "|" + description + "|" + vendorName + "|" + amount + "\n");
            System.out.println("Deposit has went through");
        } catch (IOException ex) {
            System.err.println("Error " + ex.getMessage());
        }



    }

}
