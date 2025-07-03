import java.util.HashMap;

public class BankSystem {
    private HashMap<String, UserAccount> users = new HashMap<>();

    public BankSystem() {
        users.put("amit01", new UserAccount("amit01", "1234", 5000));
        users.put("john99", new UserAccount("john99", "5678", 3500));
        users.put("guest", new UserAccount("guest", "0000", 1000));
    }

    public UserAccount login(String userId, String pin) {
        UserAccount user = users.get(userId);
        if (user == null) return null;
        if (user.isLocked()) {
            System.out.println("[LOCKED] This account is locked due to failed attempts.");
            return null;
        }

        int attempts = 0;
        while (!user.authenticate(pin)) {
            attempts++;
            if (attempts == 3) {
                user.lock();
                System.out.println("[LOCKED] Account locked after 3 failed attempts.");
                return null;
            }
            System.out.print("[ERROR] Incorrect PIN. Try again: ");
            pin = new java.util.Scanner(System.in).nextLine();
        }

        return user;
    }
}
