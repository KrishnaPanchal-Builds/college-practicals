class InsufficientFundsException extends Exception {
    private double requestedAmount;
    private double currentBalance;

    public InsufficientFundsException(String message, double requestedAmount, double currentBalance) {
        super(message);
        this.requestedAmount = requestedAmount;
        this.currentBalance = currentBalance;
    }

    public double getDeficit() {
        return requestedAmount - currentBalance;
    }

    public double getRequestedAmount() {
        return requestedAmount;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }
}

class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = Math.max(0.0, initialBalance);
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount! Amount must be positive.");
            return;
        }
        balance += amount;
        System.out.printf("Deposited: Rs. %.2f | Updated Balance: Rs. %.2f%n", amount, balance);
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        System.out.printf("Attempting to withdraw: Rs. %.2f...%n", amount);

        if (amount <= 0) {
            System.out.println("Invalid transaction: Withdrawal amount must be greater than 0.");
            return;
        }

        if (amount > balance) {
            throw new InsufficientFundsException(
                "Transaction Declined: Insufficient balance in account.",
                amount,
                balance
            );
        }

        balance -= amount;
        System.out.printf("Withdrawal Successful: Rs. %.2f deducted. Remaining Balance: Rs. %.2f%n", amount, balance);
    }

    public void displaySummary() {
        System.out.println("----------------------------------------");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder : " + accountHolder);
        System.out.printf("Current Balance: Rs. %.2f%n", balance);
        System.out.println("----------------------------------------");
    }
}

class ExceptionHandlingDemo {
    public static void main(String[] args) {
        System.out.println("--- Bank Account Transaction System (Exception Handling) ---\n");

        BankAccount account = new BankAccount("SBIN-00984512", "Pankaj Sharma", 15000.00);
        account.displaySummary();

        System.out.println("1. Performing Deposit:");
        account.deposit(5000.00);
        System.out.println();

        System.out.println("2. Performing Valid Withdrawal:");
        try {
            account.withdraw(8000.00);
        } catch (InsufficientFundsException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
        System.out.println();

        System.out.println("3. Attempting Invalid Withdrawal Exceeding Balance:");
        try {
            account.withdraw(20000.00);
        } catch (InsufficientFundsException e) {
            System.out.println("[CAUGHT EXCEPTION] " + e.getMessage());
            System.out.printf("  Requested Amount : Rs. %.2f%n", e.getRequestedAmount());
            System.out.printf("  Available Balance: Rs. %.2f%n", e.getCurrentBalance());
            System.out.printf("  Shortage/Deficit : Rs. %.2f%n", e.getDeficit());
        } finally {
            System.out.println("Transaction check completed.");
        }
        System.out.println();

        System.out.println("Final Account State:");
        account.displaySummary();
    }
}
