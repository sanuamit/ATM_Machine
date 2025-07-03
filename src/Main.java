import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankSystem bank = new BankSystem();
        Scanner sc = new Scanner(System.in);

        System.out.println("[ATM] Welcome to the Java ATM Machine");
        System.out.print("Enter User ID: ");
        String userId = sc.nextLine();

        System.out.print("Enter PIN: ");
        String pin = sc.nextLine();

        UserAccount user = bank.login(userId, pin);

        if (user != null) {
            System.out.println("[SUCCESS] Login successful.");
            ATM atm = new ATM(user);
            atm.showMenu();
        } else {
            System.out.println("[FAIL] Login failed.");
        }
    }
}
