import java.util.Scanner;

public class ATM {
    private UserAccount user;
    private Scanner sc = new Scanner(System.in);

    public ATM(UserAccount user) {
        this.user = user;
    }

    public void showMenu() {
        int choice;
        do {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. View Transaction History");
            System.out.println("5. Change PIN");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> System.out.println("[BALANCE] Rs. " + user.getBalance());
                case 2 -> {
                    System.out.print("Enter deposit amount: Rs. ");
                    double amount = sc.nextDouble();
                    user.deposit(amount);
                    System.out.println("[SUCCESS] Deposited Rs. " + amount);
                }
                case 3 -> {
                    System.out.print("Enter withdrawal amount: Rs. ");
                    double amount = sc.nextDouble();
                    if (user.withdraw(amount)) {
                        System.out.println("[SUCCESS] Withdrawn Rs. " + amount);
                    } else {
                        System.out.println("[ERROR] Insufficient balance.");
                    }
                }
                case 4 -> user.showTransactions();
                case 5 -> {
                    sc.nextLine(); // clear buffer
                    System.out.print("Enter new PIN: ");
                    String newPin = sc.nextLine();
                    user.changePin(newPin);
                }
                case 6 -> System.out.println("[EXIT] Thank you for using the ATM.");
                default -> System.out.println("[WARNING] Invalid choice. Try again.");
            }

        } while (choice != 6);
    }
}
