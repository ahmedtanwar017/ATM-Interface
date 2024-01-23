import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            System.out.println("Insufficient funds");
            return false;
        }
    }
}

public class ATM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();

        BankAccount userAccount = new BankAccount(initialBalance);

        while (true) {
            displayOptions();
            System.out.print("Enter your choice (1-4): ");
            int choice = scanner.nextInt();

            if (choice == 4) {
                break;
            }

            System.out.print("Enter amount: ");
            double amount = scanner.nextDouble();

            performTransaction(userAccount, choice, amount);
        }

        scanner.close();
    }

    private static void displayOptions() {
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    private static void performTransaction(BankAccount account, int option, double amount) {
        switch (option) {
            case 1:
                if (account.withdraw(amount)) {
                    System.out.println("Withdrawal successful. Remaining balance: " + account.getBalance());
                } else {
                    System.out.println("Withdrawal failed.");
                }
                break;
            case 2:
                account.deposit(amount);
                System.out.println("Deposit successful. New balance: " + account.getBalance());
                break;
            case 3:
                System.out.println("Current balance: " + account.getBalance());
                break;
            default:
                System.out.println("Invalid option");
        }
    }
}