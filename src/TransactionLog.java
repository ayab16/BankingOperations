// Interface for transaction logging
interface TransactionLog {
    void recordTransaction(String details);
}

// Extend Account to include transaction logging
class LoggedSavingsAccount extends SavingsAccount implements TransactionLog {
    public LoggedSavingsAccount(String accountNumber, double initialBalance) {
        super(accountNumber, initialBalance);
    }

    @Override
    public void recordTransaction(String details) {
        System.out.println("Transaction Recorded: " + details);
    }
}
