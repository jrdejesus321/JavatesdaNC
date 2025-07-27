import java.io.*;
import java.util.*;

class Transaction implements Serializable {
    String type;
    String details;
    double amount;
    double remainingBalance;

    public Transaction(String type, String details, double amount, double remainingBalance) {
        this.type = type;
        this.details = details;
        this.amount = amount;
        this.remainingBalance = remainingBalance;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s - PHP %.2f | Balance: PHP %.2f", type, details, amount, remainingBalance);
    }
}

class Account implements Serializable {
    String username;
    String pin;
    String race;
    double balance;
    List<Transaction> transactionHistory;

    public Account(String username, String pin, String race) {
        this.username = username;
        this.pin = pin;
        this.race = race;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    void showBalance() {
        System.out.printf("Your Current Balance: PHP %.2f\n", balance);
    }

    double getTransactionFeePercent() {
        return switch (race.toLowerCase()) {
            case "black" -> 0.15;
            case "arabs" -> 0.10;
            case "hispanic" -> 0.05;
            default -> 0.0;
        };
    }

    void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Amount must be positive.");
            return;
        }
        balance += amount;
        transactionHistory.add(new Transaction("Deposit", "Deposited to account", amount, balance));
        System.out.printf("✅ PHP %.2f deposited successfully.\n", amount);
        System.out.println("💬 Transaction complete. Thank you for banking with RACERBANK!");
    }

    void withdraw(double amount) {
        double feePercent = getTransactionFeePercent();
        double fee = amount * feePercent;
        double totalAmount = amount + fee;

        if (amount <= 0) {
            System.out.println("Amount must be positive.");
        } else if (totalAmount > balance) {
            System.out.println("⚠️ INSUFFICIENT FUNDS.");
        } else {
            balance -= totalAmount;
            transactionHistory.add(new Transaction("Withdraw", String.format("Withdrawn (Fee: %.0f%% = PHP %.2f)", feePercent * 100, fee), amount, balance));
            System.out.printf("✅ You withdrew PHP %.2f with a %.0f%% fee (PHP %.2f).\n", amount, feePercent * 100, fee);
            System.out.printf("💰 Remaining Balance: PHP %.2f\n", balance);
            System.out.println("💬 Transaction successful. Thank you for banking with RACERBANK!");
        }
    }

    boolean sendMoney(Account receiver, double amount) {
        double feePercent = getTransactionFeePercent();
        double fee = amount * feePercent;
        double totalAmount = amount + fee;

        if (amount <= 0) {
            System.out.println("Amount must be positive.");
            return false;
        } else if (totalAmount > balance) {
            System.out.println("⚠️ INSUFFICIENT FUNDS.");
            return false;
        } else {
            balance -= totalAmount;
            receiver.balance += amount;

            transactionHistory.add(new Transaction("Sent", String.format("To %s (Fee: %.0f%% = PHP %.2f)", receiver.username, feePercent * 100, fee), amount, balance));
            receiver.transactionHistory.add(new Transaction("Received", "From " + username, amount, receiver.balance));

            System.out.printf("✅ You sent PHP %.2f to %s.\n", amount, receiver.username);
            System.out.printf("📉 Deduction: %.0f%% fee = PHP %.2f\n", feePercent * 100, fee);
            System.out.printf("💰 Remaining Balance: PHP %.2f\n", balance);
            System.out.println("💬 Transaction successful. Thank you for using RACERBANK!");
            return true;
        }
    }

    void showTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transaction history available.");
        } else {
            System.out.println("---- 📜 Transaction History ----");
            for (Transaction t : transactionHistory) {
                System.out.println(t);
            }
        }
    }

    boolean authenticate(String pin) {
        return this.pin.equals(pin);
    }
}

public class bankingappDejesusRACERBANK  {

    static Scanner scanner = new Scanner(System.in);
    static HashMap<String, Account> accounts = new HashMap<>();
    static final String DATA_FILE = "accounts.dat";
    static Account currentAccount = null;

