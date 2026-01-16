package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MakePayment {

    public static void makePayment(Scanner scanner) {
        System.out.print(" Please fill in the Date (MM/DD/YYYY): ");
        String Sysdate = scanner.nextLine();
        /// Today's time^^^
        // different time slow
        //Want these to be inputted into csv
        System.out.println("Current time (0:00)");
        String Systimestamp = scanner.nextLine();

        System.out.println("Please Enter the description:");
        String description = scanner.nextLine();

        System.out.print("Please enter Vendor name: ");
        String vendorName = scanner.nextLine();

        System.out.print("Please enter amount to be paid: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        // double because of the number

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("transactions.csv", true))) {
            writer.write(Sysdate + "|" + Systimestamp + "|" + description + "|" + vendorName + "|" + -amount + "\n");
            System.out.println("Payment completed");
        } catch (IOException ex) {
            System.err.println("Error completing payment: " + ex.getMessage());
        }

        System.out.println("Payment successful!\n");

    }

}
