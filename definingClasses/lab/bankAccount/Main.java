package definingClasses.lab.bankAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        List<BankAccount> bankAccounts = new ArrayList<>();

        while (!command.equals("End")) {
            BankAccount bankAccount = null;
            boolean doesExist = false;
            if (command.contains("Create")) {
               bankAccount = new BankAccount();
               bankAccounts.add(bankAccount);

            } else if (command.contains("Deposit")) {
                int id = Integer.parseInt(command.split("\\s+")[1]);
                double amount = Double.parseDouble(command.split("\\s+")[2]);

                if (doesAccountExist(id)) {
                    bankAccount = getCurrentBankAccount(bankAccounts, id);
                    bankAccount.deposit(amount);
                } else {
                    System.out.println("Account does not exist");
                }
            } else if (command.contains("SetInterest")) {
                BankAccount.setInterestRate(Double.parseDouble(command.split("\\s+")[1]));

            } else if (command.contains("GetInterest")) {
                int id = Integer.parseInt(command.split("\\s+")[1]);
                int years = Integer.parseInt(command.split("\\s+")[2]);

                if (doesAccountExist(id)) {
                    bankAccount = getCurrentBankAccount(bankAccounts, id);
                  double rate = bankAccount.getInterest(years);
                    System.out.printf("%.2f%n", rate);
                } else {
                    System.out.println("Account does not exist");
                }
            }

            command = scanner.nextLine();
        }
    }

    private static boolean doesAccountExist(int id) {
        return id <= BankAccount.getCount();
    }

    private static BankAccount getCurrentBankAccount(List<BankAccount> bankAccounts, int id) {
        return bankAccounts.stream().filter(acc -> acc.getId() == id).findFirst().get();
    }
}
