class SavingsAccount extends Account {
    private static final double MIN_BALANCE = 100;

    public SavingsAccount(String accountNumber, double initialBalance) {
        super(accountNumber, initialBalance);
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if (balance - amount < MIN_BALANCE) {
            throw new InsufficientFundsException("Withdrawal denied. Minimum balance of $" + MIN_BALANCE + " must be maintained.");
        }
        balance -= amount;
        System.out.println("Withdrew: $" + amount + " | New Balance: $" + balance);
    }
}