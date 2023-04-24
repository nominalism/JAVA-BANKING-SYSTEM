import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankSystem {
    private Map<String, BankAccount> accounts;

    public BankSystem() {
        accounts = new HashMap<>();
    }

    public void createAccount(String accountNumber, String accountHolderName, double initialBalance) {
        if (!accounts.containsKey(accountNumber)) {
            BankAccount newAccount = new BankAccount(accountNumber, accountHolderName, initialBalance);
            accounts.put(accountNumber, newAccount);
            System.out.println("Account created successfully.");
        } else {
            System.out.println("Account already exists.");
        }
    }

    public void deposit(String accountNumber, double amount) {
        BankAccount account = accounts.get(accountNumber);
        if (account != null) {
            account.deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void withdraw(String accountNumber, double amount) {
        BankAccount account = accounts.get(accountNumber);
        if (account != null) {
            account.withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void checkBalance(String accountNumber) {
        BankAccount account = accounts.get(accountNumber);
        if (account != null) {
            System.out.println("Account holder: " + account.getAccountHolderName());
            System.out.println("Account number: " + account.getAccountNumber());
            System.out.println("Current balance: " + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankSystem bankSystem = new BankSystem();

        while (true) {
            System.out.println("1. Create account\n");
            System.out.println("2. Deposit\n");
            System.out.println("3. Withdraw\n");
            System.out.println("4. Check balance\n");
            System.out.println("5. Exit\n");
            System.out.println("Enter a number to select an option:");

            int option = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            switch (option) {
                case 1:
                    System.out.println("Enter account number:");
                    String accountNumber = scanner.nextLine();

                    System.out.println("Enter account holder name:");
                    String accountHolderName = scanner.nextLine();

                    System.out.println("Enter initial balance:");
                    double initialBalance = scanner.nextDouble();
                    scanner.nextLine(); // consume the newline character

                    bankSystem.createAccount(accountNumber, accountHolderName, initialBalance);
                    break;

                case 2:
                    System.out.println("Enter account number:");
                    accountNumber = scanner.nextLine();

                    System.out.println("Enter deposit amount:");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine(); // consume the newline character

                    bankSystem.deposit(accountNumber, depositAmount);
                    break;

                case 3:
                    System.out.println("Enter account number:");
                    accountNumber = scanner.nextLine();

                    System.out.println("Enter withdrawal amount:");
                    double withdrawalAmount = scanner.nextDouble();
                    scanner.nextLine(); // consume the newline character

                    bankSystem.withdraw(accountNumber, withdrawalAmount);
                    break;

                case 4:
                    System.out.println("Enter account number:");
                    accountNumber = scanner.nextLine();

                    bankSystem.checkBalance(accountNumber);
                    break;

                case 5:
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful. New balance: " + balance);
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        } else {
            System.out.println("Insufficient funds.");
        }
    }
}
