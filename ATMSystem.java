import java.util.Scanner;

@SuppressWarnings("all")
public class ATMSystem {
    private double balance;
    private final String pin;

    public ATMSystem(String pin, double initialBalance) {
        this.pin = pin;
        this.balance = initialBalance;
    }

    public void displayMenu() {
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw Cash");
        System.out.println("3. Deposit Cash");
        System.out.println("4. Quit");
    }

    public void checkBalance() {
        System.out.println("Your balance is: $" + balance);
    }

    public void withdrawCash(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. Remaining balance: $" + balance);
        } else {
            System.out.println("Invalid amount or insufficient funds.");
        }
    }

    public void depositCash(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {


        // Initialize the ATM with a PIN and initial balance
        ATMSystem atm = new ATMSystem("1234", 1000.0);

        System.out.print("Enter your PIN: ");
        String enteredPin = scanner.nextLine();

        if (enteredPin.equals(atm.pin)) {
            int choice;
            do {
                atm.displayMenu();
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        atm.checkBalance();
                        break;
                    case 2:
                        System.out.print("Enter withdrawal amount: $");
                        double withdrawalAmount = scanner.nextDouble();
                        atm.withdrawCash(withdrawalAmount);
                        break;
                    case 3:
                        System.out.print("Enter deposit amount: $");
                        double depositAmount = scanner.nextDouble();
                        atm.depositCash(depositAmount);
                        break;
                    case 4:
                        System.out.println("Exiting. Thank you!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 4);
        } else {
            System.out.println("Invalid PIN. Exiting...");
        }

        scanner.close();
    }
}
}
