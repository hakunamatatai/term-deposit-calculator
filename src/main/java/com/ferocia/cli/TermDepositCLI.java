package com.ferocia.cli;

import com.ferocia.Enum.InterestPaymentType;
import com.ferocia.model.TermDepositInput;
import com.ferocia.service.TermDepositCalculator;
import com.ferocia.validator.InputValidator;
import java.util.Scanner;

public class TermDepositCLI {


    public static void runApplication() {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Term Deposit Calculator ===");

        boolean keepRunning = true;
        while (keepRunning) {
            //read input
            double startDepositAmount = readPositiveDouble(sc, "Enter the start deposit amount (e.g. 10000): ");

            double rate = readPositiveDouble(sc, "Enter the annual interest rate (e.g. 1.1 for 1.1%): ") / 100.0;

            int years = readPositiveInt(sc, "Enter the investment term in years (e.g. 3): ");

            InterestPaymentType frequency = readInterestPaymentType(sc);


            TermDepositInput input = new TermDepositInput(startDepositAmount, rate, years, frequency);

            TermDepositCalculator calc = new TermDepositCalculator();
            double result = calc.calculateDepositBalance(input);

            System.out.printf("Final balance after %d years: $%.2f\n", years, result);
            keepRunning = checkIfContinue(sc);
        }

        System.out.println("Term Deposit Calculator End.");
    }


    private static double readPositiveDouble(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine();
            if (InputValidator.isValidPositiveDouble(input)) {
                return Double.parseDouble(input);
            }
            System.out.println("Please enter a valid positive number.");
        }
    }

    private static int readPositiveInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine();
            if (InputValidator.isValidPositiveInt(input)) {
                return Integer.parseInt(input);
            }
            System.out.println("Please enter a valid positive integer.");
        }
    }

    private static InterestPaymentType readInterestPaymentType(Scanner sc) {
        System.out.println("Choose interest payment frequency: ");
        System.out.println("1 - Monthly\n 2 - Quarterly\n 3 - Annually\n 4 - At Maturity");
        while (true) {
            System.out.print("Please input (1-4): ");
            String input = sc.nextLine().trim();
            switch (input) {
                case "1": return InterestPaymentType.MONTHLY;
                case "2": return InterestPaymentType.QUARTERLY;
                case "3": return InterestPaymentType.ANNUALLY;
                case "4": return InterestPaymentType.AT_MATURITY;
                default:
                    System.out.println("Please enter 1, 2, 3, or 4.");
            }
        }
    }


    private static boolean checkIfContinue(Scanner sc) {
        while (true) {
            System.out.print("Do you want to calculate another term deposit? (Y/N): ");
            String answer = sc.nextLine().trim().toUpperCase();
            if ("Y".equals(answer)) {
                return true;
            } else if ("N".equals(answer)) {
                return false;
            } else {
                System.out.println("Please enter Y (yes) or N (no).");
            }
        }
    }

}
