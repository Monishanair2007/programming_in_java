// Savings Account class
class SavingsAccount extends Account {

    private double minBalance = 500;

    public SavingsAccount(int accNo, double bal) {
        super(accNo, bal);
    }

    // Override deposit
    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Savings Deposited: " + amount);
    }

    // Override withdraw
    @Override
    public void withdraw(double amount) {
        if (balance - amount >= minBalance) {
            balance -= amount;
            System.out.println("Savings Withdrawn: " + amount);
        } else {
            System.out.println("Minimum balance must be maintained");
        }
    }

    // Display method
    @Override
    public void display() {
        System.out.println("Savings Account | Acc No: " + accountNumber + " | Balance: " + balance);
    }
}