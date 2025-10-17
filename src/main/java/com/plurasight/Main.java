package com.plurasight;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;

// 1.) FileReader + BufferedReader || 2.) Resolve Deposit error towards the end. ||
// 3.) Less string reliant when it comes to time and date. || 4.) Add payment menu
// 5.) Create an @Override file in TransactionApp.java, make it at the bottom and look at Matt's gitHub SearchInventory.
//Ledger menu - Report

class MainClass {


    public static void main(String[] args) throws IllegalStateException {
        Scanner scanner;
        scanner = new Scanner(System.in);
        boolean running = true;
        System.out.println("Good Afternoon");

            while (running) {
                System.out.println("      HOME SCREEN             ");
                System.out.println("  D) Add Deposit 💰");
                System.out.println("  P) Make Payment 💳");
                System.out.println("  L) Ledger 📊");
                System.out.println("  X) Exit 🚪");
                System.out.println("================================");
                System.out.print("Enter your choice: ");

                String choice = scanner.nextLine().toUpperCase();


            switch (choice) {
                case "D":
                    addDeposit(scanner);
                       break;
                case "P":
                    makePayment(scanner);
                      break;

                    case "L":
                    showLedger();
                      break;

                      case "X":
                     running = false;
                    System.out.println("See ya next time! ");
                       break;

                    default:
                    System.out.println("Invalid option. Select a valid option " + choice);

            }


        }

    }

    ///  Add deposit
    private static void addDeposit(Scanner scanner) {
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
        // used this multiple times

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("transactions.csv" , true))) {
            writer.write(today.format(fmt)+ "|" + time + "|" + description + "|" + vendorName + "|" + amount + "\n");
            System.out.println("Deposit has went through");
        } catch (IOException ex) {
            System.err.println("Error " + ex.getMessage());
        }



    }

    ////// Make Payment
    private static void makePayment(Scanner scanner) {
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

    /// // Ledger
    /// I removed Ledger and choice since the ledger page under my scanner was removed as well
    private static void displayAllEntries(){
        System.out.println("Displaying Entries");
    }
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
                    displayAllEntries();
                    break;
                    case "D":
                        displayDeposits();
                        break;
                        case "P":
                            displayPayments();
                            break;
                            case "R":
                                displayReports();
                                break;
                                case "H":
                                    inLedgerPage = false;
                                    break;
                }

            }

        }

    // Needed to identify Reports
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
        showLedger();
    }

    /// // Display Payments
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

    private static void displayDeposits() {
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
///  help needed pt.2
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
                /// IOException?
            } catch (IOException ex) {
                System.err.println("Error reading file: " + ex.getMessage());
            }

            System.out.println("\nPress Enter to continue...");
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();
        }


        }





