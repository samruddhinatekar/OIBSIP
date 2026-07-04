import java.util.Scanner;

public class ATM {

    private Bank bank;
    private Scanner sc;

    public ATM() {
        bank = new Bank();
        sc = new Scanner(System.in);
    }

    public void login() {

        int attempts = 3;

        while (attempts > 0) {

            System.out.print("Enter User ID : ");
            String id = sc.nextLine();

            System.out.print("Enter PIN : ");
            String pin = sc.nextLine();

            if (id.equals(bank.getAccount().getUserId())
                    && pin.equals(bank.getAccount().getPin())) {

                System.out.println("\nLogin Successful");
                return;
            }

            attempts--;

            System.out.println("Invalid User ID or PIN");
            System.out.println("Attempts Left : " + attempts);
        }

        System.out.println("Account Locked");
        System.exit(0);

    }

    public void showMenu() {

        int choice;

        do {
            System.out.println("        ATM MENU        ");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Check balance");
            System.out.println("5. Transfer");
            System.out.println("6. Quit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    transactionHistory();
                    break;

                case 2:
                    withdraw();
                    break;

                case 3:
                    deposit();
                    break;

                case 4:
                    checkBalance();
                    break;

                case 5:
                    transfer();
                    break;

                case 6:
                    System.out.println("Thank You! Visit Again.");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 6);

    }

    public void deposit() {

        System.out.print("Enter Amount to Deposit: ");
        double amount = sc.nextDouble();

        double balance = bank.getAccount().getBalance();
        balance = balance + amount;

        bank.getAccount().setBalance(balance);
        bank.getHistory().add(new Transaction("Deposited ₹" + amount));

        System.out.println("₹" + amount + " Deposited Successfully.");
        System.out.println("Current Balance: ₹" + bank.getAccount().getBalance());

    }

    public void withdraw() {

        System.out.print("Enter Amount to Withdraw: ");
        double amount = sc.nextDouble();

        double balance = bank.getAccount().getBalance();

        if (amount > balance) {

            System.out.println("Insufficient Balance");

        } else {

            balance = balance - amount;

            bank.getAccount().setBalance(balance);
            bank.getHistory().add(new Transaction("Withdraw ₹" + amount));

            System.out.println("Please Collect Your Cash");
            System.out.println("Remaining Balance: ₹" + balance);

        }

    }

    public void checkBalance() {

        System.out.println("Current Balance : ₹"
                + bank.getAccount().getBalance());

    }

    public void transfer() {

        System.out.print("Enter Receiver Account ID: ");
        String receiver = sc.next();

        System.out.print("Enter Amount to Transfer: ");
        double amount = sc.nextDouble();

        double balance = bank.getAccount().getBalance();

        if (amount > balance) {

            System.out.println("Insufficient Balance");

        } else {

            balance = balance - amount;
            bank.getAccount().setBalance(balance);

            bank.getHistory().add(
                    new Transaction("Transferred ₹" + amount + " to " + receiver));

            System.out.println("Transfer Successful.");
            System.out.println("Remaining Balance: ₹" + balance);

        }

    }

    public void transactionHistory() {

        if (bank.getHistory().isEmpty()) {

            System.out.println("No Transactions Yet.");

        } else {

            System.out.println("\nTransaction History");

            for (Transaction t : bank.getHistory()) {

                System.out.println(t.getDetails());

            }

        }

    }
}