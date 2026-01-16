package com.pluralsight;

import java.util.Scanner;


// 1.) FileReader + BufferedReader || 2.) Resolve Deposit error towards the end. ||
// 3.) Less string reliant when it comes to time and date. || 4.) Add payment menu
// 5.) Create an @Override file in TransactionApp.java, make it at the bottom and look at Matt's gitHub SearchInventory.
//Ledger menu - Report

class Main {


    public static void main(String[] args) throws IllegalStateException {
        Scanner scanner;
        scanner = new Scanner(System.in);
        boolean running = true;

            while (running) {
                System.out.println(" ===========HOME SCREEN===========");
                System.out.println("  D) Add Deposit 💰");
                System.out.println("  P) Make Payment 💳");
                System.out.println("  L) Ledger 📊");
                System.out.println("  X) Exit 🚪");
                System.out.println("================================");
                System.out.print("Please Choose from D, P, L,X: ");

                String choice = scanner.nextLine().toUpperCase();
            switch (choice) {
                case "D":
                    AddDeposit.addDeposit(scanner);
                       break;
                case "P":
                    MakePayment.makePayment(scanner);
                      break;
                    case "L":
                    ShowLedger.showLedger();
                      break;
                      case "X":
                     running = false;
                    System.out.println("Exiting the application! ");
                       break;
                    default:
                    System.out.println("Invalid option. Select a valid option " + choice);
            }
        }
    }

}





