package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

public class ConsoleHelper {
    private static Scanner scanner = new Scanner(System.in);
    public static int promptForInt(String prompt) {
        System.out.print(prompt + ": ");
        int result = scanner.nextInt();
        scanner.nextLine();
        return result;
    }
    public static double promptForDouble (String prompt){
        while (true) {
            try {
                System.out.print(prompt + ": ");
                String input = scanner.nextLine(); // Read input as a string
                return Double.parseDouble(input); // Convert String to double
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number");
            }
        }
    }

    public static String promptForString(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.nextLine();
    } //Prompts the user for a string input
    public static LocalDate promptForDate(String prompt){
        while(true){
            try {
                System.out.print(prompt +  ": ");
                String dateAsString = scanner.nextLine();
                return LocalDate.parse(dateAsString);
            }
            catch (Exception ex){
                System.out.println("Invalid Entry, please enter a valid date (YYYY-MM-DD)");
            }
        }
    }
    public static LocalTime promptForTime(String prompt){
        while(true){
            try {
                System.out.print(prompt + ": ");
                String timeAsString = scanner.nextLine();
                return LocalTime.parse(timeAsString);
            } catch (Exception ex) {
                System.out.println( "Invalid Entry, please enter a valid time ( HH:MM:SS)");
            }
        }
    }

    public static String promptForHelperMenu(String title, List<String> options, boolean allowCancel) { // Examples: title = "Choose your bread" | options = "List like [1,2,3] or [apple, banana, pears] | allowCancel = the cancel/return option.
        System.out.println("\n" + title); // Displays the title/question but creates a blank line before.
        for (int i = 0; i < options.size(); i++)
            System.out.printf("%d) %s\n", i + 1, options.get(i));// Prints each option (%d = menu number | %s = actual option | \n = new line) i+1 = index starts at 0 but +1 so string option 1 is ACTUALLY equal to 1 rather than 0.
        if (allowCancel){
            System.out.println("0) Cancel/Return");
        }

        while (true) { // While true = keeps asking till valid option is given.
            int choice = promptForInt("Enter your choice");
            if (allowCancel && choice == 0)
                return null; // Exits the method.
            if (choice >= 1 && choice <= options.size()) {
                return options.get(choice - 1); // Returns the actual chosen item (as a string) "choice - 1" so that choice and option list are matched. (choice -1 = 0 where options[0])
            }
            System.out.println("Invalid choice. Try again."); // Already exited the loop, therefore, no else statement needed.
        }
    }

}