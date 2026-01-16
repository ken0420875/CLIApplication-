package com.pluralsight;
import java.util.Arrays;
import java.util.List;

class Main {
    public static void main(String[] args) throws IllegalStateException {
        boolean running = true;
        while (running) {
            List<String> homeOptions = Arrays.asList(
                    "Add Deposit 💰",
                    "Make Payment 💳",
                    "Ledger 📊",
                    "Exit 🚪"
            );

            String choice = ConsoleHelper.promptForHelperMenu("===========HOME SCREEN===========",
                    homeOptions,
                    false  // No cancel option needed for main menu
            );

            if (choice == null) {
                continue;
            }

            switch (choice) {
                case "Add Deposit 💰":
                    AddDeposit.addDeposit();
                    break;
                case "Make Payment 💳":
                    MakePayment.makePayment();
                    break;
                case "Ledger 📊":
                    ShowLedger.showLedger();
                    break;
                case "Exit 🚪":
                    running = false;
                    System.out.println("Exiting the application!");
                    break;
                default:
                    System.out.println("Invalid option selected: " + choice);
            }
        }
    }
}
