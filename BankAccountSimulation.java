import java.util.ArrayList;
import java.util.Scanner;

class BankAccount {

    private String accountHolder;
    private double balance;
    private ArrayList<String> transactionHistory;

    // Constructor
    public BankAccount(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();

        transactionHistory.add(
                "Account created with balance: Rs. " + initialBalance
        );
    }

    // Deposit money
    public void deposit(double amount) {

        if (amount <= 0) {
            System.out.println("Deposit amount must be greater than zero.");
            return;
        }

        balance += amount;

        transactionHistory.add("Deposited: Rs. " + amount);
        System.out.println("Rs. " + amount + " deposited successfully.");
    }

    // Withdraw money
    public void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Withdrawal amount must be greater than zero.");
            return;
        }

        // Prevent withdrawal greater than available balance
        if (amount > balance) {
            System.out.println("Insufficient balance.");
            transactionHistory.add(
                    "Failed withdrawal attempt: Rs. " + amount
            );
            return;
        }

        balance -= amount;

        transactionHistory.add("Withdrawn: Rs. " + amount);
        System.out.println("Rs. " + amount + " withdrawn successfully.");
    }

    // Check current balance
    public void checkBalance() {
        System.out.printf("Current Balance: Rs. %.2f%n", balance);
    }

    // Display transaction history
    public void showTransactionHistory() {

        System.out.println("\n===== TRANSACTION HISTORY =====");

        for (String transaction : transactionHistory) {
            System.out.println("- " + transaction);
        }

        System.out.println("===============================");
    }

    // Display account details
    public void displayAccountDetails() {

        System.out.println("\n===== ACCOUNT DETAILS =====");
        System.out.println("Account Holder: " + accountHolder);
        System.out.printf("Balance: Rs. %.2f%n", balance);
        System.out.println("===========================");
    }
}

public class BankAccountSimulation {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== BANK ACCOUNT SIMULATION =====");

        System.out.print("Enter account holder name: ");
        String name = sc.nextLine();

        System.out.print("Enter initial balance: ");
        double initialBalance = sc.nextDouble();

        // Validate initial balance
        while (initialBalance < 0) {
            System.out.println("Balance cannot be negative.");
            System.out.print("Enter initial balance again: ");
            initialBalance = sc.nextDouble();
        }

        BankAccount account =
                new BankAccount(name, initialBalance);

        int choice;

        do {
            System.out.println("\n===== BANK MENU =====");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Account Details");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = sc.nextDouble();
                    account.withdraw(withdrawalAmount);
                    break;

                case 3:
                    account.checkBalance();
                    break;

                case 4:
                    account.displayAccountDetails();
                    break;

                case 5:
                    account.showTransactionHistory();
                    break;

                case 6:
                    System.out.println(
                            "Thank you for using the Bank Account Simulation."
                    );
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 6);

        sc.close();
    }
}
