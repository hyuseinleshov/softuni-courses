package P03BankAccount;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<Integer, BankAccount> bankAccounts = new HashMap<>();

        while (!input.equals("End")) {
            String[] tokens = input.split(" ");

            String command = tokens[0];

            switch (command) {
                case "Create":
                    rename(bankAccounts);
                    break;
                case "Deposit":
                    deposit(tokens, bankAccounts);
                    break;
                case "SetInterest":
                    setInterest(Double.parseDouble(tokens[1]));
                    break;
                case "GetInterest":
                    printInterest(bankAccounts, tokens);
                    break;
            }

            input = scanner.nextLine();
        }

    }

    private static void printInterest(Map<Integer, BankAccount> bankAccounts, String[] tokens) {
        int id = Integer.parseInt(tokens[1]);

        if (!checkAccountExist(bankAccounts, id)) {
            return;
        }

        BankAccount account = bankAccounts.get(id);
        int years = Integer.parseInt(tokens[2]);

        System.out.printf("%.2f%n", account.getInterest(years));
    }

    public static boolean checkAccountExist(Map<Integer, BankAccount> bankAccounts, int id) {

        if (!bankAccounts.containsKey(id)) {
            System.out.println("Account does not exist");
            return false;
        } else {

        }
        return true;
    }

    private static void setInterest(double interest) {
        BankAccount.setInterestRate(interest);
    }

    private static void rename(Map<Integer, BankAccount> bankAccounts) {
        BankAccount account = new BankAccount();
        bankAccounts.put(account.getId(), account);

        System.out.println("Account ID" + account.getId() + " created");
    }

    private static void deposit(String[] tokens, Map<Integer, BankAccount> bankAccounts) {
        int id = Integer.parseInt(tokens[1]);
        int amount = Integer.parseInt(tokens[2]);
        BankAccount bankAccount = bankAccounts.get(id);

        if (bankAccount != null) {
            bankAccount.deposit(amount);
            System.out.println("Deposited " + amount + " to ID" + id);
        } else {
            System.out.println("Account does not exist");
        }
    }

}
