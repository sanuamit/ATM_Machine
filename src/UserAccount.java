import java.util.ArrayList;

public class UserAccount {
    private String userId;
    private String pin;
    private double balance;
    private boolean locked = false;
    private ArrayList<String> transactionHistory = new ArrayList<>();

    public UserAccount(String userId, String pin, double balance) {
        this.userId = userId;
        this.pin = pin;
        this.balance = balance;
    }

    public boolean authenticate(String inputPin) {
        return this.pin.equals(inputPin);
    }

    public void lock() {
        locked = true;
    }

    public boolean isLocked() {
        return locked;
    }

    public String getUserId() {
        return userId;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add("Deposited Rs. " + amount);
    }

    public boolean withdraw(double amount) {
        if (amount > balance) return false;
        balance -= amount;
        transactionHistory.add("Withdrew Rs. " + amount);
        return true;
    }

    public void showTransactions() {
        if (transactionHistory.isEmpty()) {
            System.out.println("[INFO] No transactions yet.");
            return;
        }
        System.out.println("[TRANSACTION HISTORY]:");
        for (String txn : transactionHistory) {
            System.out.println("- " + txn);
        }
    }

    public void changePin(String newPin) {
        this.pin = newPin;
        System.out.println("[SUCCESS] PIN changed successfully.");
    }
}
