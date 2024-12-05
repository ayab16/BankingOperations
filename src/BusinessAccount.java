class BusinessAccount extends Account {
    private static final double TRANSACTION_FEE = 5;

    public BusinessAccount(String accountNumber, double initialBalance) {
        super(accountNumber, initialBalance);
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        double totalAmount = amount + TRANSACTION_FEE;
        if (balance < totalAmount) {
            throw new InsufficientFundsException("Insufficient funds for withdrawal (including transaction fee).");
        }
        balance -= totalAmount;
        System.out.println("Withdrew: $" + amount + " (Fee: $" + TRANSACTION_FEE + ") | New Balance: $" + balance);
    }
}