    public static void main(String[] args) {
        System.out.println("\n🏦 Welcome to RACERBANK!");
        System.out.println("💡 \"RACERBANK — We judge you by your balance, not your background.\"\n");

        loadAccountsFromFile();

        boolean isRunning = true;

        while (isRunning) {
            System.out.println("***************");
            System.out.println("1. Create Account");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> createAccount();
                case 2 -> login();
                case 3 -> {
                    isRunning = false;
                    saveAccountsToFile();
                    System.out.println("\nThank you for banking with RACERBANK. Stay safe!");
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    static void createAccount() {
        System.out.print("Enter a username: ");
        String username = scanner.nextLine();

        if (accounts.containsKey(username)) {
            System.out.println("⚠️ Username already exists!");
            return;
        }

        System.out.print("Enter a 6-digit PIN (numbers only): ");
        String pin = scanner.nextLine();
        if (!pin.matches("\\d{6}")) {
            System.out.println("❌ Invalid PIN. Must be exactly 6 digits.");
            return;
        }

        System.out.println("Select your race:");
        System.out.println("1. White");
        System.out.println("2. Black");
        System.out.println("3. Asian");
        System.out.println("4. Hispanic");
        System.out.println("5. Arabs");
        System.out.print("Choice (1-5): ");
        int raceChoice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        String race = switch (raceChoice) {
            case 1 -> "White";
            case 2 -> "Black";
            case 3 -> "Asian";
            case 4 -> "Hispanic";
            case 5 -> "Arabs";
            default -> {
                System.out.println("Invalid choice. Defaulting to White.");
                yield "White";
            }
        };

        accounts.put(username, new Account(username, pin, race));
        saveAccountsToFile();
        System.out.println("🎉 Account created successfully at RACERBANK!");
    }

    static void login() {
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        if (!accounts.containsKey(username)) {
            System.out.println("❌ Account not found.");
            return;
        }

        System.out.print("Enter your 6-digit PIN: ");
        String pin = scanner.nextLine();
        if (!pin.matches("\\d{6}")) {
            System.out.println("❌ Invalid PIN. Must be exactly 6 digits.");
            return;
        }

        Account acc = accounts.get(username);

        if (!acc.authenticate(pin)) {
            System.out.println("❌ Incorrect PIN.");
            return;
        }

        currentAccount = acc;
        System.out.println("🔓 Login successful. Welcome, " + username + "!");
        accountMenu();
    }

    static void accountMenu() {
        boolean loggedIn = true;

        while (loggedIn) {
            System.out.println("\n***************");
            System.out.println("1. Show Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Send Money");
            System.out.println("5. Transaction History");
            System.out.println("6. Logout");
            System.out.print("Enter your choice: ");
            int option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
                case 1 -> currentAccount.showBalance();
                case 2 -> {
                    System.out.print("Enter amount to deposit: ");
                    double amount = scanner.nextDouble();
                    currentAccount.deposit(amount);
                    saveAccountsToFile();
                }
                case 3 -> {
                    System.out.print("Enter amount to withdraw: ");
                    double amount = scanner.nextDouble();
                    currentAccount.withdraw(amount);
                    saveAccountsToFile();
                }
                case 4 -> {
                    System.out.print("Enter recipient's username: ");
                    String recipientName = scanner.nextLine();
                    if (!accounts.containsKey(recipientName)) {
                        System.out.println("❌ Recipient not found.");
                    } else if (recipientName.equals(currentAccount.username)) {
                        System.out.println("⚠️ You can't send money to yourself.");
                    } else {
                        System.out.print("Enter amount to send: ");
                        double amount = scanner.nextDouble();
                        currentAccount.sendMoney(accounts.get(recipientName), amount);
                        saveAccountsToFile();
                    }
                }
                case 5 -> currentAccount.showTransactionHistory();
                case 6 -> {
                    loggedIn = false;
                    currentAccount = null;
                    System.out.println("🔒 Logged out successfully.");
                }
                default -> System.out.println("Invalid option!");
            }
        }
    }

    static void saveAccountsToFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            out.writeObject(accounts);
        } catch (IOException e) {
            System.out.println("⚠️ Failed to save accounts.");
        }
    }

    @SuppressWarnings("unchecked")
    static void loadAccountsFromFile() {
        File file = new File(DATA_FILE);
        if (!file.exists()) return;

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            accounts = (HashMap<String, Account>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("⚠️ Failed to load accounts.");
        }
    }
}
