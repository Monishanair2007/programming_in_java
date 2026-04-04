// Loan Account class
class LoanAccount extends Account {

    public LoanAccount(int accNo, double loan) {
        super(accNo, loan);
    }

    // Override deposit (loan repayment)
    @Override
    public void deposit(double amount) {
        balance -= amount;
        System.out.println("Loan payment: " + amount);
    }

    // Override withdraw (not allowed)
    @Override
    public void withdraw(double amount) {
        System.out.println("Withdrawal not allowed in Loan Account");
    }

    // Display method
    @Override
    public void display() {
        System.out.println("Loan Account | Acc No: " + accountNumber + " | Loan Remaining: " + balance);
    }
}