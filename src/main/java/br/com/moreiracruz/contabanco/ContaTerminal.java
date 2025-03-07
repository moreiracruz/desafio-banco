package br.com.moreiracruz.contabanco;

import java.util.Scanner;

import br.com.moreiracruz.contabanco.service.ContaService;

public class ContaTerminal {

    public static void main(String[] args) {
        String customerName = null;
        String agency = null;
        Integer accountNumber = null;
        Double initialBalance = null;

        Scanner scanner = new Scanner(System.in);

        customerName = readInput(scanner, "Please enter the customer name: ");
        agency = readInput(scanner, "Please enter the agency: ");
        accountNumber = readIntegerInput(scanner, "Please enter the account: ");
        initialBalance = readDoubleInput(scanner, "Please enter the initial balance: ");

        scanner.close();

        ContaService contaService = new ContaService(customerName, agency, accountNumber, initialBalance);
        System.out.println(contaService.createWelcomeMessage());
    }

    private static String readInput(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Invalid value! Please try again!");
        }
    }

    private static Integer readIntegerInput(Scanner scanner, String prompt) {
        while (true) {
            try {
                return Integer.parseInt(readInput(scanner, prompt));
            } catch (NumberFormatException e) {
                System.out.println("Invalid value! Please try again!");
            }
        }
    }

    private static Double readDoubleInput(Scanner scanner, String prompt) {
        while (true) {
            try {
                return Double.parseDouble(readInput(scanner, prompt));
            } catch (NumberFormatException e) {
                System.out.println("Invalid value! Please try again!");
            }
        }
    }


}
